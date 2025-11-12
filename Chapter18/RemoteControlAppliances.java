// 파일명 : ./Chapter18/RemoteControlAppliances.java
import javax.swing.*;
import java.awt.event.*;
import remoteControl.*;

// 리모컨으로 제어하는 가전제품 프로그램의 네트워크 클라이언트 버전
public class RemoteControlAppliances
{
	public static void main( String[] args ) {
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\remoteControl\\image\\";
		String serverIP = "localhost";
		String[] applianceName = { "TV(클라이언트)", "로봇청소기(클라이언트)", "에어컨(클라이언트)" };
		RemoteControl[] appliance = { 
		                              new TVPanel( imagePath ), 
		                              new RobotCleanerPanel( imagePath ),
		                              new AirConditionerPanel(), 
		                            };
		for ( int i = 0; i < appliance.length; i++ ) {
			RemoteControlNetwork panel = 
			                             new RemoteControlNetwork( appliance[i], serverIP );
		
			JFrame frame = new JFrame( applianceName[i] );
			frame.getContentPane().add( (JPanel)appliance[i] );
			frame.addWindowListener( new WindowAdapter() {
				public void windowClosing( WindowEvent event ) { 
					panel.close();
				}
			} );
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			frame.pack();
			frame.setVisible( true );
		}
	}
}
