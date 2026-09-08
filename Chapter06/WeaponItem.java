// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter06/WeaponItem.java

import java.util.Scanner;

public class WeaponItem
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 캐릭터를 중심으로 상하좌우에 놓인 아이템을 출력
		System.out.println( "     /    " );
		System.out.println( " [   옷   D" );
		System.out.println( "     ->   \n" );
		// 캐릭터의 이동 방향(WASD)을 입력받기
		System.out.print( "이동키(WASD)를 입력하세요: " );
		char direction= scan.next().charAt(0);
		// 입력에 따른 이동 결과 출력
		switch( direction ) {
			// W는 위로 이동해서 칼을 획득
			case 'w': case 'W':
				System.out.print( "\n     옷/      칼 획득 " );
				break;
			// A는 왼쪽으로 이동해서 방패를 획득
			case 'a': case 'A':
				System.out.print( "\n     옷]      방패 획득" );
				break;
			// S는 아래로 이동해서 창을 획득
			case 's': case 'S':
				System.out.print( "\n     옷->     창 획득" );
			break;
			// D는 오른쪽으로 이동해서 활을 획득
			case 'd': case 'D':
				System.out.print( "\n     옷D     활 획득" );
		}
		scan.close();
	}
}

