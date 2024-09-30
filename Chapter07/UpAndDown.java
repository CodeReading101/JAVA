// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter07/UpAndDown.java

import java.util.Scanner;
import java.lang.Math;
public class UpAndDown
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		int number = 0, user = 0, chance = 6;
		// 먼저 임의의 수 숨기기
		number = (int)( Math.random() * 100 ) + 1;
		// 5번의 기회 내에서 임의의 수 맞추기
		while( --chance > 0 ) {
			System.out.println( "기회는 " + chance + "번 남았습니다" );
			// 숫자 입력 받기
			System.out.print( "1~100사이의 숫자를 입력하세요: " );
			user = scan.nextInt();
			// 입력값이 제한범위 벗어나면 다시 입력받기
			if ( ( user < 1 ) || ( 100 < user ) ) {
				System.out.println( "제한범위를 벗어났습니다" );
				chance++;
				continue;
			}
			// 비교 결과 출력
			// 첫째 임의의 수를 맞추면 Sucess!! 출력 후 종료
			else if ( number == user ) {
				System.out.println( "Success!!" );
				break;
			}
			// 둘째 임의의 수가 입력값보다 크면 Up! 출력
			else if ( number > user ) {
				System.out.println( "Up!" );
			}
			// 셋째 임의의 수가 입력값보다 작으면 Down! 출력
			else if ( number < user ) {
				System.out.println( "Down!" );
			}
		}
	}
}

