// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter09/Calendar.java

import java.util.Scanner;

public class Calendar
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 시작 요일 및 말일을 입력받기
		System.out.print( "일(0), 월(1), 화(2), 수(3), 목(4), 금(5), 토(6) 중에서 \n이번 달 1일은 무슨 요일인가요 : " );
		int firstDay = scan.nextInt();
		System.out.print( "이번 달 말일은 언제인가요 : " );
		int lastDay = scan.nextInt();
		// 요일 출력
		System.out.println( "   일   월   화   수   목   금   토" );
		// 1일 이전은 공백 출력
		final int SUNDAY = 0, SATURDAY = 6;
		int dayOfWeek = SUNDAY;
		for(; dayOfWeek < firstDay; dayOfWeek++ ) {
			System.out.print( "     " );
		}
		// 1일부터 말일까지 출력
		for ( int day = 1; day <= lastDay; day++, dayOfWeek++ ) {
			System.out.printf( "%5d", day );
			// 일주일씩 한 줄에 출력(일요일은 새 줄에서 시작)
			if ( dayOfWeek == SATURDAY ) {
				System.out.println();
				dayOfWeek = SUNDAY - 1;
			}
		}
		scan.close();
	}
}

