package moso_programming1_2;
//2019112174 조창욱
import java.io.*;
import java.util.*;

public class CommonNumber {
    public static void main(String[] args) {
    	System.out.println("<programming 1_2 homework-2019112174 조창욱>\n");
        try {
            // first.txt와 second.txt에서 readNumbersFromFile이라는 메소드를 통해 숫자를 읽어 각각의 배열에 저장
            String[] first_numbers = readNumbersFromFile("first.txt");
            String[] second_numbers = readNumbersFromFile("second.txt");
            
            //공통 숫자들 저장 배열(결과 배열), 크기는 더 작은 배열의 사이즈로 초기화.
            String[] commonNumbers = new String[Math.min(first_numbers.length, second_numbers.length)];
            //공통 숫자 카운팅 변수
            int commonCount = 0;

            // 두 번째 배열의 숫자를 확인하면서 결과(common) 배열에도 있는지 검사
            for (int i = 0; i < first_numbers.length; i++) 
			{
            	String check_num= first_numbers[i];
            	//contains 메소드 사용
            	if(isSame(second_numbers, check_num) && !isSame(commonNumbers,check_num))
            		commonNumbers[commonCount++]=check_num;
			}
            // third.txt 파일에 공통된 숫자 쓰기(writeNumbersTOFile 메소드 사용)
            writeNumbersToFile(commonNumbers, commonCount, "third.txt");
            //확인 차 만든 메소드
            System.out.println("공통된 숫자들을 찾았습니다. 두파일에서 공통된 숫자는 다음과 같습니다.");
            for (String result_numbers : commonNumbers) {
            	if(result_numbers==null) continue;
            	System.out.print(result_numbers+" ");
			}
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	System.out.println("성공");
        }
        
    }
    // 파일에서 숫자를 읽어 String 배열에 저장하는 메서드
    private static String[] readNumbersFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String readNumber = reader.readLine();
        reader.close();
        return readNumber.split(" "); //string 배열에 읽은 문자열들을 " "으로 구분해서 저장
    }
    // String 배열의 숫자를 파일에 쓰는 메서드(commonNumbers 배열, 배ㅇㄹ)
    private static void writeNumbersToFile(String[] numbers, int count, String filename) throws IOException 
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < count; i++) 
        {
            writer.write(numbers[i]+" ");
        }
        writer.close();
    }
    // String 배열에서 특정 값이 있는지 확인하는 메서드
    private static boolean isSame(String[] numbers, String checking_same_num) 
    {
        for (String num : numbers) 
        {
            if (num != null && num.equals(checking_same_num)) {
                return true;
            }
        }
        return false;
    }
}
