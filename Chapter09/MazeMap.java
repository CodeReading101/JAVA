// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter09/MazeMap.java


public class MazeMap
{
	public static void main( String[] args ) {
		// 미로 맵을 2차원 배열로 초기화
		char[][] map = {
		                   { 'W','W','W','W','W','W','W','W','W' },
		                   { 'W','A',' ',' ','W',' ',' ',' ','E' },
		                   { 'W','W','W',' ','W',' ','W','W','W' },
		                   { 'W',' ',' ',' ','W',' ',' ',' ','W' },
		                   { 'W',' ','W','W','W','W','W',' ','W' },
		                   { 'W',' ',' ',' ',' ',' ',' ',' ','W' },
		                   { 'W','W','W','W','W','W','W','W','W' }
		                 };
		// 미로 맵의 2차원 배열을 한 칸씩 출력
		for( int row = 0; row < map.length; row++ ) {
			for( int column = 0; column < map[0].length; column ++ ) {
				// 첫째 Wall이면 벽 출력
				if( map[row][column] == 'W' )
					System.out.print( "\033[44m  \033[0m" );
				// 둘째 ' '이면 길 출력
				else if( map[row][column] == ' ' )
					System.out.print( "  " );
				// 셋째 Exit이면 문 출력
				else if( map[row][column] == 'E' )
					System.out.print( "\033[34m문\033[0m" );
				// 넷째 Actor이면 옷 출력
				else if( map[row][column] == 'A' )
					System.out.print( "\033[31m옷\033[0m" );
			}
			System.out.println();
		}
	}
}

