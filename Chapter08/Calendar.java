// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter08/Calendar.java

import java.util.Scanner;
public class Calendar
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int firstDay = 0;
		int lastDay = 0;
		int day = 0;
		int dayOfWeek = 0;
		int sunday = 0;
		int saturday = 6;
		// 시작요일 및 말일 입력 받기
		System.out.print( "일(0),월(1),화(2),수(3),목(4),금(5),토(6) 중에서 \n이번달 1일은 무슨요일인가요 : " );
		firstDay = scan.nextInt();
		System.out.print( "이번달 말일은 언제인가요 : " );
		lastDay = scan.nextInt();
		// 요일 출력
		System.out.println( "   일   월   화   수   목   금   토" );
		// 1일 이전은 공백 출력
		for( dayOfWeek = sunday; dayOfWeek < firstDay; dayOfWeek++ ) {
			System.out.print( "     " );
		}
		// 1일부터 말일까지 출력
		for ( day = 1; day <= lastDay; day++, dayOfWeek++ ) {
			// 일주일을 한줄에 출력
			System.out.printf( "%5d", day );
			// 즉, 토요일 후 일요일은 새 줄에서 시작
			if ( ( dayOfWeek % 7 ) == saturday ) {
				System.out.println( "" );
			}
		}
	}
}

