package moso_programming2_2;

public class SumOrAvgToGeneric<T extends Number>{
	private T[] numbers; //배열 인스턴스 변수
	double sum=0.0;
	double avg=0.0;
	public double sum(T[] numbers)
	{
		//double sum=0.0;
		for (int i = 0; i < numbers.length; i++) {
			sum+=numbers[i].doubleValue();//더블형식으로 변환 메소드
		}

		return sum;
	}
	
	public double avg(T[] numbers)
	{
		//double avg=0.0;
		sum=sum(numbers);
		avg=sum/numbers.length;
		return avg;
	}
	
	public static void main(String[] args) {
	//정수형 배열-> Integer 클래스로 정수형 배열 생성
	Integer [] first= {1,2,3,4,5,6,7,8,9,10,
			11,12,13,14,15,16,17,18,19,20};
	//실수형 배열-> Double 클래스로 실수형 배열 생성
	Double [] second= {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,
			11.0,12.0,13.0,14.0,15.0,16.0,17.0,18.0,19.0,20.0};
	//지네릭 클래스의 객체 생성(정수형, 실수형)
	SumOrAvgToGeneric <Integer> intBox =new SumOrAvgToGeneric<Integer>();
	SumOrAvgToGeneric <Double> doubleBox =new SumOrAvgToGeneric<Double>();
	
	System.out.println("정수형 합: "+(int)intBox.sum(first));
	System.out.println("실수형 합: "+doubleBox.sum(second));
	System.out.println("");
	System.out.println("정수형 평균: "+intBox.avg(first));
	System.out.println("실수형 평균: "+doubleBox.avg(second));
	}

}
