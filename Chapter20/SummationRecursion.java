// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/SummationRecursion.java

import java.util.Scanner;
public class SummationRecursion
{
	// 0부터 n까지의 합계를 계산
	private static int sigma( int num ) {
		// Σ n = n + Σ ( n - 1 )
		if ( num > 0 ) {
			System.out.print( num + " + " );
			return num + sigma( num - 1 );
		}
		// Σ 0 = 0
		else {
			System.out.print( "0 = " );
			return 0;
		}
	}
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 숫자 n 입력받기
		System.out.print( "숫자를 입력하세요: " );
		int num = scan.nextInt();
		// 0부터 n까지의 합계 계산하기
		System.out.print( "Σ " + num + " = " );
		int sum = sigma( num );
		// 합계 출력하기
		System.out.print( sum );
		scan.close();
	}
}

