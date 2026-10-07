// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter12/PassByValueVsPassByReference.java

// 문자 클래스
class Char
{
	protected char value;
	// 값 초기화
	public Char( char value ) {
		this.value = value;
	}
	// 값 문자열 표현
	public String toString() {
		return this.value + " ";
	}
}
public class PassByValueVsPassByReference
{
	// 전달인자 수정
	public static void uppercase( char parameter1, Char parameter2, Char parameter3 ) {
		System.out.println( "uppercase() 변경전  parameter1 = " + parameter1 + "    parameter2 = " + parameter2 + "   parameter3 = " + parameter3 );
		// Pass by Value 후 값 수정
		parameter1 = 'A';
		// Pass by Reference 후 새 객체를 생성하여 수정
		parameter2 = new Char( 'D' );
		// Pass by Reference 후 객체 값을 직접 수정
		parameter3.value = 'G';
		System.out.println( "uppercase() 변경후  parameter1 = " + parameter1 + "    parameter2 = " + parameter2 + "   parameter3 = " + parameter3 );
	}
	public static void main( String[] args ) {
		// 전달인자 초기화
		char argument1 = 'a';
		Char argument2 = new Char( 'd' );
		Char argument3 = new Char( 'g' );
		
		// 전달인자 수정
		System.out.println( "uppercase() 호출전   argument1 = " +  argument1 + "     argument2 = " +  argument2 + "    argument3 = " +  argument3 );
		uppercase( argument1, argument2, argument3 );
		System.out.println( "uppercase() 호출후   argument1 = " +  argument1 + "     argument2 = " +  argument2 + "    argument3 = " +  argument3 );
	}
}

