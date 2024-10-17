// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter12/BombGame_Main.java

import java.util.Scanner;
import find.BombGame;
public class BombGame_Main
{
	public static void main(String[] args)
	{
		// 초기화
		Scanner scan = new Scanner( System.in );
		BombGame game = new BombGame();
		do {
			// 먼저 게임 현황 출력
			System.out.println( game );
			// 폭탄 숨기기
			game.hide();
			// 폭탄 찾기
			game.find( scan );
			// 게임을 계속할지 확인
		} while( game.isValid() );

	}
}

