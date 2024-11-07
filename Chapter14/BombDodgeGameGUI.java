// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter14/BombDodgeGameGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.util.ArrayList;
// 개체 클래스
class Entity
{
	private Image image;
	private int x, y, maxX, maxY;
	private final int SPEED = 20, WIDTH = 25, HEIGHT = 35, MARGIN = 25;
	public static final int LEFT = -1, RIGHT = 1, UP = -1, DOWN = 1, STOP = 0;
	// 초기화 : 이미지, 위치, 이동 가능 범위
	public Entity( final String image, int x, int y, int bgWidth, int bgHeight ) {
		this.image = new ImageIcon( image ).getImage();
		this.x = x;
		this.y = y;
		this.maxX = bgWidth - WIDTH - MARGIN;
		this.maxY = bgHeight- HEIGHT- MARGIN;
	}
	//  초기화 : 화면 위쪽의 임의의 x 위치에서 폭탄 투하
	public Entity( final String image, int bgWidth, int bgHeight ) {
		this( image, 0, 50, bgWidth, bgHeight );
		this.x = (int)( Math.random() * maxX );
	}
	// 일정 속도로 위치 이동
	public void move( int x, int y ) {
		this.x += SPEED * x;
		this.y += SPEED * y;
		this.x = ( this.x > MARGIN) ? this.x : MARGIN;
		this.x = ( this.x < maxX  ) ? this.x : maxX;
		this.y = ( this.y > MARGIN) ? this.y : MARGIN;
		this.y = ( this.y < maxY  ) ? this.y : maxY;
	}
	public static void move( ArrayList<Entity> bombs ) {
		for ( int i = 0; i < bombs.size(); i++ ) {
			Entity bomb = bombs.get(i);
			bomb.move( STOP, DOWN );
			// 화면 경계선 밖의 폭탄은 화면에 안 보이므로 삭제
			if ( ( bomb.collide() == true ) )
				bombs.remove( bomb );
		}
	}
	// 화면 경계선이나 폭탄과 충돌 여부 확인
	public boolean collide() {
		return ( x < MARGIN ) || ( maxX <= x ) || ( y < MARGIN ) || ( maxY <= y );
	}
	private boolean collide( Entity bomb ) {
		return ( Math.abs( this.x - bomb.x ) < MARGIN ) && ( Math.abs( this.y - bomb.y ) < MARGIN );
	}
	public boolean collide( ArrayList<Entity> bombs ) {
		for ( Entity bomb : bombs ) {
			if ( this.collide( bomb ) == true )
				return true;
		}
		return false;
	}
	// 최신 위치를 기준으로 화면 업데이트
	public void paint( Graphics g ) {
		g.drawImage( image, x, y, WIDTH, HEIGHT, null );
	}
	public static void paint( ArrayList<Entity> bombs, Graphics g ) {
		for ( Entity bomb : bombs )
			bomb.paint( g );
	}
}
// 폭탄 피하기 패널
class BombDodgePanel extends JPanel
{
	protected Entity character;
	private int characterX;
	private int characterHP;
	private ArrayList<Entity> bombs;
	protected String imageBomb;
	private int time; // 이벤트 주기 컨트룰 단위 변수
	private Timer timer;
	private final int WIDTH = 300; // 패널 폭
	private final int HEIGHT= 600; // 패널 높이
	// 폭탄 피하기 패널 준비
	public BombDodgePanel( final String imgPath ) {
		// 폭탄 및 캐릭터 초기화
		bombs = new ArrayList<Entity>();
		imageBomb = imgPath + "bomb.png";
		character = new Entity( imgPath + "character.png", WIDTH/2, HEIGHT-60, WIDTH, HEIGHT );
		characterX = character.STOP;
		characterHP = 5;
		setBackground( Color.white );
		setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
		// 키보드 입력 시 반응할 리스너 등록
		addKeyListener( new MyKeyListener() );
		setFocusable( true );
		requestFocus();
		// 일정 시간마다 반응할 타이머 시작
		timer = new Timer( 40, new TimerListener() );
		timer.start();
		this.time = 300;
	}
	// 키보드 입력 시 반응
	private class MyKeyListener extends KeyAdapter {
		// 키를 눌렀을 때 캐릭터 좌우 이동방향 설정
		public void keyPressed( KeyEvent e ) {
			switch( e.getKeyCode() ) {
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			case KeyEvent.VK_LEFT: case 'A': case 'a':
				characterX = character.LEFT;
				break;
			case KeyEvent.VK_RIGHT: case 'D': case 'd':
				characterX = character.RIGHT;
				break;
			}
		}
		// 키를 뗐을 때 캐릭터 멈춤
		public void keyReleased( KeyEvent e ) {
			switch( e.getKeyCode() ) {
			case KeyEvent.VK_LEFT: case 'A': case 'a':
			case KeyEvent.VK_RIGHT: case 'D': case 'd':
				characterX = character.STOP;
				break;
			}
		}
	}
	// 일정 시간마다 반응
	private class TimerListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			// 모든 폭탄은 아래로 떨어지며, 주기적으로 새 폭탄을 추가
			Entity.move( bombs );
			if ( ( ( time-- ) % 8 ) == 0 )
				bombs.add(
				           new Entity( imageBomb, WIDTH, HEIGHT ) );
			// 플레이어는 좌우로 이동하며, 폭탄과 충돌하면 HP 감소
			character.move( characterX, character.STOP );
			if( character.collide( bombs ) == true )
				characterHP--;
			// 최신 정보로 화면 업데이트
			repaint();
		}
	}
	// 화면 업데이트
	public void paint( Graphics g ) {
		super.paint( g );
		// 화면 첫줄에 HP 출력
		g.setColor( Color.black );
		g.setFont( new Font( "Arial", Font.BOLD, 40 ) );
		g.drawString( "HP : " + hp(), 20, 50 );
		// 제한시간동안 폭탄을 피해 살아남으면 성공 종료 화면
		if ( this.time <= 0 ) {
			g.drawString( "Success!", WIDTH/2-100, HEIGHT/2 );
			timer.stop();
		}
		// HP가 더 이상 없으면 실패 종료 화면
		else if ( this.characterHP <= 0 ) {
			g.drawString( "Game Over!", WIDTH/2-100, HEIGHT/2 );
			timer.stop();
		}
		// 폭탄 및 캐릭터의 현재 위치를 바탕으로 게임 진행 화면
		else {
			Entity.paint( bombs, g );
			character.paint( g );
		}
	}
	// HP를 문자열로 표현
	public String hp() {
		switch( this.characterHP ) {
		case 5:
			return "● ● ● ● ●";
		case 4:
			return "● ● ● ● ○";
		case 3:
			return "● ● ● ○ ○";
		case 2:
			return "● ● ○ ○ ○";
		case 1:
			return "● ○ ○ ○ ○";
		default:
			return "○ ○ ○ ○ ○";
		}
	}
}
public class BombDodgeGameGUI
{
	public static void main( String[] args )
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\Chapter14\\image\\";
		// 틀 준비
		JFrame frame = new JFrame ( "폭탄 피하기 게임" );
		// 패널 준비
		BombDodgePanel panel = new BombDodgePanel( imagePath );
		// 틀에 패널 끼우고 실행 준비 완료
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}

