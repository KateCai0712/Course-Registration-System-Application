import java.util.*;
import java.io.*;

public class Course implements Serializable{
	private String courseName;
	private String courseId;
	private int maximumStudents;
	private int currentStudents;
	private ArrayList<Student> listOfNames = new ArrayList<Student>();
	private String courseInstructor;
	private int courseSectionNumber;
	private String courseLocation;
	
	//constructor
	public Course() {
		
	}
	public Course(String name, String id, int maximum, String instructor, int secNum, String location) {
		this.courseName = name;
		this.courseId = id;
		this.maximumStudents = maximum;
		this.courseInstructor = instructor;
		this.courseSectionNumber = secNum;
		this.courseLocation = location;
	}
	//getters and setters
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getMaximumStudents() {
		return maximumStudents;
	}
	public void setMaximumStudents(int maximumStudents) {
		this.maximumStudents = maximumStudents;
	}
	public int getCurrentStudents() {
		return currentStudents;
	}
	public void setCurrentStudents(int currentStudents) {
		this.currentStudents = currentStudents;
	}
	public ArrayList<Student> getListOfNames() {
		return listOfNames;
	}
	public void setListOfNames(ArrayList<Student> listOfNames) {
		this.listOfNames = listOfNames;
	}
	public String getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public int getCourseSectionNumber() {
		return courseSectionNumber;
	}
	public void setCourseSectionNumber(int courseSectionNumber) {
		this.courseSectionNumber = courseSectionNumber;
	}
	public String getCourseLocation() {
		return courseLocation;
	}
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	//methods 
	public void addStudent(String firstName, String lastName) {
		Student newStudent = new Student(firstName, lastName);
		listOfNames.add(newStudent);
	}
	
	public void deleteStudent(String firstName, String lastName) {
		for(int i=0; i<listOfNames.size(); i++) {
			if(listOfNames.get(i).getFirstName().equalsIgnoreCase(firstName) && listOfNames.get(i).getLastName().equalsIgnoreCase(lastName)) {
			Student deleteStudent = new Student(firstName, lastName);
			listOfNames.remove(deleteStudent);
			}
		}
	}
	
	public void displayAllInformation(ArrayList<Course> list) {
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getCourseName() + ", " + list.get(i).getCourseId() + ", " + list.get(i).getMaximumStudents() + ", " 
					+ list.get(i).getCourseInstructor() + ", " + list.get(i).getCourseSectionNumber() + ", " + list.get(i).getCourseLocation());
		}
	}
}
