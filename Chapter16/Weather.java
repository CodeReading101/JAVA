// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter16/Weather.java

import java.io.*;
import java.util.Scanner;
public class Weather
{
	public static void main( String[] args ) throws IOException {
		Scanner scan = new Scanner( System.in );
		String month="", day="", week="", weatherReport="", precaution="";
		int  lowSeoul = 0, lowChuncheon = 0, lowDaejeon = 0, lowGwangju = 0, lowBusan = 0, lowJeju = 0;
		int  highSeoul= 0, highChuncheon= 0, highDaejeon= 0, highGwangju= 0, highBusan= 0, highJeju= 0;
		String filename = "";
		// 날씨 정보 파일 열기
		System.out.print( "파일이름을 입력하세요: " );
		filename = scan.next();
		BufferedReader inFile = new BufferedReader( new FileReader( new File( filename ) ) );
		// 파일에서 날짜별 날씨 정보를 추출하기
		for( String line; ( line = inFile.readLine() ) != null; ) {
			String[] item = line.split("\t");
			if ( item.length < 17 ) {
				System.out.print("[오류] 게임랭킹 내용을 읽어올 수 없습니다.");
				break;
			}
			month         = item[0];
			day           = item[1];
			week          = item[2];
			weatherReport = item[3];
			precaution    = item[4];
			lowSeoul      = Integer.parseInt( item[5] );
			lowChuncheon  = Integer.parseInt( item[6] );
			lowDaejeon    = Integer.parseInt( item[7] );
			lowGwangju    = Integer.parseInt( item[8] );
			lowBusan      = Integer.parseInt( item[9] );
			lowJeju       = Integer.parseInt( item[10] );
			highSeoul     = Integer.parseInt( item[11] );
			highChuncheon = Integer.parseInt( item[12] );
			highDaejeon   = Integer.parseInt( item[13] );
			highGwangju   = Integer.parseInt( item[14] );
			highBusan     = Integer.parseInt( item[15] );
			highJeju      = Integer.parseInt( item[16] );
			// 추출한 정보를 바탕으로 날씨 기사를 자동으로 생성
			System.out.println( month + "월 " + day + "일 " + week + "요일, 아침 날씨입니다." );
			System.out.println( "아침 최저기온은 서울 " + lowSeoul + "도, 춘천 " + lowChuncheon + "도, 대전 " + lowDaejeon + "도, 광주 " + lowGwangju + "도, 부산 " + lowBusan + "도, 제주 " + lowJeju + "도로 예상됩니다." );
			System.out.println( "낮 최고기온은 서울 " + highSeoul + "도, 춘천 " + highChuncheon + "도, 대전 " + highDaejeon + "도, 광주 " + highGwangju + "도, 부산 " + highBusan + "도, 제주 " + highJeju + "도로 예상됩니다." );
			System.out.print( "일부 지방에 " + weatherReport + "가 발효중입니다. 출근길 " + precaution + " 운전에 유의해야 합니다." );
		}
		// 날씨 정보 파일 닫기
		inFile.close();
		scan.close();
	}
}

