// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter20/GenericClass.java

// 제네릭 리스트 클래스
class GenericList<T> {
	private Object[] list;
	protected int size;
	// 리스트 생성 초기화
	public GenericList( int capacity ) {
		size = 0;
		list = new Object[capacity];
	}
	// 리스트 항목 추가
	public void add( T item ) {
		list[size++] = item;
	}
	// 리스트 항목 반환
	public T get( int index ) {
		return (T)list[index];
	}
}
public class GenericClass {
	public static void main( String[] args ) {
		// 먼저, 점수 초기화 및 출력
		GenericList<Integer> scores = new GenericList<Integer>( 3 );
		scores.add( 86 );
		scores.add( 89 );
		scores.add( 90 );
		for( int i = 0; i < scores.size; i++ )
		    System.out.print( scores.get( i ) + " "  );
		System.out.println();
		// 단어 초기화 및 출력
		GenericList<String> words = new GenericList<String>( 3 );
		words.add( "apple" );
		words.add( "banana" );
		words.add( "carrot" );
		for( int i = 0; i < words.size; i++ )
		    System.out.print( words.get( i ) + " "  );
	}
}

