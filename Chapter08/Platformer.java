// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter08/Platformer.java

import java.util.Scanner;

public class Platformer
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int platform = 0, user = 0;
		do {
			// 먼저 발판 두 개 중 하나만 안전하게 배치
			platform = (int)( Math.random() * 2 ) + 1;
			// 사용자는 발판 두 개 중 하나를 선택
			System.out.println( "  옷  " );
			System.out.print( "\033[44m  \033[0m  \033[41m  \033[0m" );
			System.out.print( "  왼쪽 발판(1)과 오른쪽 발판(2) 중 하나를 선택하세요: " );
			user = Integer.parseInt( scan.nextLine() );
			// 안전한 발판을 선택하면 다음 단계로 이동
		} while( platform == user );
		System.out.print( "\n앗!! 무늬만 발판인 페이크였네요. 허공을 가르며 슈~~웅 콰당!" );
		scan.close();
	}
}

