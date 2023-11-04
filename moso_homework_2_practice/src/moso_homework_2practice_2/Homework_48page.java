package moso_homework_2practice_2;

public class Homework_48page {
	//2019112174 조창욱
	public static void main(String[] args) {
	
		byte a=(byte) 123; //0111 1011
		byte b=(byte) -10; //1111 0110(2의 보수)
		byte result=  (byte) (a|b) ; //1111 1111(8bit 2의 보수로 -1을 표현)
		System.out.println("123 | -10 = " + result);

	}

}
