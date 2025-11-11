// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter17/NaiveChatClient.java

import java.io.*;
import java.net.*;
import java.util.Scanner;
// 채팅 프로그램의 네트워크 클라이언트 초기 버전
public class NaiveChatClient
{
	public static void main( String[] args ) {
		try {
			System.out.println( "[Client]님이 들어오셨습니다. 대화(종료시 quit)를 입력하세요" );
			// 네트워크 클라이언트 연결 초기화
			// 클라이언트에서 서버로 연결 요청
			Socket socket = new Socket( "localhost", 7700 );
			System.out.println( "[Server]님이 들어오셨습니다" );
			// 클라이언트에서 네트워크 입출력 초기화
			BufferedReader networkIn = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			PrintWriter networkOut = new PrintWriter( socket.getOutputStream(), true );
			Scanner scan = new Scanner( System.in );
			// 클라이언트에서 클라이언트-서버 순서대로 대화 반복
			while( true ) {
				// 클라이언트의 입력 데이터를 네트워크로 전송
				System.out.print( "[Client]" );
				String clientMessage = scan.nextLine();
				networkOut.println( clientMessage );
				// 클라이언트가 대화 종료
				if( clientMessage.contains( "quit" ) ) {
					System.out.println( "[Client]님이 나가셨습니다" );
					break;
				}
				// 서버가 네트워크로 보낸 데이터 읽고 출력
				String serverMessage = networkIn.readLine();
				System.out.println( "[Server]" + serverMessage );
			}
			// 네트워크 종료
			networkIn.close();
			networkOut.close();
			socket.close();
			scan.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}

