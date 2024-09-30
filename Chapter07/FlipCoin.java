// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter07/FlipCoin.java

import java.util.Scanner;
import java.lang.Math;
public class FlipCoin
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int coin = 0, user = 0;
		char again = '\0';
		do {
			// 동전 던지기 게임
			// 먼저 동전을 임의로 던져서 받고 숨기기
			coin = (int)( Math.random() * 2 ) + 1;
			// 사용자는 동전의 앞면과 뒤면 중 하나를 선택
			System.out.print( "동전의 앞면(1), 뒤면(2) 중 하나를 선택하세요: " );
			user = Integer.parseInt( scan.nextLine() );
			// 사용자가 동전의 상태를 맞추었는지 결과 출력
			System.out.println(  ( coin == user ) ? "맞췄습니다.\n" : "틀렸습니다.\n" );
			// 사용자에게 게임을 한번 더 할지 묻기
			System.out.print( "동전 던지기 게임을 한 번 더 하시겠습니까?(y/n): " );
			again = scan.nextLine().charAt(0);
		} while( ( again == 'y' ) || ( again == 'Y' ) );
	}
}

