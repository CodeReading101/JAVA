// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter02/FoodOrder.java

import java.util.Scanner;
public class Main
{
	public static void main( String[] args ) {
		// 변수 선언 및 초기화
		Scanner scan = new Scanner( System.in );
		String mainDish = "";
		String sauce = "";
		String drink = "";
		// 손님에게 주문 받기
		System.out.println( "주문 도와드리겠습니다, 손님." );
		// 메인요리 주문 받기
		System.out.print( "메인요리는 고르셨습니까: " );
		mainDish = scan.nextLine().trim();
		// 소스 주문 받기
		System.out.print( "소스는 어떻게 할까요: " );
		sauce = scan.nextLine().trim();
		// 음료 주문 받기
		System.out.print( "음료는 무엇으로 준비할까요: " );
		drink = scan.nextLine().trim();
		// 주문 내역 확인
		System.out.println( "메인요리는 " + mainDish + ", 소스는 " + sauce + ", 음료는 " + drink + "를 선택하셨습니다. " );
		System.out.println( "준비하겠습니다. 잠시만 기다려 주십시오." );
	}
}

