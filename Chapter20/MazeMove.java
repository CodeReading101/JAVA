// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/MazeMove.java

import java.util.Scanner;
public class MazeMove
{
	private static int[][] map = {
	                 { 1, 1, 1, 1, 1, 1, 1 },
	                 { 1, 0, 0, 0, 1, 0, 1 },
	                 { 1, 0, 1, 0, 1, 1, 1 },
	                 { 1, 1, 1, 0, 1, 0, 1 },
	                 { 1, 0, 0, 0, 0, 0, 2 },
	                 { 1, 1, 1, 1, 1, 1, 1 }
	                };
	private static final int HEIGHT = 6, WIDTH = 7;
	// 미로 맵 출력
	private static int previousRow = -1, previousColumn = -1;
	private static void printMap( int row, int column ) {
		// 방금 출력한 결과와 동일하면 출력 생략
		if ( ( row == previousRow ) && ( column == previousColumn ) )
			return;
		// 길, 벽, 문, 캐릭터의 기호를 바탕으로 출력
		String[] symbol = { "  ", "\033[44m  \033[0m", "\033[34m문\033[0m", "  " };
		for( int i = 0; i < HEIGHT; i++ ) {
			for( int j = 0; j < WIDTH; j++ ) {
				if( ( i == row ) && ( j == column ) )
					System.out.print( "옷" );
				else
					System.out.print( symbol[ map[i][j] ] );
			}
			System.out.println();
		}
		System.out.println();
		previousRow = row;
		previousColumn = column;
	}
	private static final int SUCCESS = 2;
	private static final int VISITED = 3;
	private static final int NOTVISITED = 0;
	// 미로 맵에서 길 찾는 함수
	private static int move( int row, int column ) {
		// 현재 위치를 확인
		if ( ( row < 0  ) || ( HEIGHT <= row ) || ( column < 0 ) || ( WIDTH <= column ) )
			return 0;
		// 먼저, 목표 지점이면 길 찾기 종료
		else if ( map[row][column] == SUCCESS ) {
			printMap( row, column );
			return SUCCESS;
		}
		// 아직 지나가지 않은 길이면 지나간 흔적을 남기기
		else if ( map[row][column] == NOTVISITED ) {
			map[row][column] = VISITED;
			// 목표 지점에 도착할 때까지 상하좌우로 한 칸씩 이동해 보기
			printMap( row, column );
			if ( move( row + 1, column ) == SUCCESS )
				return SUCCESS;
			printMap( row, column );
			if ( move( row, column + 1 ) == SUCCESS )
				return SUCCESS;
			printMap( row, column );
			if ( move( row - 1, column ) == SUCCESS )
				return SUCCESS;
			printMap( row, column );
			if ( move( row, column - 1 ) == SUCCESS )
				return SUCCESS;
			printMap( row, column );
		}
		return 0;
	}
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 캐릭터 현재 위치 입력 받기
		System.out.print( "캐릭터 현재 위치의 줄번호를 입력하세요 : " );
		int row = scan.nextInt();
		System.out.print( "캐릭터 현재 위치의 칸번호를 입력하세요 : " );
		int column = scan.nextInt();
		// 미로 맵에서 길 찾기
		if ( move( row, column ) == SUCCESS )
			System.out.println( "\n미로 맵 탈출 성공!" );
		else
			System.out.println( "\n미로 맵 탈출 실패" );
		scan.close();
	}
}

