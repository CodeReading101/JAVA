// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter14/RockPaperScissorsGUI.java

import javax.swing.JFrame;
import rpsGame.RockPaperScissorsPanel;

/**************
 * 가위바위보 게임의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */
public class RockPaperScissorsGUI
{
	public static void main( String[] args )
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\rpsGame\\image\\";
		RockPaperScissorsPanel panel = new RockPaperScissorsPanel( imagePath );

		JFrame frame = new JFrame( "가위바위보" );
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


