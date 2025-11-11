// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/src/remoteControl/RobotCleanerPanel.java

package remoteControl;
import java.awt.*;
import javax.swing.*;

// Robot 클래스는 Robot 리모컨을 모델링(리모컨 기능을 포함하므로 부모클래스 RemoteControl을 상속)
public class RobotCleanerPanel extends JPanel implements RemoteControl
{
	private final int WIDTH = 340, HEIGHT = 120;
	private final int IMAGE_SIZE = 30;
	private ImageIcon imgRobot;
	private ImageIcon imageBackground;
	private int robotX, robotY;
	private boolean power;
	private JLabel cleaningArea;

	// Robot GUI 화면 초기화
	public RobotCleanerPanel( final String imgPath ) {
		// Robot 및 이동 가능 영역 초기화
		power = OFF;
		robotX = robotY = 0;
		imgRobot = new ImageIcon( new ImageIcon( imgPath + "robot.gif" ).getImage().getScaledInstance( IMAGE_SIZE, IMAGE_SIZE, Image.SCALE_SMOOTH ) );
		imageBackground = new ImageIcon( new ImageIcon( imgPath + "blank.gif" ).getImage().getScaledInstance( WIDTH, HEIGHT, Image.SCALE_SMOOTH ) );
		cleaningArea = new JLabel( imageBackground );
		add( cleaningArea );
		setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
	}

	// Robot 리모컨에서 전원 버튼을 누르면 전원 상태 변경
	@Override
	public void clickPower() {
		if( power == OFF ) {
			cleaningArea.setIcon( null );
			power = ON;
		}
		else {
			cleaningArea.setIcon( imageBackground );
			power = OFF;
		}
	}

	// Robot 리모컨에서 상(△) 버튼을 누르면 위쪽으로 이동
	@Override
	public void clickUp() {
		move( 0, -10, power );
	}

	// Robot 리모컨에서 하(▽) 버튼을 누르면 아래쪽으로 이동
	@Override
	public void clickDown() {
		move( 0, 10, power );
	}

	// Robot 리모컨에서 좌(◁) 버튼을 누르면 왼쪽으로 이동
	@Override
	public void clickLeft() {
		move( -10, 0, power );
	}

	// Robot 리모컨에서 우(▷) 버튼을 누르면 오른쪽으로 이동
	@Override
	public void clickRight() {
		move( 10, 0, power );
	}

	// Robot 이동
	public void move( int x, int y, boolean power ) {
		if ( power == RemoteControl.OFF )
			return;

		robotX += x;
		robotY += y;

		if ( robotX <= 0 )
			robotX = 0;
		else if ( robotX >= ( WIDTH - IMAGE_SIZE ) )
			robotX = WIDTH - IMAGE_SIZE;

		if ( robotY <= 0 )
			robotY = 0;
		else if ( robotY >= ( HEIGHT - IMAGE_SIZE ) )
			robotY = ( HEIGHT - IMAGE_SIZE );

		repaint();
	}

	// Robot 화면 업데이트
	@Override
	public void paintComponent( Graphics page ) {
		super.paintComponent( page );
		imgRobot.paintIcon( this, page, robotX, robotY );
	}
}

