// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/chat/ChatNetwork.java

package chat;
import java.util.Scanner;
import network.Network;

// 멀티스레드 기반 1:1 채팅 클래스
public class ChatNetwork implements Runnable
{
 private Network network;

 // 채팅 서버 초기화
 public ChatNetwork() {
  System.out.println( "[Server]님이 들어오셨습니다. 대화(종료시 quit)를 입력하세요" );
  System.out.println( "[Client]님이 들어오실때까지 잠시만 기다려주세요" );

  // 네트워크 초기화
  network = new Network();
  network.connectAsServer( this );
  network.write( "[Server]님이 들어오셨습니다" );
  this.write( "[Server]" );
 }

 // 채팅 클라이언트 초기화
 public ChatNetwork( String serverIP ) {
  System.out.println( "[Client]님이 들어오셨습니다. 대화(종료시 quit)를 입력하세요" );

  // 네트워크 초기화
  network = new Network();
  network.connectAsClient( serverIP, this );
  network.write( "[Client]님이 들어오셨습니다" );
  this.write( "[Client]" );
 }

 // 입력 받은 데이터를 상대편에게 보내기
 public void write( String id ) {
  try {
   Scanner scan = new Scanner( System.in );
   // 입력한 대화 내용 읽기
   for ( String message = null; ( message = scan.nextLine() ) != null; ) {
    if( message.contains( "quit" ) ) {
     System.out.println( id + "님이 나가셨습니다" );
     network.write( id + "님이 나가셨습니다" );
     network.write( id + message );
     break;
    }
    // 상대편에게 네트워크로 데이터 전송
    network.write( id + message );
   }
   scan.close();
  } catch ( Exception e ) {
   e.printStackTrace();
  }
 }

 // 상대편에게 데이터 받아서 출력
 @Override
 public void run() {
  // 상대편이 네트워크로 보낸 데이터 읽기
  for ( String message = null; ( message = network.read() ) != null; ) {
   // 읽은 대화 내용 출력
   if( message.contains( "quit" ) ) {
    System.out.println( message );
    network.write( message );
    break;
   }
   else {
    System.out.println( message );
   }
  }
  // 채팅 종료
  network.close();
 }
}

