// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter03/BirthdaySong.java

import java.util.Scanner;
public class BirthdaySong
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 이름을 입력
		System.out.print( "이름을 입력하세요: " );
		String name = scan.next();
		// 생일 축하 노래를 출력
		System.out.println( "생일 축하합니다. 생일 축하합니다. 사랑하는 " + name + "의 생일 축하합니다." );
		scan.close();
	}
}

