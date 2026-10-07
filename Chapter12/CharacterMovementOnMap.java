// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter12/CharacterMovementOnMap.java

import java.util.Scanner;
import move.ObjectOnMap;

public class CharacterMovementOnMap
{
	public static void main( String args[] ) {
		Scanner scan = new Scanner( System.in );

		// 캐릭터 및 맵 초기화
		int[][] map = {{ 1,1,1,1,1,1,1,1,1 },
		               { 1,0,0,0,1,0,0,0,1 },
		               { 1,1,1,0,1,0,1,1,1 },
		               { 1,0,0,0,1,0,0,0,1 },
		               { 1,0,1,1,1,1,1,0,1 },
		               { 1,0,0,0,0,0,0,0,1 },
		               { 1,1,1,1,1,1,1,1,1 }};

		ObjectOnMap character = new ObjectOnMap( map, 2, 1 );

		char direction='d';
		do {
			// 캐릭터 이동하기
			character.move( direction );
			// 캐릭터 및 전체 맵 출력
			System.out.println( character );

			// 캐릭터의 다음 이동 방향 입력 받기
			System.out.print( "WASD와[Enter]를 입력하세요: " );
			direction= scan.nextLine().charAt(0);
		} while( ( direction == 'W' ) || ( direction == 'A' ) || ( direction == 'S' ) || ( direction == 'D' )
		      || ( direction == 'w' ) || ( direction == 'a' ) || ( direction == 's' ) || ( direction == 'd' ) );

		scan.close();
	}
}


