// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/remoteControl/RemoteControlNetwork.java

package remoteControl;
import java.awt.event.ActionEvent;
import network.Network;

// 리모컨 프로그램의 네트워크 담당 클래스
public class RemoteControlNetwork extends RemoteControllerPanel implements Runnable
{
	private Network network;
	private String  id;
	private final String header = "[RMTC] ";

	// 가전 네트워크 초기화
	// 리모컨 네트워크 초기화
	public RemoteControlNetwork( String imgPath, String serverIP ) {
		super( imgPath );
		connectAsClient( serverIP, this.getClass().getSimpleName() );
	}

	// TV,로봇청소기,에어컨 네트워크 초기화
	public RemoteControlNetwork( RemoteControl appliance, String serverIP ) {
		super( appliance );
		connectAsClient( serverIP, appliance.getClass().getSimpleName() );
	}

	 // 네트워크 클라이언트 연결 초기화
	public void connectAsClient( String serverIP, String applianceName ) {
		id = "[" + applianceName +"]";
		network = new Network();
		network.connectAsClient( serverIP, this );
	}

	// 리모컨 버튼 클릭시 가전제품에게 결과 전송
	@Override
	public void actionPerformed( ActionEvent event ) {
		String message = "";
		// 리모컨 클릭 결과 확인
		if ( event.getSource() == button[POWER] )
			message = header + "POWER";
		else if ( event.getSource() == button[UP] )
			message = header + "UP";
		else if ( event.getSource() == button[DOWN] )
			message = header + "DOWN";
		else if ( event.getSource() == button[LEFT] )
			message = header + "LEFT";
		else if ( event.getSource() == button[RIGHT] )
			message = header + "RIGHT";

		// 상대편에게 네트워크로 리모컨 클릭 결과 전송
		network.write( message );
	}

	// 리모컨 클릭 결과 도착시 가전제품 상태 업데이트
	@Override
	public void run(){
		// 상대편이 네트워크로 보낸 데이터 읽기
		for ( String message = null; ( message = network.read() ) != null; ) {
			// 리모컨 프로그램 메시지가 아니면 무시
			if ( !message.contains( header ) )
				continue;
			// 읽은 데이터를 바탕으로 가전제품 상태 업데이트
			else if ( message.contains( "POWER" ) && ( appliance != null ) )
				appliance.clickPower();
			else if ( message.contains( "UP" ) && ( appliance != null ) )
				appliance.clickUp();
			else if ( message.contains( "DOWN" ) && ( appliance != null ) )
				appliance.clickDown();
			else if ( message.contains( "LEFT" ) && ( appliance != null ) )
				appliance.clickLeft();
			else if ( message.contains( "RIGHT" ) && ( appliance != null ) )
				appliance.clickRight();
		}
	}

	// 가전 네트워크 종료
	public void close() {
		network.write( header + id + " 네트워크 연결 종료" );
		// 네트워크 종료
		network.close();
	}
}

