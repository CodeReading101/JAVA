// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter15/MusicClass.java

// 리듬악기
class RhythmInstrument extends Thread {
	private String sound;
	private int time;
	private int count;
	// 리듬악기 초기화
	public RhythmInstrument( String sound, int time, int count ) {
		this.sound = sound;
		this.time = time;
		this.count = count;
	}
	// 리듬악기를 박자에 맞춰 치기
	public void run() {
		try {
			for(; count > 0; count-- ) {
				Thread.sleep( time );
				System.out.print( sound );
			}
		} catch( Exception e ) {
		}
	}
}
public class MusicClass
{
	public static void main(String[] args) {
		// 첫째, 캐스터네츠 준비
		Thread castanets = new RhythmInstrument( "짝 ", 1000, 8 );
		castanets.start();
		// 둘째, 트라이앵글 준비
		Thread triangle = new RhythmInstrument( "칭", 3990, 2 );
		triangle.start();
		// 셋째, 탬버린 준비
		Thread tambourine = new RhythmInstrument( "찰~찰~찰~찰~ ",8100, 1 );
		tambourine.start();
		System.out.println( "연주시작(캐스터네츠,트라이앵글,탬버린)" );
	}
}

