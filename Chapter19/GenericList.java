// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter19/GenericList.java


// 제네릭 리스트 클래스
public class GenericList<T> {
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


