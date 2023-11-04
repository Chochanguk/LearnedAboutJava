package moso_programming1_3;

abstract class Person {
    String personName;
    String birthDate;
    String homeAddress;
    //Person의 생성자
    public Person(String name, String date, String address) {
        this.personName = name;
        this.birthDate = date;
        this.homeAddress = address;
    }
    //name getter
    String getName() {
        return personName;
    }
    //생년월일 getter
    String getBirthDate() {
        return birthDate;
    }
    //name setter
    void setName(String name) {
        this.personName = name;
    }
    //생년월일 setter
    void setBirthDate(String date) {
        this.birthDate = date;
    }
}
//Person을 상속
class Employee extends Person {
    String employeeID;
    int monthlySalary;
    //public static int employeeInstanceCount = 0; // 정적변수로 저장해서 인스턴스 증가마다 카운트 하기
    //Employee 생성자
    public Employee(String name, String date, String address, int salary, String id) {
        super(name, date, address);
        this.employeeID = id;
        this.monthlySalary = salary;
     //   employeeInstanceCount++;
    }
    //입력 받은 월급getter
    int getMonthlySalary() {
        return monthlySalary;
    }
}

class Student extends Person {
    String studentID;
    double GPA;
   // public static int studentInstanceCount = 0;
    public Student(String name, String date, String address, double gpa, String id) {
        super(name, date, address);
        this.studentID = id;
        this.GPA = gpa;
        //studentInstanceCount++;
    }

    double getGPA() {
        return GPA;
    }
}

public class MainforPerson {
    public static void main(String[] args) {
    	System.out.println("<programming 1_3 homework-2019112174 조창욱>\n");
    	
    	// Employee 임의의 인스턴스 5개 생성
    	Employee e1 =new Employee("조창욱", "1999/03/08", "서울시 관악구", 450, "2024112174");
		Employee e2 =new Employee("박창수", "1999/03/18", "경기도 안양시", 380, "2025112163");
		Employee e3 =new Employee("이은지", "2000/02/08", "서울시 노원구", 300, "2025123124");
		Employee e4 =new Employee("김선우", "1999/03/08", "서울시 도봉구", 330, "2025142124");
		Employee e5 =new Employee("박득용", "1999/03/08", "경기도 성남시", 350, "2026124124");
		//Student 임의의 인스턴스 5개 생성 
		Student s1= new Student("이정민","2000/12/31","서울시 도봉구",3.5,"2019110183");
		Student s2= new Student("김산하","2000/03/10","서울시 도봉구",3.2,"2019112121");
		Student s3= new Student("심판석","2000/06/18","서울시 중 구",3.4,"2019101213");
		Student s4= new Student("정재민","2000/11/23","서울시 동작구",4.0,"2019112173");
		Student s5= new Student("한승주","1999/12/12","서울시 강남구",3.9,"2019112134");
		
		
        // Employee들의 평균 월급 계산
        double avgSalary = ((e1.getMonthlySalary() + e2.getMonthlySalary() + 
        e3.getMonthlySalary() + e4.getMonthlySalary() + e5.getMonthlySalary()) /5);
        
        System.out.println("직원들의 평균 월급: " + avgSalary+"만원");

        // Student들의 평균 학점 계산
        double avgGPA = ((s1.getGPA() + s2.getGPA() + s3.getGPA() 
        + s4.getGPA() + s5.getGPA()) / 5);
        System.out.println("학생들의 평균 학점(GPA): " + avgGPA+"점");
    
    }
}
