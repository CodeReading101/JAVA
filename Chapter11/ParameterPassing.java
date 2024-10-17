// JAVA 프로그래밍 - https://codereading101.github.io/JAVA/
// 소스파일 - https://github.com/CodeReading101/JAVA/blob/main/Chapter11/ParameterPassing.java


// 숫자 클래스 시작
class Num
{
	private int value;
	// 숫자 클래스 생성
	public Num (int update)
	{
		value = update;
	}
	// 숫자 클래스에 특정 값을 설정
	public void setValue (int update)
	{
		value = update;
	}
	// 숫자 클래스를 문자열로 표현
	public String toString ()
	{
		return value + "";
	}
}
//
class ParameterModifier
{
	// 전달인자 수정 메서드 시작 : f1, f2, f3 받기
	public void changeValues (int f1, Num f2, Num f3)
	{
		// 전달인자 수정 전 f1, f2, f3 값을 출력
		System.out.println ("Before changing the values:"); System.out.println ("f1\tf2\tf3"); System.out.println (f1 + "\t" + f2 + "\t" + f3 + "\n"); // f1=999(기본 자료형 수정)
		f1 = 999;
		// f2=888(객체 업데이트)
		f2.setValue(888);
		// f3=777(새로운 객체로 참조값 수정)
		f3 = new Num (777);
		// 전달인자 수정 후 f1, f2, f3 값을 출력
		System.out.println ("After changing the values:");
		System.out.println ("f1\tf2\tf3");
		System.out.println (f1 + "\t" + f2 + "\t" + f3 + "\n");
		// 전달인자 수정 메서드 종료
	}
}
public class ParameterPassing
{
	public static void main (String[] args)
	{
		ParameterModifier modifier = new ParameterModifier();
		// a1=111, a2=222, a3=333로 초기화
		int a1 = 111;
		Num a2 = new Num (222);
		Num a3 = new Num (333);
		// 전달인자 수정 전 a1, a2, a3 값을 출력
		System.out.println ("Before calling changeValues:"); System.out.println ("a1\ta2\ta3"); System.out.println (a1 + "\t" + a2 + "\t" + a3 + "\n"); // 전달인자 수정 메서드 호출 : a1, a2, a3 보내기 modifier.changeValues (a1, a2, a3); // 전달인자 수정 후 a1, a2, a3 값을 출력 System.out.println ("After calling changeValues:"); System.out.println ("a1\ta2\ta3"); System.out.println (a1 + "\t" + a2 + "\t" + a3 + "\n"); return; } }

