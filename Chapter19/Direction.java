// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter19/Direction.java

import java.util.Scanner;
public class Direction
{
	// 열거형으로 방향키 목록 정의
	enum Direction { LEFT, left, RIGHT, right, UP, up, DOWN, down };
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 캐릭터의 초기 위치를 출력
		System.out.println( "      / " );
		System.out.println( " [   옷   문" );
		System.out.println( "      -> \n" );
		// 이동 방향 입력 받기
		System.out.print("left, right, up, down을 입력하세요:");
		Direction move = Direction.valueOf( scan.next() );
		// 이동 결과 출력
		System.out.print( "\033[2;6f  " );
		switch( move ) {
			case UP: case up:
				System.out.print( "\033[1;6f 옷/ " );
				break;
			case DOWN: case down:
				System.out.print( "\033[3;6f 옷-> " );
				break;
			case LEFT: case left:
				System.out.print( "\033[2;1f 옷] " );
				break;
			case RIGHT: case right:
				System.out.print( "\033[2J\033[4;15fSUCCESS!" );
				break;
		}
		scan.close();
	}
}

