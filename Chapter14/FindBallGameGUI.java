// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter14/FindBallGameGUI.java

import javax.swing.JFrame;
import find.BallGamePanel;

/**************
 * 구슬찾기 게임의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */
public class FindBallGameGUI
{
	public static void main( String[] args )
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\find\\image\\";
		BallGamePanel panel = new BallGamePanel( imagePath );

		JFrame frame = new JFrame( "구슬찾기" );
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


