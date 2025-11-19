// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter19/ColorType.java

import java.util.Scanner;
public class ColorType
{
	// 열거형으로 색깔 목록 정의
	enum Color { RED, red, YELLOW, yellow, GREEN, green, BLUE, blue, PURPLE, purple };
	public static void main( String[] args ) {
		Scanner scan = new Scanner( System.in );
		// 사용자에게 색깔 입력 받기
		System.out.print( "RED, YELLOW, GREEN, BLUE, PURPLE 중 하나를 입력하세요: " );
		Color color = Color.valueOf( scan.next() );
		// 재미로 보는 색깔 심리테스트 결과 출력
		switch ( color ) {
			case RED : case red :
				System.out.print( "빨강색을 선택한 당신은 " );
				System.out.print( "진취적이고 열정적이며 개방적이고 자신감이 넘치는군요 " );
				break;
			case YELLOW : case yellow :
				System.out.print( "노랑색을 선택한 당신은 " );
				System.out.print( "밝고 솔직하고 명랑하며 호기심도 강하고 주의력과 집중력이 높네요" );
				break;
			case GREEN : case green :
				System.out.print( "초록색을 선택한 당신은 " );
				System.out.print( "성실하고 참을성이 많으며 충성심이 강하고 의리가 있군요" );
				break;
			case BLUE : case blue :
				System.out.print( "파랑색을 선택한 당신은 " );
				System.out.print( "차분하고 침착하고 이성적이며 어떤 일이든 진지하게 열심히 하는군요" );
				break;
			case PURPLE : case purple :
				System.out.print( "보라색을 선택한 당신은 " );
				System.out.print( "섬세하고 감수성이 풍부하며 관찰력이 있고 예술적 재능이 뛰어나군요" );
		}
		scan.close();
	}
}

