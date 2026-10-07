// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter12/RockPaperScissorsGame.java

import java.util.Scanner;
import rpsGame.RockPaperScissors;

public class RockPaperScissorsGame
{
	public static void main( String[] args ) {
		// 가위바위보 초기화
		RockPaperScissors playerA = new RockPaperScissors();
		RockPaperScissors playerB = new RockPaperScissors();

		// 가위바위보 선택
		playerA.select( new Scanner( System.in ) );
		playerB.select();
		System.out.println( "A님은 " + playerA + "를 냈습니다." );
		System.out.println( "B님은 " + playerB + "를 냈습니다." );

		// 가위바위보 승패 출력
		if ( playerA.equals( playerB ) )
			System.out.println( "A님과 B님이 비겼습니다" );
		else if ( playerA.win( playerB ) )
			System.out.println( "A님이 이겼습니다" );
		else
			System.out.println( "B님이 이겼습니다" );
	}
}


