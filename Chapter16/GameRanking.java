// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/GameRanking.java

import java.io.*;
import java.util.*;
public class GameRanking
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		ArrayList<String[]> list = new ArrayList<String[]>();
		// 먼저 기존 게임랭킹 파일 읽기
		// 파일 열기(읽기모드)
		System.out.print( "게임랭킹 파일이름을 입력하세요: " );
		String filename = scan.next();
		BufferedReader inRankingFile = new BufferedReader( new FileReader( new File( filename ) ) );
		// 게임랭킹 한 줄씩 읽기
		for( String line; ( line = inRankingFile.readLine() ) != null;  ) {
			String[] one = line.split("\t");
			if ( one.length < 2 ) {
				System.out.print( "[오류] 게임랭킹 내용을 읽어올 수 없습니다." );
				break;
			}
			list.add( new String[] { one[0], one[1] } );
		}
		// 파일 닫기(읽기모드)
		inRankingFile.close();
		// 새 게임 아이디와 스코어 입력 받기
		System.out.print( "게임 아이디를 입력하세요: " );
		String id = scan.next();
		System.out.print( "게임 스코어를 입력하세요: " );
		String score = scan.next();
		list.add( new String[] { id, score } );
		// 게임 스코어를 기준으로 정렬
		Collections.sort( list, new Comparator<String[]>() {
			@Override
			public int compare( String[] o1, String[] o2 ) {
				return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
			}
		});
		// 게임랭킹 파일 업데이트
		// 파일 열기(쓰기모드)
		BufferedWriter outRankingFile = new BufferedWriter( new FileWriter( new File( filename ) ) );
		// 게임랭킹 결과 한 줄씩 쓰기
		for ( int index = 0; index < list.size(); index++ ) {
			outRankingFile.write( list.get( index )[0] + "\t" + list.get( index )[1] + "\n" );
			System.out.println( index+1 + ") " + list.get( index )[0] + "\t" + list.get( index )[1] );
		}
		// 파일 닫기(쓰기모드)
		outRankingFile.close();
		scan.close();
	}
}

