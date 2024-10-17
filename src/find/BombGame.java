// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/find/BombGame.java

package find;
// 폭탄 피하기 클래스
public class BombGame extends BallGame
{
		// 폭탄 피하기 생성자: 구슬 찾기 대신 폭탄 피하기에 맞게 메시지 수정
	public BombGame() {
		super();
		super.message = "1, 2, 3 중에서 폭탄[O]이 있는 상자를 피하세요: ";
		super.meet   = " 펑!! \n";
		super.dodge  = " 휴우!\n";
	}
}

