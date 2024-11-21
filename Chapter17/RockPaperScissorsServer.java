// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter17/RockPaperScissorsServer.java

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import rpsGame.RockPaperScissorsNetwork;

/**
 * 가위바위보 프로그램의 네트워크 서버 버전
 * @author So Young Park
 * @version 0.8
 */
public class RockPaperScissorsServer
{
	public static void main(String[] args)
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\rpsGame\\image\\";
		RockPaperScissorsNetwork panel = new RockPaperScissorsNetwork( imagePath );

		JFrame frame = new JFrame( "가위바위보(서버)" );
		frame.getContentPane().add( panel );
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				panel.close();
			}
		} );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );

		panel.connectAsServer();
	}
}


