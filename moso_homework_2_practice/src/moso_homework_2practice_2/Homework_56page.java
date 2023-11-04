package moso_homework_2practice_2;

public class Homework_56page {
	//2019112174 조창욱
	public static void main(String[] args) {
		int n=123;
		int binary;
		System.out.println("<2019112174 조창욱>");	
		//8bit로 표현한다고 가정.
		for(int i=7;i>=0;i--)
		{
			//n의 값을 최상위 비트부터 체크(2^7(0),2^6(1),...,2^0(1))
			//&비트연산자 사용->해당 비트와 '1'과 같으면 1, 아니면 0
			binary=(n>>i)&1;
			System.out.print(binary);	
			
		}

	}
}