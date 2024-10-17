// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/find/BallGame.java

package find;
import java.util.Scanner;

// 공 찾기 게임 클래스
public class BallGame
{
	protected String message;
	protected String meet;
	protected String dodge;
	private int ball;
	private int cup;

	// 공 찾기 게임 생성자
	public BallGame() {
		this.message = "1, 2, 3 중에서 공[O]을 숨긴 컵을 찾으세요: ";
		this.meet   = "찾았다!\n";
		this.dodge  = "놓쳤다!\n";
		this.ball = 1;
		this.cup = 0;
	}

	// 공 숨기기 메서드
	public void hide() {
		this.ball = (int)( Math.random() * 3 ) + 1;
	}

	// 공 찾기 메서드
	public void find( Scanner scan ) {
		System.out.print( message );
		this.cup = scan.nextInt();
	}

	// 게임 진행이 유효한지 확인하는 메서드
	public boolean isValid() {
		if ( ( 1 <= this.ball ) && ( this.ball <= 3 )
		     &&  ( 1 <= this.cup ) && ( this.cup <= 3 ) )
			return true;
		else
			return false;
	}

	// 공 찾기 결과를 문자열로 나타내는 메서드
	public String toString() {
		String result = "  ___    ___    ___  \n"
		              + " |   |  |   |  |   | \n"
		              + " | 1 |  | 2 |  | 3 | \n";

		if ( isValid() ) {
			result += blanks( ball );
			result += "   O   \n";
			result += blanks( cup );
			if ( ( this.cup == this.ball ) )
				result += meet;
			else
				result += dodge;
		}
		return result;
	}

	// 공백을 확보하는 메서드
	private String blanks( int column ) {
		String result = "";
		for ( int i = 1; i < column; i++ )
				result += "       ";
		return result;
	}
}

