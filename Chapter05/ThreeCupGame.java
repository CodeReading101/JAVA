// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter05/ThreeCupGame.java

import java.util.Scanner;
import java.lang.Math;
public class ThreeCupGame
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int ball = 0, cup = 0;
		// 먼저 3개 컵 중에서 하나에 구슬 숨기기
		ball = (int)( Math.random() * 3 ) + 1;
		System.out.println( "  ___    ___    ___  " );
		System.out.println( " |   |  |   |  |   | " );
		System.out.println( " | 1 |  | 2 |  | 3 | \n\n\n" );
		// 사용자에게 구슬을 숨긴 컵 번호 입력 받기
		System.out.print( "\n\n 1, 2, 3 중에서 구슬[O]을 숨긴 컵을 찾으세요 : " );
		cup = scan.nextInt();
		// 구슬 찾기 결과 출력
		System.out.print( "\033[4;" + (ball*7-3) + "fO\n\033[5;" + (cup*7-5) + "f" );
		System.out.println( ( cup == ball ) ? "찾았다!\n" : "놓쳤다!\n" );
	}
}

