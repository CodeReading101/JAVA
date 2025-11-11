// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/network/ThreadPerClient.java

package network;
import java.io.*;
import java.net.*;
import java.util.*;
// 클라이언트 전담 스레드
public class ThreadPerClient extends Thread
{
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<ThreadPerClient> clients;
	// 클라이언트 전담 스레드 초기화
	public ThreadPerClient( Socket socket, ArrayList<ThreadPerClient> clients ) {
		super();
		try {
			// 네트워크 입출력 초기화
			this.in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			this.out = new PrintWriter( socket.getOutputStream(), true );
			this.socket = socket;
			this.clients = clients;
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	// 클라이언트 전담 스레드 시작
	@Override
	public void run() {
		try {
			// 담당 클라이언트에서 보낸 데이터를 읽기
			for( String data = null; ( data = in.readLine() ) != null; ) {
				System.out.println("[Server] 데이터 도착 : " + this + " " + data );
				// 전체 클라이언트에게 데이터를 보내기
				for( ThreadPerClient client : clients ) {
					client.write( data );
				}
			}
		} catch ( Exception e ) {
			close();
			e.printStackTrace();
		}
	}
	// 담당 클라이언트에게 데이터 보내기
	public void write( String data ) {
		try {
			// 담당 클라이언트와 네트워크 연결 종료시 데이터 전송 불가
			if ( this.getState() == Thread.State.TERMINATED ) {
				System.out.println( "[Server] 클라이언트 연결 해제 : " + this );
				close();
			}
			// 담당 클라이언트와 네트워크 연결 유효시 데이터 전송
			else if ( out != null ) {
				System.out.println("[Server] 데이터 전송 : " + this + " " + data );
				out.println( data );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	// 담당 클라이언트의 네트워크 종료
	public void close() {
		try {
			if( socket != null ) {
				socket.close();
				socket = null;
			}
			if( in != null ) {
				in.close();
				in = null;
			}
			if( out != null ) {
				out.close();
				out = null;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}

