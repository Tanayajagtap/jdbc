package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDaoImpl implements StudentDao<Student ,Integer>{

	@Override
	public Collection<Student> getAll() {
		Collection<Student> allStudent = new ArrayList<>();
		try(
				Connection dbConnection = StudentUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery("select * from student");
				){
			while(rs.next()) {
				int rollno = rs.getInt("rollno");
				String name = rs.getString("name");
				String city = rs.getString("city");
				Student stud = new Student(rollno, name, city);
				allStudent.add(stud);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return allStudent;
	}

	@Override
	public Student getOne(Integer rollno){
		Student foundStudent = null;
		String sqlQuery = "select * from student where rollNo =?";
		try(
				Connection dbConnection = StudentUtils.buildConnection();
				PreparedStatement stmt = dbConnection.prepareStatement(sqlQuery);
				){
			stmt.setInt(1, rollno); 
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int rollNo = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				foundStudent = new Student(rollNo, name, city);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	return foundStudent;
	}

	@Override
	public void add(Student stud) {
		String sqlQuery = "insert into student values(?,?,?)";
		try(
				Connection dbConnection = StudentUtils.buildConnection();
				PreparedStatement stmt = dbConnection.prepareStatement(sqlQuery);
				){
			int rollno = stud.getRollno();
			String name = stud.getName();
			String city = stud.getCity();
			
			stmt.setInt(1, rollno);
			stmt.setString(2, name);
			stmt.setString(3, city);
		int updateCount = stmt.executeUpdate();
		System.out.println(updateCount + " record inserted");
			
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	@Override
	public void update(Student t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub
		
	}

}
