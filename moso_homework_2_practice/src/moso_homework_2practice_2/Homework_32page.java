package moso_homework_2practice_2;

//2019112174 조창욱 23년 9월 21일 과제
public class Homework_32page {
	//인스턴스 변수
	double area;
	double circumference;
	public Homework_32page() //생성자
	{
		area=0;
		circumference=0;
		System.out.println("2019112174 조창욱");
	}
	//원의 면적 계산 메소드
	public double areaCalculate(int calradius, double calpi) {
		area=Math.pow(calradius, 2)*calpi;
		return area;
	}
	//원의 둘레 계산 메소드
	public double circumFerenceCalculate(int calradius, double calpi) {
		circumference=2*calpi*calradius;
		return circumference;
	}
	public void print() //값 출력 메소드
	{
		System.out.println("원의 넓이: " + area);
		System.out.println("원의 둘레: " + circumference );
	}
	public static void main(String[] args) {
		Homework_32page circleCal = new Homework_32page(); //클래스의 객체 생성
		circleCal.circumFerenceCalculate(5,Math.PI);
		circleCal.areaCalculate(5,Math.PI);
		circleCal.print();
	}
}
