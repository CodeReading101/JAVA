// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter10/MonthName.java

import java.util.Scanner;

public class MonthName
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 사용자에게 달을 입력받기
		System.out.print( "1월~12월 사이의 월을 입력하세요: " );
		int month = scan.nextInt();
		// 해당 달의 영어 단어를 출력
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		System.out.print( month + "월은 " + monthName[ month - 1 ] + "입니다." );
		scan.close();
	}
}

