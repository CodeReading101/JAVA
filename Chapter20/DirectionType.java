// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/DirectionType.java

import java.util.Scanner;

public class DirectionType
{
	// 열거형으로 방향키 목록 정의
	enum Direction { LEFT, left, RIGHT, right, UP, up, DOWN, down };
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 먼저, 캐릭터의 초기 위치를 출력
		System.out.println( "     / " );
		System.out.println( " [   옷   D" );
		System.out.println( "     -> \n\n" );
		// 이동 방향 입력 받기
		System.out.print( "LEFT, RIGHT, UP, DOWN 중 하나를 입력하세요: " );
		Direction move = Direction.valueOf( scan.next() );
		// 이동 결과 출력
		switch( move ) {
			case UP : case up :
				System.out.print( "\n     옷/      칼 획득 " );
				break;
			case DOWN : case down :
				System.out.print( "\n     옷->     창 획득" );
				break;
			case LEFT : case left :
				System.out.print( "\n     옷]      방패 획득" );
				break;
			case RIGHT : case right :
				System.out.print( "\n     옷D      활 획득" );
				break;
		}
		scan.close();
	}
}

