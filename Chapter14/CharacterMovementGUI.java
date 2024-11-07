// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter14/CharacterMovementGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 캐릭터 패널
class CharacterMovementPanel extends JPanel
{
	private int x, y, maxX, maxY;
	private int[][] map;
	private Image[] image;
	private final int SIZE = 40, SCOPE = 3, CHARACTER = 2, WALL = 1;
	// 캐릭터 패널 준비
	public CharacterMovementPanel( int[][] map, final String imagePath ){
		// 캐릭터 초기화 : 미로 맵에서 위치 및 이동 가능 범위
		this.x = 5;
		this.y = 5;
		this.map = map;
		this.maxX = map[0].length-1;
		this.maxY = map.length-1;
		// 이미지 초기화 : 캐릭터, 길, 벽
		this.image = new Image[3];
		this.image[0] = new ImageIcon( imagePath + "path.png" ).getImage();
		this.image[1] = new ImageIcon( imagePath + "wall.png" ).getImage();
		this.image[2] = new ImageIcon( imagePath + "character.png" ).getImage();
		setPreferredSize( new Dimension( SIZE*(2*SCOPE+1), SIZE*(2*SCOPE+1) ) );
		// 키보드 입력 시 반응할 리스너 등록
		addKeyListener( new ArrowKeyListener() );
		setFocusable( true );
		requestFocus();
	}
	private class ArrowKeyListener extends KeyAdapter {
		// 키보드 입력 시 반응
		public void keyPressed( KeyEvent e ) {
			// 입력키에 따라 상하좌우로 이동후 화면 업데이트
			switch( e.getKeyCode() ) {
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			case KeyEvent.VK_LEFT: case 'A': case 'a':
				move( -1, 0 );
				break;
			case KeyEvent.VK_RIGHT: case 'D': case 'd':
				move( +1, 0 );
				break;
			case KeyEvent.VK_UP: case 'W': case 'w':
				move( 0, -1 );
				break;
			case KeyEvent.VK_DOWN: case 'S': case 's':
				move( 0, +1 );
				break;
			}
			repaint();
		}
	}
	// 새 위치를 이동 가능한 위치로 조정
	public void move( int x, int y ) {
		this.x += x;
		this.y += y;
		this.x = ( this.x <= 0 ) ? 0 : this.x;
		this.y = ( this.y <= 0 ) ? 0 : this.y;
		this.x = ( this.x >= maxX ) ? maxX : this.x;
		this.y = ( this.y >= maxY ) ? maxY : this.y;
		if( map[this.y][this.x] == WALL ) {
			this.x -= x;
			this.y -= y;
		}
	}
	// 캐릭터를 중심으로 일정 범위내 주변 맵으로 화면 업데이트
	public void paint( Graphics g ){
		super.paint( g );
		for( int y = this.y - SCOPE, y2 = 0; y <= this.y + SCOPE; y++, y2++ ){
			for( int x = this.x - SCOPE, x2 = 0; x <= this.x + SCOPE; x++, x2++ ){
				int index = WALL;
				if ( ( this.x == x ) && ( this.y == y ) )
					index = CHARACTER;
				else if ( ( 0 <= x ) && ( x <= maxX ) && ( 0 <= y ) && ( y <= maxY ) )
					index = map[y][x];
				g.drawImage( this.image[index], x2*SIZE, y2*SIZE, SIZE, SIZE, null );
			}
		}
	}
}
public class CharacterMovementGUI
{
	public static void main( String[] args )
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\Chapter14\\image\\";
		// 미로 맵을 2차원 배열로 초기화
		int[][] map = { { 1,1,1,1,1,1,1,1,1,1,1 },
		                { 1,0,0,0,1,0,0,0,0,0,1 },
		                { 1,1,1,0,1,0,1,1,1,0,1 },
		                { 1,0,0,0,1,0,0,0,1,0,1 },
		                { 1,0,1,1,1,1,1,1,1,0,1 },
		                { 1,0,0,0,1,0,0,0,0,0,1 },
		                { 1,1,1,0,1,1,1,1,1,0,1 },
		                { 1,0,0,0,1,0,0,0,0,0,1 },
		                { 1,0,1,1,1,1,1,0,1,0,1 },
		                { 1,0,0,0,0,0,0,0,0,0,1 },
		                { 1,1,1,1,1,1,1,1,1,1,1 }
		              };
		// 틀 준비
		JFrame frame = new JFrame( "미로맵" );
		// 패널 준비
		CharacterMovementPanel panel = new CharacterMovementPanel( map, imagePath );
		// 틀에 패널 끼우고 실행 준비 완료
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}
}

