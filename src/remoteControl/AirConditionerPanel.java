// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/remoteControl/AirConditionerPanel.java

package remoteControl;
import java.awt.*;
import javax.swing.*;

// 에어컨 클래스는 에어컨 리모컨을 모델링(리모컨 기능을 포함하므로 부모클래스 RemoteControl을 상속)
public class AirConditionerPanel extends JPanel implements RemoteControl
{
	private boolean power;
	private int temperature, windStrength;
	private final String strWindStrength[] = { "미풍", "약풍", "강풍" };
	private JLabel label;

	// 에어컨 GUI 화면 초기화
	public AirConditionerPanel() {
		// 전원, 희망온도, 풍량 상태 초기화
		power = OFF;
		temperature = 18;
		windStrength = 1;

		label = new JLabel( "" );
		label.setPreferredSize( new Dimension( 290, 120 ) );
		label.setFont( new Font( "Serif", Font.BOLD, 38 ) );
		label.setForeground( Color.BLUE );
		label.setText( "<html>전원을 켜주세요</html>" );

		add( label );
	}

	// 에어컨 리모컨에서 전원 버튼을 누르면 전원 상태 변경
	@Override
	public void clickPower() {
		if( power == OFF ) {
			power = ON;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
		else {
			power = OFF;
			label.setText( "<html>전원을 켜세요</html>" );
		}
	}

	// 에어컨 리모컨에서 상(△) 버튼을 누르면 희망 온도 증가
	@Override
	public void clickUp() {
		if( power == ON ) {
			++temperature;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
	}

	// 에어컨 리모컨에서 하(▽) 버튼을 누르면 희망 온도 감소
	@Override
	public void clickDown() {
		if( power == ON ) {
			--temperature;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
	}

	// 에어컨 리모컨에서 좌(◁) 버튼을 누르면 바람 세기 감소
	@Override
	public void clickLeft() {
		if( power == ON ) {
			windStrength = ( windStrength + (strWindStrength.length - 1 ) ) % strWindStrength.length;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
	}

	// 에어컨 리모컨에서 우(▷) 버튼을 누르면 바람 세기 증가
	@Override
	public void clickRight() {
		if( power == ON ) {
			windStrength = ( windStrength + 1 ) % strWindStrength.length;
			label.setText( "<html> 희망온도: " + temperature + "도 <br> 바람세기: " + strWindStrength[ windStrength ] +" </html>" );
		}
	}
}

