// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter02/Birthday.java

import java.util.Scanner;
public class Birthday
{
	public static void main( String[] args ) {
		// 년, 월, 일 초기화
		Scanner scan = new Scanner( System.in );
		int year  = 0;
		int month = 0;
		int day   = 0;
		// 사용자의 생년월일을 입력
		System.out.print( "당신이 태어난 년도를 입력하세요: " );
		year = scan.nextInt();
		System.out.print( "당신이 태어난 달을 입력하세요: " );
		month = scan.nextInt();
		System.out.print( "당신이 태어난 날을 입력하세요: " );
		day = scan.nextInt();
		// 사용자의 생년월일을 출력
		System.out.println( "당신은 " + year + "년 " + month + "월 " + day + "일에 태어났군요. 당신은 ♪~ 사랑받기 위해 ♪~ 태어난 사람 ♬~~ " );
	}
}

