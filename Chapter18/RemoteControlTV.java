// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter18/RemoteControlTV.java

import javax.swing.*;
import java.awt.event.*;
import remoteControl.*;

// 리모컨으로 제어하는 가전제품 프로그램의 네트워크 클라이언트 버전
public class RemoteControlTV
{
	public static void main( String[] args ) {
		final String imagePath = "C:\\Users\\user\\Downloads\\JAVA-main\\src\\remoteControl\\image\\";
		String serverIP = "localhost";
		RemoteControl appliance = new TVPanel( imagePath );
		RemoteControlNetwork panel = new RemoteControlNetwork( appliance, serverIP );

		JFrame frame = new JFrame( "TV(클라이언트)" );
		frame.getContentPane().add( (JPanel)appliance );
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

