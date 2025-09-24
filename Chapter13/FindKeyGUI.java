// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter13/FindKeyGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 질문 패널 클래스
class SelectionPanel extends JPanel
{
	private JRadioButton option1, option2;
	private String nextOption2;
	private Container frame;
	private CardLayout cards;
	// 질문 패널 초기화
	public SelectionPanel( Container frame, CardLayout cards, String[] question ) {
		// 질문 및 선택항목 제시 / 선택시 반응할 리스너 등록
		setLayout( new GridLayout( 3, 1 ) );
		JLabel label = new JLabel( question[1] );
		label.setFont( new Font( "굴림", Font.BOLD, 17 ) );
		add( label );
		ClickListener click = new ClickListener();
		if( ( question.length > 2 ) && ( question[2] != null ) && !question[2].equals("") ) {
			option1 = new JRadioButton( question[2] );
			option1.setFont( new Font( "굴림", Font.BOLD, 17 ) );
			option1.addActionListener( click );
			add( option1 );
		}
		if( ( question.length > 4 ) && ( question[3] != null ) && !question[3].equals("") ) {
			option2 = new JRadioButton( question[3] );
			option2.setFont( new Font( "굴림", Font.BOLD, 17 ) );
			option2.addActionListener( click );
			add( option2 );
			nextOption2 = question[4];
		}
		// 다음 패널로 이동할 수 있도록 준비
		this.frame = frame;
		this.cards= cards;
	}
	// 선택시 다음 패널로 이동
	private class ClickListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			if ( ( event.getSource() == option1 ) && ( option1.getText().equals( "처음으로" ) ) ) {
				option1.setSelected( false );
				cards.first( frame );
			}
			else if ( ( event.getSource() == option1 ) && ( option1.getText().equals( "이전으로" ) ) ) {
				option1.setSelected( false );
				cards.previous( frame );
			}
			else if ( event.getSource() == option1 ) {
				option1.setSelected( false );
				cards.next( frame );
			}
			else if ( event.getSource() == option2 ) {
				option2.setSelected( false );
				cards.show( frame, nextOption2 );
			}
		}
	}
}
public class FindKeyGUI
{
	public static void main(String args[]) {
		// 질문 구성 : 번호, 질문, 항목1, 항목2, 항목2 클릭시 다음 번호
		String[][] questions = {
				{ "1", "열쇠를 찾아라!", "시작" },
				{ "2", "<html>약속이 있어서 나가야 하는데 차 키가 없다<br>열쇠는 어디에 있을까?<br>&nbsp;</html>", "문 밖으로 나간다", "여기서 찾아본다", "4" },
				{ "3", "<html>거실에 TV와 화분이 보인다<br>열쇠는 어디에 있을까?<br>&nbsp;</html>", "이전으로", "화분 주변", "6" },
				{ "4", "<html>서재에 책장과 책상이 보인다<br>열쇠는 어디에 있을까?<br>&nbsp;</html>", "책상 위", "책장 선반", "6" },
				{ "5", "열쇠 찾기 성공!", "처음으로" },
				{ "6", "열쇠 찾기 실패!", "처음으로" },
		};
		// 카드 레이아웃의 프레임에 여러 개의 질문 패널을 끼우고 실행 준비 완료
		final JFrame frame = new JFrame( "열쇠찾기" );
		final CardLayout cards = new CardLayout( 20, 20 );
		frame.setLayout( cards );
		for( String[] question : questions )
			frame.add( new SelectionPanel( frame.getContentPane(), cards, question ), question[0] );
		frame.setPreferredSize( new Dimension( 400,250 ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}
}

