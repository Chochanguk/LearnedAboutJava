package moso_programming2_4;

class MultiThread extends Thread{
	private int a;
	private int b;
	private int result;
	
	MultiThread(int a_element, int b_element)
	{
		a=a_element;
		b=b_element;
	}
	public void run()
	{
		try{
			result=a*b;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int getResult()
	{
		return this.result;
	}
}

public class ThreadArrayMultiplying{
	
	public static void main(String[] args) {
		
		int[] A= {3, 2, 5, 7, 8, 9, 10, 2, 7, 8}; 
		int[] B= {4, 3, 7, 3, 2, 6, 1, 0, 1, -2};
		int[] C = new int[10];
		MultiThread[] threads = new MultiThread[10];
		for(int i=0;i<10;i++)
		{
			threads[i]=new MultiThread(A[i], B[i]); //각 tread에 각 배열의 요소를 넣어 게산
			threads[i].start();//해당 쓰레드의 run 메소드 호출
		}
		for(int i=0;i<10;i++)
		{
			try{
				threads[i].join();//다른 쓰레드 연산을 위해 대기시키는 용도 ->join메소드

				}catch(Exception e)
				{
					e.printStackTrace();
				}
			C[i] = threads[i].getResult(); //getter를 통해 각 쓰레드의 연산값을 넣음

		}
		for(int i=0;i<10;i++)
		{
			System.out.print(C[i]+" ");

		}
	}

}
