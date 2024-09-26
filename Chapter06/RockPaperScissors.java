// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter06/RockPaperScissors.java

import java.util.Scanner;
public class RockPaperScissors
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int playerA = 0;
		int playerB = 0;
		// A양 가위바위보 선택
		System.out.print( "A양, 가위(1), 바위(2), 보(3) 중 하나를 숫자로 입력하세요: " );
		playerA = scan.nextInt();
		switch( playerA ) {
		case 1:
			System.out.println( "가위를 냈습니다." );
			break;
		case 2:
			System.out.println( "바위를 냈습니다." );
			break;
		case 3:
			System.out.println( "보를 냈습니다." );
		}
		// B군 가위바위보 선택
		System.out.print( "B군, 가위(1), 바위(2), 보(3) 중 하나를 숫자로 입력하세요: " );
		playerB = scan.nextInt();
		switch( playerB ) {
		case 1:
			System.out.println( "가위를 냈습니다." );
			break;
		case 2:
			System.out.println( "바위를 냈습니다." );
			break;
		case 3:
			System.out.println( "보를 냈습니다." );
		}
		// 가위바위보 승패 출력
		// 먼저 A양과 B군이 같으면 비김
		if ( playerA == playerB ) {
			System.out.println( "\nA양과 B군이 비겼습니다." );
		}
		// A양이 가위이고 B군이 보를 낸 경우 A양 승리
		else if ( ( playerA == 1 ) && ( playerB == 3 ) ) {
			System.out.println( "\nA양이 이겼습니다." );
		}
		// A양이 바위이고 B군이 가위를 낸 경우 A양 승리
		else if ( ( playerA == 2 ) && ( playerB == 1 ) ) {
			System.out.println( "\nA양이 이겼습니다." );
		}
		// A양이 보이고 B군이 바위를 낸 경우 A양 승리
		else if ( ( playerA == 3 ) && ( playerB == 2 ) ) {
			System.out.println( "\nA양이 이겼습니다." );
		}
		// 나머지 경우 B군 승리
		else {
			System.out.println( "\nB군이 이겼습니다." );
		}
	}
}

