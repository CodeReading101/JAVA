// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter15/InputOutputStreamException.java

import java.io.*;
public class InputOutputStreamException {
	public static void main( String[] args )
	                                         throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		// 이름 입력
		bw.write( "이름을 입력하세요: " );
		bw.flush();
		String name = br.readLine();
		// 인사말 출력
		bw.write( "안녕하세요, " + name + "님. 만나서 반갑습니다" );
		bw.flush();
		bw.close();
		br.close();
	}
}

