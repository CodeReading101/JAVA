// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/MazeMap.java

import java.io.*;
import java.util.Scanner;
public class MazeMap
{
	private static String map[] = new String[100];
	// 맵 출력 함수
	private static void writeMap() {
		System.out.print( "\033[2J\033[1;1f" );
		for( int row = 0; map[row]!=null; row++ ) {
			for( int column = 0; column < map[row].length(); column++ ) {
				if (map[row].charAt(column) == 'A')
					System.out.print( "\033[31m옷\033[0m" );
				else if (map[row].charAt(column) == 'W')
					System.out.print( "\033[44m  \033[0m" );
				else if (map[row].charAt(column) == ' ')
					System.out.print( "  " );
				else if (map[row].charAt(column) == 'E')
					System.out.print( "\033[34m문\033[0m" );
				else if (map[row].charAt(column) == 'B')
					System.out.print( "\033[37m●\033[0m" );
				else if (map[row].charAt(column) == 'C')
					System.out.print( "\033[37m○\033[0m" );
				else if (map[row].charAt(column) == 'G')
					System.out.print( "\033[32m♣\033[0m" );
				else if (map[row].charAt(column) == 'H')
					System.out.print( "\033[32m♧\033[0m" );
				else if (map[row].charAt(column) == 'I')
					System.out.print( "\033[36m◆\033[0m" );
				else if (map[row].charAt(column) == 'J')
					System.out.print( "\033[36m◇\033[0m" );
				else if (map[row].charAt(column) == 'K')
					System.out.print( "\033[31m♥\033[0m" );
				else if (map[row].charAt(column) == 'L')
					System.out.print( "\033[31m♡\033[0m" );
				else if (map[row].charAt(column) == 'M')
					System.out.print( "\033[32m♠\033[0m" );
				else if (map[row].charAt(column) == 'N')
					System.out.print( "\033[32m♤\033[0m" );
				else if (map[row].charAt(column) == 'O')
					System.out.print( "\033[33m★\033[0m" );
				else if (map[row].charAt(column) == 'P')
					System.out.print( "\033[33m☆\033[0m" );
				else if (map[row].charAt(column) == 'Q')
					System.out.print( "\033[35m■\033[0m" );
				else if (map[row].charAt(column) == 'R')
					System.out.print( "\033[35m□\033[0m" );
				}
			System.out.println();
		}
	}
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		String filename = "";
		// 파일에서 맵 읽기
		// 맵 파일 열기
		System.out.print( "파일이름을 입력하세요: " );
		filename = scan.next();
		BufferedReader inFile = new BufferedReader( new FileReader( new File( filename ) ) );
		// 맵 파일에서 한 줄씩 읽기
		for( int row = 0; ( map[row] = inFile.readLine() ) != null; row++ ) {
			if ( map[row].length() < 3 ) {
				map[row] = "";
				row--;
			}
		}

		// 맵 파일 닫기
		inFile.close();
		// 맵 출력
		writeMap();
		scan.close();
	}
}

