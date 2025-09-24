// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter13/UpAndDownGUI.java

import java.lang.Math;
import javax.swing.JOptionPane;
public class UpAndDownGUI
{
	public static void main( String[] args ) {
		// 임의의 수 숨기기
		int number = (int)( Math.random() * 100 ) + 1, again  = 0;
		// 임의의 수 맞추기
		do {
			// 숫자 입력 받기
			int user = Integer.parseInt( JOptionPane.showInputDialog( "1~100사이의 숫자를 입력하세요: " ) );
			// 입력값이 제한범위 벗어나면 다시 입력
			if ( ( user < 1 ) || ( 100 < user ) ) {
				JOptionPane.showMessageDialog( null, "제한범위를 벗어났습니다" );
				continue;
			}
			// 비교 결과 출력
			// 첫째 임의의 수를 맞추면 Success!! 출력 후 종료
			else if ( number == user ) {
				JOptionPane.showMessageDialog( null, "Success!!" );
				break;
			}
			// 둘째 임의의 수가 입력값보다 크면 Up! 출력
			else if ( number > user ) {
				JOptionPane.showMessageDialog( null, "Up!" );
			}
			// 셋째 임의의 수가 입력값보다 작으면 Down! 출력
			else if ( number < user ) {
				JOptionPane.showMessageDialog( null, "Down!" );
			}
			// 계속 반복할지 확인
			again = JOptionPane.showConfirmDialog( null, "한번 더 할까요?" );
		} while( again == JOptionPane.YES_OPTION );
	}
}

