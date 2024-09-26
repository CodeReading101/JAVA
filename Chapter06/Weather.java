// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter06/Weather.java

import java.util.Scanner;
public class Weather
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int temperature = 0;
		// 현재 기온을 입력받기
		System.out.print( "섭씨 -100도부터 100도 사이에서 현재 기온은 몇 도인가요 : " );
		temperature = scan.nextInt();
		// 현재 기온이 한파 경보, 한파 주의보, 폭염 경보, 폭염 주의보 중 무엇인지를 출력하기
		// 현재 기온이 -15도 이하이면 한파 경보 발효
		if (  temperature <= -15 ) {
			System.out.print( "일부 지방에 한파 경보가 발효중입니다. " );
		}
		// 현재 기온이 -13도 이하이면 한파 주의보 발효
		else if (  ( -15 < temperature ) && ( temperature <= -13 ) ) {
			System.out.print( "일부 지방에 한파 주의보가 발효중입니다. " );
		}
		// 현재 기온이 35도 이상이면 폭염 경보 발효
		else if ( 35 <= temperature ) {
			System.out.print( "일부 지방에 폭염 경보가 발효중입니다. " );
		}
		// 현재 기온이 33도 이상이면 폭염 주의보 발효
		else if (  ( 33 <= temperature ) && ( temperature < 35 ) ) {
			System.out.print( "일부 지방에 폭염 주의보가 발효중입니다. " );
		}
		// 나머지의 경우 그나마 살만하다고 출력하기
		else {
			System.out.print( "오늘 날씨는 그나마 살만하네요 " );
		}
	}
}

