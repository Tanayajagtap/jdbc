package util;

import java.util.Collection;
import java.util.Scanner;

public class StudentJdbcMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		StudentDao<Student, Integer> studdao = new StudentDaoImpl();
		
		do {
			System.out.println("-----CRUD Operation-----"
					+ "\n1. Display All Student"
					+ "\n2. Get Student Detail"
					+ "\n3. Add Student");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				
				Collection<Student> studList= studdao.getAll();
			//	studList.stream().forEach(stud->System.out.println(stud));
				for(Student stud :studList)
					System.out.println(stud);
				break;
			case 2:
				System.out.println("Enter Rollno : ");
				Student stud = studdao.getOne(sc.nextInt());
				if(stud != null)
					System.out.println(stud);
				else
					System.out.println("Student of this rollno does not Exist");
				break;
			case 3:
				System.out.println("Enter rollno , name , city");
				Student s = new Student(sc.nextInt(), sc.next(), sc.next());
				studdao.add(s);
				break;
			}
		}while(ch!=3);
		sc.close();
	}
}
