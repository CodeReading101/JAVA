// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter13/PresentDropGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
// 선물 클래스
class Present
{
	int x, y;
	// 클릭 위치에 선물 생성
	public Present( int x, int y ) {
		this.x = x;
		this.y = y;
	}
	// 선물 낙하
	public void drop() {
		this.y += 10;
	}
	// 선물 그리기
	public void paint( Graphics g ) {
		g.setColor( Color.red );
		g.fillRect( x,    y,    10, 10 );
		g.fillRect( x+20, y,    10, 10 );
		g.fillRect( x,    y+20, 10, 10 );
		g.fillRect( x+20, y+20, 10, 10 );
		g.setColor( new Color( 0, 100, 0 ) );
		g.fillRect( x+10, y,    10, 30 );
		g.fillRect( x,    y+10, 30, 10 );
	}
}
// 선물 배달 클래스
class PresentDrop extends JPanel {
	protected ArrayList<Present> presents;
	protected Image background;
	public PresentDrop( String background ) {
		this.presents = new ArrayList<Present>();
		this.background = new ImageIcon( background ).getImage();
		setPreferredSize( new Dimension( 400, 400 ) );
		setFocusable( true );
		requestFocus();
		// 마우스 클릭시 선물 생성
		this.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked( MouseEvent event ) {
				presents.add( new Present( event.getX(), event.getY() ) );
			}
		} );
		// 선물은 주기적으로 조금씩 낙하
		Timer timer = new Timer( 50, new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent event ) {
				for( Present present : presents )
					present.drop();
				repaint();
			}
		} );
		timer.start();
	}
	// 선물 및 배경의 화면 업데이트
	@Override
	public void paint( Graphics g ) {
		super.paintComponent( g );
		g.drawImage( background, 0, 0, null );
		for( Present present : presents )
			present.paint(g);
	}
}
public class PresentDropGUI
{
	public static void main(String[] args)
	{
		final String background = "C:\\Users\\user\\Downloads\\JAVA-main\\Chapter13\\image\\background.jpg";
		// 틀에 판을 끼우고 실행 준비 완료
		JFrame frame = new JFrame ( "선물 배달" );
		frame.getContentPane().add( new PresentDrop( background ) );
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}



