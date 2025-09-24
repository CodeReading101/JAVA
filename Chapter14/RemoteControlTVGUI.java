// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter14/RemoteControlTVGUI.java

import java.awt.*;
import javax.swing.JFrame;
import remoteControl.RemoteControllerPanel;
import remoteControl.TVPanel;

/**************
 * 리모컨으로 제어하는 TV 프로그램의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */
public class RemoteControlTVGUI
{
	public static void main( String[] args )
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\remoteControl\\image\\";

		// 판을 틀에 끼우고 실행 준비 완료
		TVPanel appliance = new TVPanel( imagePath );
		RemoteControllerPanel remoteController = new RemoteControllerPanel( imagePath, appliance );
		JFrame frame = new JFrame( "TV" );
		frame.setLayout( new BorderLayout() );
		frame.add( remoteController, BorderLayout.WEST );
		frame.add( appliance, BorderLayout.EAST );
		frame.setPreferredSize( new Dimension( 600,170 ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


