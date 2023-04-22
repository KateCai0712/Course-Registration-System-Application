import java.io.*;
import java.util.*;

public interface InterfaceAdmin {
	public void createANewCourse(Course a, ArrayList<Course> list);
	public void deleteACourse(int secNum, String id, ArrayList<Course> list);
	public void editACourse(int secNum, String id, ArrayList<Course> list);
	public void displayInformationForAGivenCourse(int secNum, String id, ArrayList<Course> list);
	public void registerAStudent(String username, String password, String firstName, String lastName);
	public void viewAllCourses(ArrayList<Course> list);
	public void viewAllFullCourses(ArrayList<Course> list);
	public void writeFullCoursesToAFile(ArrayList<Course> list) throws IOException;
	public void viewStudentsRegisteredInASpecificCourse(int secNum, String id, ArrayList<Course> list);
	public void viewAllCourses(String firstName, String lastName, ArrayList<Course> list);
	public void sortCoursesBasedOnCurrentStudentNumbers(ArrayList<Course> list);
}
