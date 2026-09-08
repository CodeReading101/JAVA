// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter07/BusFare.java

import java.util.Scanner;

public class BusFare
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 사용자의 나이를 입력
		System.out.print( "나이를 입력하세요: " );
		int age = scan.nextInt();
		// 나이에 맞는 버스 요금을 출력
		// 영유아(만 5세 이하)는 무료
		if ( age <= 5 ) {
			System.out.print( "버스 요금은 무료입니다." );
		}
		// 초등학생(만 6세 ~ 만 12세)은 현금 기준 550원
		else if ( ( 6 <= age ) && ( age <= 12 ) ) {
			System.out.print( "버스 요금은 550원입니다." );
		}
		// 청소년(만 13세 ~ 만 18세)은 현금 기준 1,000원
		else if ( ( 13 <= age ) && ( age <= 18 ) ) {
			System.out.print( "버스 요금은 1,000원입니다." );
		}
		// 성인(만 19세 이상)은 현금 기준 1,500원
		else {
			System.out.print( "버스 요금은 1,500원입니다." );
		}
		scan.close();
	}
}

