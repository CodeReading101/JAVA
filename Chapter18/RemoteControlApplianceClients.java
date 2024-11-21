// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter18/RemoteControlApplianceClients.java

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import remoteControl.RemoteControl;
import remoteControl.RemoteControlNetwork;
import remoteControl.TVPanel;
import remoteControl.AirConditionerPanel;
import remoteControl.RoboticVacuumCleanerPanel;

/**************
 * 리모컨으로 제어하는 가전제품 프로그램의 네트워크 클라이언트 버전
 * @author So Young Park
 * @version 0.8
 */
public class RemoteControlApplianceClients
{
	public static void main(String[] args)
	{
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\remoteControl\\image\\";
		String serverIP = "localhost";
		String[] applianceName = { "TV(클라이언트)", "에어컨(클라이언트)", "로봇청소기(클라이언트)" };
		RemoteControl[] appliance = { new TVPanel( imagePath ), new AirConditionerPanel(), new RoboticVacuumCleanerPanel( imagePath ) };
		for ( int i = 0; i < appliance.length; i++  )
		{
			RemoteControlNetwork panel = new RemoteControlNetwork( imagePath, appliance[i], serverIP );

			JFrame frame = new JFrame( applianceName[i] );
			frame.getContentPane().add( (JPanel)appliance[i] );
			frame.addWindowListener( new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					panel.close();
				}
			} );
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			frame.pack();
			frame.setVisible( true );
		}
	}
}

