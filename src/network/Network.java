// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/network/Network.java

package network;
import java.io.*;
import java.net.*;

// 네트워크 연결 및 입출력 클래스
public class Network
{
	public static final int serverPort = 7700;
	protected ServerSocket serverSocket;
	protected Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Thread waitForCounterpart;

	// 네트워크 클래스 초기화
	public Network() {
		serverSocket = null;
		socket = null;
		in = null;
		out = null;
		waitForCounterpart = null;
	}

	// 네트워크 서버 연결 초기화
	public void connectAsServer( Runnable obj ) {
		try {
			// 서버 소켓 연결
			serverSocket = new ServerSocket( serverPort );
			// 클라이언트에서 서버로 연결 요청시 연결 활성화
			socket = serverSocket.accept();
			// 네트워크 입출력 연결 후 데이터가 도착할 때까지 대기
			connectInOut( obj );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	// 네트워크 클라이언트 연결 초기화
	public void connectAsClient( String serverIP, Runnable obj ) {
		try {
			// 클라이언트에서 서버로 연결 요청
			socket = new Socket( serverIP, serverPort );
			// 네트워크 입출력 연결 후 데이터가 도착할 때까지 대기
			connectInOut( obj );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	// 네트워크 입출력 초기화
	public void connectInOut( Runnable obj ) {
		try {
			// 네트워크 입출력 연결
			in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
			out = new PrintWriter( socket.getOutputStream(), true );
			// 네트워크에 데이터가 도착할 때까지 대기 시작
			waitForCounterpart = new Thread( obj );
			waitForCounterpart.start();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	// 상대편이 네트워크로 보낸 데이터 읽기
	public String read() {
		try {
			if ( this.isConnecting() == true )
				return in.readLine();
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return null;
	}

	// 상대편에게 네트워크로 데이터 전송
	public void write( String data ) {
		try {
			if ( this.isConnecting() == true )
				out.println( data );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	// 네트워크 연결 상태 확인
	public boolean isConnecting() {
		if ( ( socket != null )
				&& ( in != null )
				&& ( out != null )
				&& ( waitForCounterpart != null )
				&& ( waitForCounterpart.getState() != Thread.State.TERMINATED ) )
			return true;
		else
			return false;
	}

	// 네트워크 종료
	public void close() {
		try {
			if ( waitForCounterpart != null ) {
				waitForCounterpart.interrupt();
				waitForCounterpart = null;
			}
			if ( in != null ) {
				in.close();
				in=null;
			}
			if ( out != null ) {
				out.flush();
				out.close();
				out = null;
			}
			if ( socket != null ) {
				socket.close();
				socket = null;
			}
			if ( serverSocket != null ) {
				serverSocket.close();
				serverSocket = null;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}

