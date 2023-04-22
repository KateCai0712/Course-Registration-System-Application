import java.util.*;

public interface InterfaceStudent {
	public void viewAllCourses(ArrayList<Course> list);
	public void viewAllFullCourses(ArrayList<Course> list);
	public void registerOnACourse(String courseName, int section, String firstName, String lastNmae, ArrayList<Course> list);
	public void withdrawFromACourse(String firstName, String lastName, String courseName, int section, ArrayList<Course> list);
	public void viewAllCoursesRegistered(String firstName, String lastName);
}
