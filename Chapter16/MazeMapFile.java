// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/MazeMapFile.java

import java.io.*;
import java.util.Scanner;
public class MazeMapFile
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		// 파일에서 맵 읽기
		// 맵 파일 열기
		System.out.print( "파일이름을 입력하세요: " );
		String filename = scan.next();
		BufferedReader inFile = new BufferedReader( new FileReader( new File( filename ) ) );
		// 맵 파일에서 한 줄씩 읽기
		int[][] map = new int[100][100];
		int height = 0, width = 0;
		for( String line = ""; ( line = inFile.readLine() ) != null; height++ ) {
			if ( line.length() < 3 ) {
				break;
			}
			else {
				for( width = 0; ( width < line.length() ) && ( '0' <= line.charAt(width) ) && ( line.charAt(width) <= '9' ); width++ )
					map[height][width] = line.charAt(width) - '0';
			}
		}
		// 맵 파일 닫기
		inFile.close();
		// 맵 출력
		String[] symbol = { "  ", "\033[44m  \033[0m", "옷", "\033[34m문\033[0m", "\033[31m♥\033[0m", "\033[33m★\033[0m", "\033[32m♣\033[0m", "\033[31m♠\033[0m", "\033[36m◆\033[0m", "\033[35m■\033[0m" };
		for( int row = 0; row < height; row++ ) {
			for( int column = 0; column < width; column++ )
				System.out.print( symbol[ map[row][column] ] );
			System.out.println();
		}
		scan.close();
	}
}

