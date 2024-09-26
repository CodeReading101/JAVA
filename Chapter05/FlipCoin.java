// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter05/FlipCoin.java

import java.util.Scanner;
import java.lang.Math;
public class FlipCoin
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int coin = 0, user = 0;
		// 먼저 동전을 임의로 던져서 받고 숨기기
		coin = (int)( Math.random() * 2 );
		// 사용자는 동전의 앞면과 뒤면 중 하나를 선택
		System.out.println( "동전 던지기 게임을 시작합니다." );
		System.out.print( "앞면(0), 뒤면(1) 중 하나를 선택하세요: " );
		user = scan.nextInt();
		// 사용자가 동전의 상태를 맞추었는지 결과 출력
		System.out.println( ( user == 0 ) ? "동전 앞면을 선택했습니다" : "동전 뒤면을 선택했습니다" );
		System.out.println( ( coin == 0 ) ? "동전 앞면이 나왔습니다" : "동전 뒤면이 나왔습니다" );
		System.out.println( ( coin == user ) ? "맞았습니다" : "틀렸습니다" );
	}
}

