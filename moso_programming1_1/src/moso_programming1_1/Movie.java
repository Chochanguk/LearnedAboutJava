package moso_programming1_1;

import java.util.Scanner;
public class Movie {

	public static void main(String[] args) {
		System.out.println("<programming 1_1 homework-2019112174 조창욱>\n");
	Scanner scan=new Scanner(System.in);
	
	int [] MovieName= {100,101,102,103,104};
	double [][]MovieScore={
			{3,1,5,2,5},
			{4,2,1,4,2},
			{5,3,1,2,4},
			{2,1,5,4,4},
			{3,3,4,3,3}
	};
	System.out.println("[영화별 평균점수]");
	//영화별 평균점수 구하기
	for(int i=0;i<MovieName.length;i++)
	{
		double userAver=0;
		double sumofUser=0;
		for(int j=0;j<MovieScore[i].length;j++)
		{
			sumofUser+=MovieScore[j][i];
		}
		userAver=sumofUser/MovieName.length;
		
		System.out.println("영화 "+MovieName[i]+"의 평균 점수:"+userAver );
	}
	
	System.out.println("[사용자별 평균점]");
	//사용자별 평균점수 구하기
	for(int i=0;i<MovieScore.length;i++)
	{
		double userAver=0;
		double sumofUser=0;
		for(int j=0;j<MovieScore[i].length;j++)
		{
			sumofUser+=MovieScore[i][j];
		}
		userAver=sumofUser/MovieScore.length;
		
		System.out.println("사용자 "+i+"의 평균 점수:"+userAver );
	}

	System.out.print("우선 영화 이름을 입력하세요: ");
	int movieName=scan.nextInt();
	
	int closestMovie=-1;
	double minDistance=1000; // 마커값
	for(int i=0;i<MovieName.length;i++)
	{
		double distance=0;
		double cartesianDistance=0;
		//같은 영화 이름은 제외
		if(movieName==MovieName[i]) {continue;}	
		
		//입력된 영화와 아닌 영화들의 거리를 구함.
		for (int j = 0; j < 5; j++) {
			distance+=Math.pow(MovieScore[j][movieName%100]-MovieScore[j][i],2);
		}
		cartesianDistance=Math.sqrt(distance);	
		//각 영화별 distance 값에 띠라 minDistance(최소거리) 최신화
		if(cartesianDistance<minDistance)
		{
			minDistance=cartesianDistance;
			closestMovie=MovieName[i];
		}
	}
	
	System.out.println("입력한 영화와 비슷한 영화는 "+closestMovie +"입니다.");
	System.out.println("차이값은"+minDistance+"입니다.");

	scan.close();
		
	}

}
