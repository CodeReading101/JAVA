// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter13/TypeTestGUI.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// 질문 패널
class QuestionPanel extends JPanel
{
	private Container frame;
	private CardLayout cards;
	private JRadioButton yes, no;
	private static int count = 0;
	// 질문 패널 준비
	public QuestionPanel( Container frame, CardLayout cards, String question ) {
		// 프레임에 다른 패널을 끼울 수 있도록 준비
		this.frame = frame;
		this.cards= cards;
		// 질문과 답(예/아니오)을 제시
		this.setLayout( new GridLayout( 3, 1 ) );
		this.add( new JLabel( question ) );
		yes = new JRadioButton( "예" );
		this.add( yes );
		no  = new JRadioButton( "아니오" );
		this.add( no );
		// 답 선택시 반응할 리스너 등록
		AnswerListener listener = new AnswerListener();
		yes.addActionListener( listener );
		no.addActionListener( listener );
	}
	// 답 선택시 반응
	private class AnswerListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			if ( yes.isSelected() )
				 count++;
			// 5개 질문 중 '예'가 4개 이상이면 내향인 출력
			if ( count >= 4 )
				cards.last( frame );
			// 아니면 질문 계속하기
			else
				cards.next( frame );
		}
	}
}
// 최종 결과 패널
class FinalPanel extends JPanel
{
	// 내향인인지 외향인인지 정중앙에 출력
	public FinalPanel( String message ) {
		JLabel label = new JLabel( message );
		label.setPreferredSize( new Dimension(350,100) );
		label.setHorizontalAlignment( JLabel.CENTER );
		label.setVerticalAlignment( JLabel.CENTER );
		add( label );
	}
}
public class TypeTestGUI
{
	public static void main(String args[]) {
		String[] questions = {
				"놀 땐 잘 놀았지만, 돌아가는 길에 같이 가자고 하면 부담스럽다.",
				"약속이 취소되면 아쉬움보다 안도감을 더 크게 느낀다.",
				"하루 중 한 시간 정도는 혼자 시간을 보내는 것이 좋다.",
				"뉴스에서 사회적 거리두기를 하라고하면 반갑다.",
				"당황스러운 상황에서 적절한 대응을 신속하게 못한다.",
		};
		// 카드레이아웃의 프레임 준비
		final JFrame frame = new JFrame( "심리테스트" );
		final CardLayout cards = new CardLayout( 20, 20 );
		frame.setLayout( cards );
		// 질문과 결과 패널을 카드처럼 프레임에 모두 끼우고 실행 준비
		for( String question : questions )
			frame.add( new QuestionPanel( frame.getContentPane(), cards, question ) );
		frame.add( new FinalPanel( "외향인이군요" ) );
		frame.add( new FinalPanel( "내향인이군요" ) );
		frame.setPreferredSize( new Dimension(400,200) );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

