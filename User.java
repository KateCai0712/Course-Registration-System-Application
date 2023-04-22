import java.util.*;
import java.io.*;

public abstract class User implements Serializable{
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected ArrayList <Student> studentListOfAClass = new ArrayList<Student>();
	protected static ArrayList <Student> allStudent = new ArrayList<Student>();
	
	//constructor
	public User() {
		
	}
	public User(String username, String password, String firstN, String lastN) {
		this.username = username;
		this.password = password;
		this.firstName = firstN;
		this.lastName = lastN;
	}
	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<Student> getStudentListOfAClass() {
		return studentListOfAClass;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentListOfAClass = studentList;
	}
	public ArrayList<Student> getAllStudent() {
		return allStudent;
	}
	public void setAllStudent(ArrayList<Student> allStudent) {
		this.allStudent = allStudent;
	}
	
	//methods
	public void viewAllCourses(ArrayList<Course> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getCourseName() + ", " + list.get(i).getCourseId() + ", " + list.get(i).getMaximumStudents() + ", " 
			+ list.get(i).getCourseInstructor() + ", " + list.get(i).getCourseSectionNumber() + ", " + list.get(i).getCourseLocation());
		}
	}
	
	public void viewAllFullCourses(ArrayList<Course> list) {
		int count = 0;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getMaximumStudents() == list.get(i).getCurrentStudents()) {
				System.out.println("All full courses are: " + list.get(i).getCourseName() + ", " + list.get(i).getCourseId() + ", " + list.get(i).getMaximumStudents() + ", " 
						+ list.get(i).getCourseInstructor() + ", " + list.get(i).getCourseSectionNumber() + ", " + list.get(i).getCourseLocation());
				count++;
			}
		}
		if(count == 0)
			System.out.println("There are no courses that are full.");
	}
	
}
