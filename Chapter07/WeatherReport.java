// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter07/WeatherReport.java

import java.util.Scanner;

public class WeatherReport
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 현재 기온을 입력받기
		System.out.print( "섭씨 -100도부터 100도 사이에서 현재 기온은 몇 도인가요 : " );
		int temperature = scan.nextInt();
		// 한파 경보, 한파 주의보, 폭염 경보, 폭염 주의보 중 무엇인지를 출력하기
		// 현재 기온이 -15도 이하이면 한파 경보 발효
		if ( temperature <= -15 ) {
			System.out.print( "일부 지방에 한파 경보가 발효 중입니다. " );
		}
		// 현재 기온이 -12도 이하이면 한파 주의보 발효
		else if ( ( -15 < temperature ) && ( temperature <= -12 ) ) {
			System.out.print( "일부 지방에 한파 주의보가 발효 중입니다. " );
		}
		// 현재 기온이 35도 이상이면 폭염 경보 발효
		else if ( 35 <= temperature ) {
			System.out.print( "일부 지방에 폭염 경보가 발효 중입니다. " );
		}
		// 현재 기온이 33도 이상이면 폭염 주의보 발효
		else if ( ( 33 <= temperature ) && ( temperature < 35 ) ) {
			System.out.print( "일부 지방에 폭염 주의보가 발효 중입니다. " );
		}
		// 나머지의 경우 평년 수준으로 출력
		else {
			System.out.print( "현재 평년 수준의 기온을 유지하고 있습니다. " );
		}
		scan.close();
	}
}

