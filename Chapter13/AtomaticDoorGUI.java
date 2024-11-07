// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter13/AtomaticDoorGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 자동문
class AutomaticDoorPanel extends JPanel
{
	private JPanel panel;
	private JButton button;
	private boolean open;
	// 자동문 초기화
	public AutomaticDoorPanel() {
		// 먼저, 현재 문은 닫힌 상태로 초기화
		panel = this;
		open = false;
		setBackground( Color.cyan );
		setPreferredSize( new Dimension( 250, 400 ) );
		// 버튼을 문에 부착
		button = new JButton( "문열기" );
		add( button );
		// 버튼 클릭시 반응할 리스너 등록
		button.addActionListener( new ButtonListener() );
	}
	// 버튼 클릭시 반응
	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			// 문이 닫힌 상태이면 문을 열기
			if ( open == false ) {
				open = true;
				panel.setBackground( Color.white );
				button.setText( "문닫기" );
			}
			// 문이 열린 상태이면 문을 닫기
			else {
				open = false;
				panel.setBackground( Color.cyan );
				button.setText( "문열기" );
			}
		}
	}
}
public class AtomaticDoorGUI
{
	public static void main( String[] args ) {
		// 문틀 준비
		JFrame frame = new JFrame( "자동문" );
		// 문짝 준비
		AutomaticDoorPanel panel = new AutomaticDoorPanel();
		// 문틀에 문짝을 끼우고 이벤트(버튼클릭)를 대기
		frame.getContentPane().add( panel );
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

