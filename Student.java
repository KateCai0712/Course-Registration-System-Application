import java.util.ArrayList;

public class Student extends User implements InterfaceStudent{
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	protected ArrayList <Course> myCourse = new ArrayList<Course>();
	//constructor
	public Student() {
		
	}
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Student(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
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
	public ArrayList<Course> getMyCourse() {
		return myCourse;
	}
	public void setMyCourse(ArrayList<Course> myCourse) {
		this.myCourse = myCourse;
	}
	//methods for Student
	@Override
	public void viewAllCourses(ArrayList<Course> list) {
		System.out.println("All courses:");
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getCourseName());
		}
	}
	
	@Override
	public void viewAllFullCourses(ArrayList<Course> list) {
		int count = 0;
		
		System.out.println("NOT full courses are:");
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getMaximumStudents() != list.get(i).getCurrentStudents()) {
				System.out.println(list.get(i).getCourseName() + ", " + list.get(i).getCourseId() + ", " + list.get(i).getMaximumStudents() + ", " 
						+ list.get(i).getCourseInstructor() + ", " + list.get(i).getCourseSectionNumber() + ", " + list.get(i).getCourseLocation());
				count++;
			}
		}
		if(count == 0)
			System.out.println("All courses are full.");
	}
	
	public void registerOnACourse(String courseName, int section, String firstName, String lastName, ArrayList<Course> list) {
		int count = 0;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getCourseName().equalsIgnoreCase(courseName) && list.get(i).getCourseSectionNumber() == section) {
				if(list.get(i).getCurrentStudents() != list.get(i).getMaximumStudents()) {
					for(int j=0; j<allStudent.size(); j++) {
						if(allStudent.get(j).getFirstName().equalsIgnoreCase(firstName) && allStudent.get(j).getLastName().equalsIgnoreCase(lastName)) {
							myCourse = allStudent.get(j).getMyCourse();
							myCourse.add(list.get(i));
							allStudent.get(j).setMyCourse(myCourse);
//							System.out.println("Done.");
						}
					}
					list.get(i).addStudent(firstName, lastName);
					list.get(i).setCurrentStudents(list.get(i).getCurrentStudents()+1);
					count++;
				}
			}
		}
		if(count == 0)
			System.out.println("Error.");
	}
	
	public void withdrawFromACourse(String firstName, String lastName, String courseName, int section, ArrayList<Course> list) {
		int count = 0;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getCourseName().equalsIgnoreCase(courseName) && list.get(i).getCourseSectionNumber() == section) {
				for(int j=0; j<allStudent.size(); j++) {
					if(allStudent.get(j).getFirstName().equalsIgnoreCase(firstName) && allStudent.get(j).getLastName().equalsIgnoreCase(lastName)) {
						myCourse = allStudent.get(j).getMyCourse();
						myCourse.remove(list.get(i));
					}
				}
				list.get(i).deleteStudent(firstName, lastName);
				list.get(i).setCurrentStudents(list.get(i).getCurrentStudents()-1);
				count++;
			}
		}
		if(count == 0)
			System.out.println("Error.");
	}
	
	public void viewAllCoursesRegistered(String firstName, String lastName) {
		for(int i=0; i<allStudent.size(); i++) {
			if(allStudent.get(i).getFirstName().equalsIgnoreCase(firstName) && allStudent.get(i).getLastName().equalsIgnoreCase(lastName)) {
				for (Course registeredCourse: allStudent.get(i).getMyCourse()) {
					System.out.println(registeredCourse.getCourseName());
				}
			}
		}
	}
}
