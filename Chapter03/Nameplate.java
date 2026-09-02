// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter03/Nameplate.java

import java.util.Scanner;

public class Nameplate
{
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 문패 입력
		System.out.print( "문패에 뭐라고 적을까요: " );
		String nameplate = scan.next();
		// 강아지집과 문패 출력
		System.out.println( "\033[31m   __________   " );
		System.out.println( "  / \033[0m" + nameplate + "\033[31m \\ " );
		System.out.println( " /____________\\\033[32m" );
		System.out.println( "  |  ______  |" );
		System.out.println( "  | |\033[0m /\\/\\ \033[32m| |" );
		System.out.println( "  | |\033[0m(o__o)\033[32m| |" );
		System.out.println( "  | |\033[0m =  = \033[32m| |\033[01m" );
		scan.close();
	}
}

