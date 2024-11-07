// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter14/RemoteControlRoboticVacuumCleanerGUI.java

import java.awt.*;
import javax.swing.JFrame;
import remoteControl.RemoteControllerPanel;
import remoteControl.RoboticVacuumCleanerPanel;

/**************
 * 리모컨으로 제어하는 로봇청소기 프로그램의 GUI 버전
 * @author So Young Park
 * @version 0.8
 */
public class RemoteControlRoboticVacuumCleanerGUI
{
	public static void main(String[] args)
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\remoteControl\\image\\";
		RoboticVacuumCleanerPanel appliance = new RoboticVacuumCleanerPanel( imagePath );
		RemoteControllerPanel remoteController = new RemoteControllerPanel( appliance, imagePath );

		JFrame frame = new JFrame( "로봇청소기" );
		frame.setLayout( new BorderLayout() );
		frame.add( appliance, BorderLayout.EAST );
		frame.add( remoteController, BorderLayout.WEST );
		frame.setPreferredSize( new Dimension( 600,170 ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}


