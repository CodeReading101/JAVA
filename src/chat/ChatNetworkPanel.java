// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/chat/ChatNetworkPanel.java

package chat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import network.Network;

// 채팅 네트워크 패널 클래스
public class ChatNetworkPanel extends JPanel implements ActionListener, Runnable
{
	private JTextArea  chatWindow;
	private JTextField inputField;
	private Network network;
	private String  id;
	private final String header = "[CHAT] ";

	// 채팅 패널 초기화
	public ChatNetworkPanel() {
		// 채팅창
		chatWindow = new JTextArea();
		chatWindow.setBackground( Color.lightGray );
		chatWindow.setEditable( false );
		chatWindow.setLineWrap( true );
		// 채팅창이 길어지면 스크롤 활성화
		JScrollPane scroll = new JScrollPane( chatWindow );
		scroll.setPreferredSize( new Dimension( 290, 360 ) );
		add( scroll );
		inputField = new JTextField();
		inputField.setPreferredSize( new Dimension( 290, 30 ) );
		inputField.addActionListener( this );
		inputField.requestFocus();
		add( inputField );
		setVisible( true );
	}

	// 채팅 네트워크 클라이언트 초기화
	public ChatNetworkPanel( String serverIP ) {
		// 채팅 패널 초기화
		this();

		// 네트워크 초기화
		network = new Network();
		network.connectAsClient( serverIP, this );

		id = "[" + JOptionPane.showInputDialog( this, "아이디를 입력해주세요.", "아이디" ) + "]";
		network.write( header + id + "님이 들어오셨습니다" );
	}
	// 대화 내용 입력시 상대편에게 전송
	@Override
	public void actionPerformed( ActionEvent event ) {
		// 입력한 대화 내용 읽기
		String message = inputField.getText();
		// 상대편에게 네트워크로 대화 내용 전송
		network.write( header + id + message );
		inputField.setText( "" );
	}

	// 대화 내용 도착시 채팅 화면 업데이트
	@Override
	public void run() {
		// 상대편이 네트워크로 보낸 데이터 읽기
		for ( String message = null; ( message = network.read() ) != null; ) {
			// 채팅 프로그램 대화 내용이 아니면 메시지 무시
			if ( !message.contains( header ) )
				continue;

			// 채팅 화면에 읽은 대화 내용 쓰기
			chatWindow.append( message.substring( header.length() ) + "\n" );
			chatWindow.setCaretPosition( chatWindow.getText().length() );
		}
	}

	// 채팅 네트워크 종료
	public void close() {
		network.write( header + " " + id + "님이 나가셨습니다" );
		// 네트워크 종료
		network.close();
	}
}

