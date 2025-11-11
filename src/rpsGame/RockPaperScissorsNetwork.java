// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/rpsGame/RockPaperScissorsNetwork.java

package rpsGame;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import network.Network;

// 가위바위보 네트워크 클래스
public class RockPaperScissorsNetwork extends RockPaperScissorsPanel implements Runnable
{
	private Network network;
	private int counterpart;
	private final String header = "[RPSN] ";
	private final String disconnectMessage = " -1";

	// 가위바위보 네트워크 초기화
	public RockPaperScissorsNetwork( String imgPath ) {
		super( imgPath );
		super.timer.stop();
		super.show( QUESTIONMARK, QUESTIONMARK );
		super.strPlayers.setText( "<html><body style='text-align:center;'>상대편이 준비중입니다 기다려주세요<br>[나]</body></html>" );
		network = new Network();
	}

	// 가위바위보 클라이언트 초기화
	public RockPaperScissorsNetwork( String imgPath, String serverIP ) {
		this( imgPath );
		network.connectAsClient( serverIP, this );
		network.write( header + " " + super.PAPER );
	}

	// 가위바위보 서버 초기화
	public void connectAsServer() {
		network.connectAsServer( this );
	}

	// 가위바위보 선택시 게임 업데이트
	@Override
	public void actionPerformed( ActionEvent event ) {
		// 먼저, 선택 결과를 바탕으로 게임 업데이트
		int player = super.select( event );
		super.show( player, counterpart );
		// 상대편에게 네트워크로 선택 결과를 전송
		network.write( header + " " + player );
	}

	// 가위바위보 도착시 게임 업데이트
	@Override
	public void run() {
		// 상대편이 네트워크로 보낸 데이터를 읽기
		for ( String message = null; ( message = network.read() ) != null; ) {
			// 가위바위보 메시지가 아니면 무시
			if ( !message.contains( header ) )
				continue;
			// 상대편이 네트워크 종료했으면 안내
			else if ( message.contains( disconnectMessage ) ) {
				close();
				super.strPlayers.setText( "<html><body style='text-align:center;'>상대편이 종료하였습니다<br>[나]</body></html>" );
				super.show( QUESTIONMARK, QUESTIONMARK );
				break;
			}
			else {
				// 읽은 데이터를 바탕으로 게임 업데이트
				super.strPlayers.setText( "<html><body style='text-align:center;'>[너]<br>[나]</body></html>" );
				super.ready();
				counterpart = Integer.parseInt( message.replace( header, "" ).trim() );
			}
		}
	}

	// 가위바위보 네트워크 종료
	public void close() {
		network.write( header + " " + disconnectMessage );
		// 네트워크 종료
		network.close();
	}
}

