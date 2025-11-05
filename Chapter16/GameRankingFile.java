// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/GameRankingFile.java

import java.io.*;
import java.util.*;
public class GameRankingFile
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		// 먼저 기존 게임랭킹 파일 읽기
		// 파일 열기(읽기모드)
		System.out.print( "게임랭킹 파일이름을 입력하세요: " );
		String filename = scan.next();
		BufferedReader inRankingFile = new BufferedReader( new FileReader( new File( filename ) ) );
		// 게임랭킹 한 줄씩 읽기
		String[][] id = { { "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" } };
		int index = 0;
		for( String line; ( line = inRankingFile.readLine() ) != null; index++ ) {
			String[] one = line.split("\t");
			if ( one.length >= 2 ) {
				id[index][0] = one[0];
				id[index][1] = one[1];
			}
			else {
				System.out.print( "(오류) 게임랭킹 내용을 읽어올 수 없습니다." );
				break;
			}
		}
		// 파일 닫기(읽기모드)
		inRankingFile.close();
		// 새 게임 아이디와 스코어 입력 받기
		System.out.print( "게임 아이디를 입력하세요: " );
		id[index][0] = scan.next();
		System.out.print( "게임 스코어를 입력하세요: " );
		id[index][1] = scan.next();
		// 게임 스코어를 기준으로 정렬
		// 마지막 칸에 가장 큰 값을 저장하면서 한 칸씩 앞으로 영역 좁혀가기
		for ( int last = index; 0 < last; last-- ) {
			// 영역의 첫번째 칸부터 인접한 두 값을 비교하면서
			for ( index = 0; index < last; index++ ) {
				// 앞이 뒤보다 작으면 두 값을 맞바꾸기하면서 앞쪽에 큰 값을 저장
				if ( Integer.parseInt( id[index][1] ) < Integer.parseInt( id[index+1][1] ) ) {
					String temp = id[index][0];
					id[index][0] = id[index+1][0];
					id[index+1][0] = temp;
					temp = id[index][1];
					id[index][1] = id[index+1][1];
					id[index+1][1] = temp;
				}
			}
		}
		// 게임랭킹 파일 업데이트
		// 파일 열기(쓰기모드)
		BufferedWriter outRankingFile = new BufferedWriter( new FileWriter( new File( filename ) ) );
		// 게임랭킹 결과 한 줄씩 쓰기
		for ( index = 0; id[index][0].compareTo( "" ) != 0; index++ ) {
			System.out.println( index+1 + ") " + id[index][0] + "\t" + id[index][1] );
			outRankingFile.write( id[index][0] + "\t" + id[index][1] + "\n" );
		}
		// 파일 닫기(쓰기모드)
		outRankingFile.close();
		scan.close();
	}
}

