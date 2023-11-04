package moso_homework_3_practice;

public class RectUser {

	public static void main(String[] args) {
		//Rect 객체 rect 생성
		Rect rect= new Rect();
		
		double width=4.0;
		double height=5.0;
		System.out.println("<2019112174 조창욱>");
		System.out.println("넓이: "+rect.getArea(width,height));
		System.out.println("둘레: "+rect.getCircum(width,height));
	}

}
