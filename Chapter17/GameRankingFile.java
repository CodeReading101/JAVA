// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter17/GameRankingFile.java

import java.io.*;
import java.util.*;

public class GameRankingFile
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		ArrayList<String[]> records = new ArrayList<String[]>();
		// 게임 아이디와 스코어를 입력받기
		String[] record = new String[2];
		System.out.print( "게임 아이디를 입력하세요: " );
		record[0] = scan.next();
		System.out.print( "게임 스코어를 입력하세요: " );
		record[1] = scan.next();
		records.add( record );
		// 기존 게임 순위 파일 읽기
		// 파일 열기(읽기 모드)
		System.out.print( "게임 순위 파일 이름을 입력하세요: " );
		String filename = "";
		filename = scan.next();
		BufferedReader inRankingFile = new BufferedReader( new FileReader( new File( filename ) ) );
		// 게임 순위 한 줄씩 읽기
		for( String line; ( line = inRankingFile.readLine() ) != null; ) {
			record = line.split( "\t" );
			if ( record.length == 2 )
				records.add( record );
			else {
				System.out.print( "(오류) 게임 순위 내용을 읽어올 수 없습니다." );
				break;
			}
		}
		// 파일 닫기(읽기 모드)
		inRankingFile.close();
		// 게임 스코어를 기준으로 정렬 업데이트
		Collections.sort( records, new Comparator<String[]>() {
			@Override
			public int compare( String[] o1, String[] o2 ) {
				return Integer.parseInt( o2[1] ) - Integer.parseInt( o1[1] );
			}
		});
		// 새 게임 순위 파일 쓰기
		// 파일 열기(쓰기 모드)
		BufferedWriter outRankingFile = new BufferedWriter( new FileWriter( new File( filename ) ) );
		// 게임 순위 한 줄씩 쓰기
		int index=0;
		for( String[] one : records ) {
			System.out.println( ++index + ") " + one[0] + "\t" + one[1] );
			outRankingFile.write( one[0] + "\t" + one[1] + "\n" );
		}
		// 파일 닫기(쓰기 모드)
		outRankingFile.close();
		scan.close();
	}
}

