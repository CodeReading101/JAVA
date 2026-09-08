// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter06/FindBall.java

import java.util.Scanner;

public class FindBall
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 먼저 3개 컵 중에서 하나에 공을 숨기기
		int ball = (int)( Math.random() * 3 ) + 1;
		System.out.println( "  ___    ___    ___  " );
		System.out.println( " |   |  |   |  |   | " );
		System.out.println( " | 1 |  | 2 |  | 3 | \n" );
		// 사용자에게 공을 숨긴 컵 번호를 입력받기
		System.out.print( " 1, 2, 3중에서 공을 숨긴 컵을 찾으세요: " );
		int cup = scan.nextInt();
		System.out.println( "  ___    ___    ___  " );
		System.out.println( " |   |  |   |  |   | " );
		System.out.println( " | 1 |  | 2 |  | 3 | " );
		// 숨긴 공 출력
		switch( ball ) {
		case 3:
			System.out.print( "       " );
		case 2:
			System.out.print( "       " );
		case 1:
			System.out.print( "   " );
		}
		System.out.println( "O" );
		// 공 찾기 결과를 출력
		switch( cup ) {
		case 3:
			System.out.print( "       " );
		case 2:
			System.out.print( "       " );
		case 1:
			System.out.print( " " );
		}
		System.out.print( ( cup == ball ) ? "찾았다!" : "놓쳤다!" );
		scan.close();
	}
}

