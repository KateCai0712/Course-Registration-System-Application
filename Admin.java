import java.util.*;
import java.io.*;

public class Admin extends User implements InterfaceAdmin{
	Scanner input = new Scanner(System.in);
	//constructor
	public Admin() {
		
	}
	public Admin(String username, String password) {
		super.username = username;
		super.password = password;
	}
	public Admin(String username, String password, String firstName, String lastName) {
		super();
	}
	//methods for Admin
	public void createANewCourse(Course a, ArrayList<Course> list) {
		list.add(a);
	}
	
	public void deleteACourse(int secNum, String id, ArrayList<Course> list) {
		int count = 0;
		
		for (int i=0; i<list.size(); i++) {
			if(secNum == list.get(i).getCourseSectionNumber() && id.equalsIgnoreCase(list.get(i).getCourseId())) {
				list.remove(i);
				System.out.println(secNum + id + " is deleted.");
				count++;
			}	
		}
		if(count==0)
			System.out.println(secNum + id + " is not found.");
	}
	
	public void editACourse(int secNum, String id, ArrayList<Course> list) {
		int count = 0;
		int num = 0;
		
		for (int i=0; i<list.size(); i++) {
			if(secNum == list.get(i).getCourseSectionNumber() && id.equalsIgnoreCase(list.get(i).getCourseId())) {
				//System.out.println(courseName + id);
				
				System.out.println("What do you want to edit for " + secNum + id + " (ONLY enter number)?");
				System.out.println("1. Maximum students \n 2. Course instructor \n 3. Course location");
				num = Integer.parseInt(input.nextLine());
				if(num == 1) {
					System.out.println("Enter new maximum students: ");
					int max = Integer.parseInt(input.nextLine());
					list.get(i).setMaximumStudents(max);
					System.out.println("Maximum students edited.");
				}else if (num == 2) {
					System.out.println("Enter new course instructor: ");
					String instruct = input.nextLine();
					list.get(i).setCourseInstructor(instruct);
					System.out.println("Course instructor edited.");
				}else if (num == 3) {
					System.out.println("Enter new course location: ");
					String location = input.nextLine();
					list.get(i).setCourseLocation(location);
					System.out.println("Course location edited.");
				}else {
					System.out.println("Error. Please only enter 1, 2, 3.");
				}
				count++;
			}
		}
		if (count == 0) 
			System.out.println(id + " is not found.");
	}
	
	public void displayInformationForAGivenCourse(int secNum, String id, ArrayList<Course> list) {
		int count = 0;
		
		for (int i=0; i<list.size(); i++) {
			if(secNum == list.get(i).getCourseSectionNumber() && id.equalsIgnoreCase(list.get(i).getCourseId())) {
				list.get(i).displayAllInformation(list);
				count++;
			}
		}
		if (count == 0)
			System.out.println(secNum + id + " is not found.");
	}
	
	public void registerAStudent(String username, String password, String firstName, String lastName) {
		Student newStudent = new Student(username, password, firstName, lastName);
		allStudent.add(newStudent);
	}
	
	public void viewAllCourses(ArrayList<Course> list) {
		super.viewAllCourses(list);
	}
	
	public void viewAllFullCourses(ArrayList<Course> list) {
		super.viewAllFullCourses(list);
	}
	
	public void writeFullCoursesToAFile(ArrayList<Course> list) throws IOException {
		int count = 0;
		
		FileWriter fw = new FileWriter("src/FullCourses.csv");
		for(int i=0; i<list.size(); i++) {
			String fullCourses = list.get(i).toString();
			fw.write(fullCourses);
			count++;
		}
		fw.close();
		if(count == 0)
			System.out.println("Nothing is wrote to a file.");
		else
			System.out.println("All full courses are written to a file.");
	}
	
	public void viewStudentsRegisteredInASpecificCourse(int secNum, String id, ArrayList<Course> list) {
		System.out.println("Students registered in " + id + secNum + ": ");
		for(int i=0; i<list.size(); i++) {
			if(secNum == list.get(i).getCourseSectionNumber() && list.get(i).getCourseId().equalsIgnoreCase(id)) {
				System.out.println(list.get(i).getListOfNames());
			}
		}
	}
	
	public void viewAllCourses(String firstName, String lastName, ArrayList<Course> list) {
		System.out.println("Courses registered by " + firstName + lastName + ": ");
		for(int i=0; i<allStudent.size(); i++) {
			if(allStudent.get(i).getFirstName().equalsIgnoreCase(firstName) && allStudent.get(i).getLastName().equalsIgnoreCase(lastName)) {
				System.out.println(allStudent.get(i).getMyCourse());
			}
		}
	}
	
	public void sortCoursesBasedOnCurrentStudentNumbers(ArrayList<Course> list) {
		int min, minIndex;
		Course temp;
		
		for(int i=0; i<list.size()-1; i++) {
			min = list.get(i).getCurrentStudents();
			minIndex = i;
			for(int j=i+1; j<list.size(); j++) {
				if(min>list.get(j).getCurrentStudents()) {
					min = list.get(j).getCurrentStudents();
					minIndex = j;
				}
			}
			if(i != minIndex) {
				temp = list.get(i);
				list.set(i, list.get(minIndex));
				list.set(minIndex, temp);
			}
		}
		System.out.println("Sorting completed.");
	}

}
