// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/RecursiveDecimalToBinary.java

import java.util.Scanner;
public class RecursiveDecimalToBinary
{
	// 십진수를 이진수로 변환
	private static void decimal2binary( int num ) {
		// 2^1 = 2 이상일 때는 높은 자리의 이진수로 변환
		if ( num >= 2 )
			decimal2binary( num / 2 );
		// 높은 자리부터 순서대로 0 또는 1 출력
		System.out.print( num % 2 );
	}
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 십진수를 입력받기
		System.out.print( "십진수를 입력하세요: " );
		int num = scan.nextInt();
		// 십진수를 이진수로 변환
		System.out.print( "(십진수)" + num + " = (이진수)" );
		decimal2binary( num );
		scan.close();
	}
}

