package moso_homework_3_practice;
import java.util.Scanner;
public class Homework_71page {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("<2019112174 조창욱 67page 실습>");
		System.out.print("a를 입력해주세요: ");
		int a=scan.nextInt();
		System.out.print("b를 입력해주세요: ");
		int b=scan.nextInt();
		//
		Integer result=pow(a,b);
		System.out.println("둘의 거듭제곱 값은 " +result+" 입니다.");
	}
	//b가 양수 일때 재귀함수
	public static Integer pow(int a,int b)
	{
		if(b==0)
			return 1;
		else
			return a*pow(a,b-1);
	}
}
