// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter17/MultiThreadChatClient.java

import chat.ChatNetwork;

// 1:1 채팅(클라이언트)
public class MultiThreadChatClient
{
	public static void main(String[] args) {
		new ChatNetwork( "localhost" );
	}
}

