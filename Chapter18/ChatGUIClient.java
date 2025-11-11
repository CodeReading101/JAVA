// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter18/ChatGUIClient.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import chat.ChatNetworkPanel;

// 채팅 GUI 클라이언트
public class ChatGUIClient
{
	public static void main( String[] args ) {
		String serverIP = "localhost";
		ChatNetworkPanel panel = new ChatNetworkPanel( serverIP );

		JFrame frame = new JFrame( "채팅(클라이언트)" );
		frame.getContentPane().add( panel );
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent event ) {
				panel.close();
			}
		} );

		frame.setPreferredSize( new Dimension( 320, 445 ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}
}


