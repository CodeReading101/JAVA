// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter04/Time.java

import java.util.Scanner;
public class Time
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int totalSeconds = 0;
		int hours = 0, minutes = 0, seconds = 0;
		// 사용자에게 전체 초를 입력받기
		System.out.print( "초를 입력하세요: " );
		totalSeconds = scan.nextInt();
		// 전체 초의 시, 분, 초를 계산
		hours  = totalSeconds / ( 60 * 60 );
		minutes = ( totalSeconds % ( 60 * 60 ) ) / 60;
		seconds = totalSeconds % 60;
		// 시, 분, 초를 출력
		System.out.print( totalSeconds + "초는 " + hours + "시간 " + minutes + "분 " + seconds + "초입니다." );
	}
}

