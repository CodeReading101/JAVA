// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/network/MultiClientServer.java

package network;
import java.net.*;
import java.util.*;

// 멀티클라이언트 서버 클래스
public class MultiClientServer
{
	private ServerSocket serverSocket;
	private ArrayList<ThreadPerClient> clients;

	// 멀티클라이언트 서버 초기화
	public MultiClientServer() {
		try {
			// 서버 소켓 연결
			serverSocket = new ServerSocket( Network.serverPort );
			clients = new ArrayList<ThreadPerClient>();
			System.out.println( "[Server] 서버 대기중" );

			// 각 클라이언트마다 반복
			while ( true ) {
				// 네트워크 연결 활성화
				Socket socket = serverSocket.accept();
				// 네트워크 입출력 초기화
				ThreadPerClient client = new ThreadPerClient( socket, clients );
				clients.add( client );
				// 클라이언트 전담 스레드 시작
				client.start();
				System.out.println( "[Server] 클라이언트 연결 : " + client );
			}
		} catch ( Exception e ) {
			close();
			e.printStackTrace();
		}

	}

	// 멀티클라이언트 서버 종료
	public void close() {
		try {
			// 클라이언트 전담 스레드 전체 종료
			for ( ThreadPerClient client : clients ) {
				client.close();
				client.interrupt();
				clients.remove( client );
			}

			// 서버 소켓 종료
			if ( serverSocket != null ) {
				serverSocket.close();
				serverSocket = null;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}

