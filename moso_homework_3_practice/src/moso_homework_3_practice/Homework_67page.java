package moso_homework_3_practice;

public class Homework_67page {
	//2019112174 조창욱
	public static void main(String[] args) {
	//2X4 행렬 A(배열의 사이즈가 있는 배열)
	int [][]A= new int[2][4];
	A[0]= new int [] {1,2,3,4};
	A[1]= new int [] {5,6,7,8};
	
	//4X3 행렬 B(배열의 사이즈가 없는 배열)
	int [][]B= {
			{1,2,3},
			{4,5,6},
			{7,8,9},
			{10,11,12}
	};
		multiplyMatrixPrint(A, B);
	}
	public static void multiplyMatrixPrint(int [][] A, int [][] B)
	{
		System.out.println("2019112174 조창욱");
		int A_row=A.length;//2
		int A_col=A[0].length;//4
		int B_col=B[0].length;//3
		int [][] result =new int[A_row][B_col];
		//i= A 행 고려(0,1)
		for (int i = 0; i < A_row; i++) {
			//j= B 열 고려(0,1,2)
			for (int j = 0; j < B_col; j++) {
				//k= A 열,B의 행
				for (int k = 0; k < A_col; k++) {
					result[i][j]+=A[i][k]*B[k][j];
				}
			}
		}
		for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(result[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
}
