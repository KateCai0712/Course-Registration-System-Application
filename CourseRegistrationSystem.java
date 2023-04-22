import java.io.*;
import java.util.*;

public class CourseRegistrationSystem implements Serializable{
	public static void main(String[] args) throws IOException {
		ArrayList<Course> list= new ArrayList<Course>();
		
		int choice = 0;
		
		String username;
		String password;
		String firstName;
		String lastName;
		
		String courseName;
		String courseId;
		int maximumStudents;
//		int currentStudents;
//		ArrayList<Student> listOfNames = new ArrayList<Student>();
		String courseInstructor;
		int courseSectionNumber;
		String courseLocation;
		
		File ser = new File("List.ser");
		//deserializtion
		try{
            FileInputStream fis = new FileInputStream("List.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Course>) ois.readObject();
            ois.close();
            fis.close();
 
         }catch(IOException ioe){
             /*ioe.printStackTrace();
             return;*/
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
		if(!ser.exists()) {
			try {
			//while loop to read file
				String fileName = "src/MyUniversityCoursesFile.csv";
				FileReader reader = new FileReader(fileName);
				Scanner input1 = new Scanner(reader);
				String line1 = input1.nextLine();
				
				while(input1.hasNextLine()) {
					String line2 = input1.nextLine();
					String[] split= line2.split(",");
					Course a = new Course(split[0], split[1], Integer.parseInt(split[2]), split[5], Integer.parseInt(split[6]), split[7]);
					list.add(a);
				}
				input1.close();
			}catch(IOException ioe) {
				ioe.printStackTrace();
	            return;
			}
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter username:");
		username = input.nextLine();
		System.out.println("Please enter password:");
		password = input.nextLine();
		//Admin log in
		if(username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("Admin001")) {
			System.out.println("Welcome Admin!\nPlease enter first name:");
			firstName = input.nextLine();
			System.out.println("Please enter last name:");
			lastName = input.nextLine();
			Admin a = new Admin(username, password, firstName, lastName);
			//deserializtion
			try
	        {
	            FileInputStream fis = new FileInputStream("Student.ser");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            a.setAllStudent((ArrayList<Student>) ois.readObject());
	            ois.close();
	            fis.close();
	 
	         }catch(IOException ioe){
	             /*ioe.printStackTrace();
	             return;*/
	          }catch(ClassNotFoundException c){
	             System.out.println("Class not found");
	             c.printStackTrace();
	             return;
	          }
			//display menu and make changes
			do{
				System.out.println("Please ONLY enter a number:\n"
						+ "Course Management:\n"
						+ "1. Create a new course\n"
						+ "2. Delete a course\n"
						+ "3. Edit a course\n"
						+ "4. Display information for a given course\n"
						+ "5. Register a student\n"
						+ "Reports:\n"
						+ "6. View all courses\n"
						+ "7. View all courses that are full\n"
						+ "8. Write to a file the list of course that are Full\n"
						+ "9. View the names of the students being registered in a specific course\n"
						+ "10. View the list of courses that a given student is being registered on\n"
						+ "11. Sort courses based on the current number of student registers\n"
						+ "12. Exit");
				choice = Integer.parseInt(input.nextLine());
				
				if(choice == 1) {
					System.out.println("Creating a new course now!\n"
							+ "Please enter course name:");
					courseName = input.nextLine();
					System.out.println("Please enter course id:");
					courseId = input.nextLine();
					System.out.println("Please enter maximum students:");
					maximumStudents = Integer.parseInt(input.nextLine());
					System.out.println("please enter course instructor:");
					courseInstructor = input.nextLine();
					System.out.println("Please enter course section number:");
					courseSectionNumber = Integer.parseInt(input.nextLine());
					System.out.println("please enter course location:");
					courseLocation = input.nextLine();
					Course newCourse = new Course(courseName, courseId, maximumStudents, courseInstructor, courseSectionNumber, courseLocation);
					
					a.createANewCourse(newCourse, list);
					System.out.println("A new course created.");
					
				}else if(choice == 2) {
					System.out.println("Deleting a course now!\n"
							+ "Please enter course section number:");
					courseSectionNumber = Integer.parseInt(input.nextLine());
					System.out.println("Please enter course id:");
					courseId = input.nextLine();
					
					a.deleteACourse(courseSectionNumber, courseId, list);
					
				}else if(choice == 3) {
					System.out.println("Editing a course now!\n"
							+ "Please enter course section number:");
					courseSectionNumber = Integer.parseInt(input.nextLine());
					System.out.println("Please enter course id:");
					courseId = input.nextLine();
					
					a.editACourse(courseSectionNumber, courseId, list);
					
				}else if(choice == 4) {
					System.out.println("Displaying information for a given course now!\n"
							+ "Please enter course section number:");
					courseSectionNumber = Integer.parseInt(input.nextLine());
					System.out.println("Please enter course id:");
					courseId = input.nextLine();
					
					a.displayInformationForAGivenCourse(courseSectionNumber, courseId, list);
					
				}else if(choice == 5) {
					System.out.println("Registering a student now!\n"
							+ "Please enter username:");
					username = input.nextLine();
					System.out.println("Please enter password:");
					password = input.nextLine();
					System.out.println("Please enter first name:");
					firstName = input.nextLine();
					System.out.println("Plase enter last name:");
					lastName = input.nextLine();
					
					a.registerAStudent(username, password, firstName, lastName);
					
				}else if(choice == 6) {
					System.out.println("Viewing all courses now!");
					
					a.viewAllCourses(list);
					
				}else if(choice == 7) {
					System.out.println("Viewing all full courses now!");
					
					a.viewAllFullCourses(list);
					
				}else if(choice == 8) {
					System.out.println("Writing full courses to a file now!");
					
					a.writeFullCoursesToAFile(list);
					
				}else if(choice == 9) {
					System.out.println("Viewing names of the students being registered in a specific course now!\n"
							+ "Please enter course section number:");
					courseSectionNumber = Integer.parseInt(input.nextLine());
					System.out.println("Please enter course id:");
					courseId = input.nextLine();
					
					a.viewStudentsRegisteredInASpecificCourse(courseSectionNumber, courseId, list);
					
				}else if(choice == 10) {
					System.out.println("Viewing the list of courses that a given student is being registered on!\n"
							+ "Please enter first name:");
					firstName = input.nextLine();
					System.out.println("Please enter last name:");
					lastName = input.nextLine();
					
					a.viewAllCourses(firstName, lastName, list);
					
				}else if(choice == 11) {
					System.out.println("Sorting courses now!");
					
					a.sortCoursesBasedOnCurrentStudentNumbers(list);
					
				}
			}while(choice != 12);
			System.out.println("Logging off now!");
			//serializtion
			try{
		         FileOutputStream fos= new FileOutputStream("List.ser");
		         ObjectOutputStream oos= new ObjectOutputStream(fos);
		         oos.writeObject(list);
		         oos.close();
		         fos.close();
		       }catch(IOException ioe){
		            ioe.printStackTrace();
		        }
		//Student log in
		}else{
			System.out.println("Welcome Student!\nPlease enter first name:");
			firstName = input.nextLine();
			System.out.println("Please enter last name:");
			lastName = input.nextLine();
				
			Student s = new Student(username, password, firstName, lastName);
			//display menu and make changes
			do {
				System.out.println("Please ONLY enter a number:\n"
						+ "Course Management:\n"
						+ "1. View all courses\n"
						+ "2. View all courses that are not full\n"
						+ "3. Register on a course\n"
						+ "4. Withdraw from a course\n"
						+ "5. View all courses that the current student is being registered in\n"
						+ "6. Exit");
				choice = Integer.parseInt(input.nextLine());
				
				if(choice == 1) {
					System.out.println("Viewing all courses now!");
					
					s.viewAllCourses(list);
					
				}else if(choice == 2) {
					System.out.println("Viewing all courses that are not full now!");
					
					s.viewAllFullCourses(list);
					
				}else if(choice == 3) {
					System.out.println("Registering on a course now!\n"
							+ "Please enter course name:");
					courseName = input.nextLine();
					System.out.println("Please enter course section number:");
					courseSectionNumber = Integer.parseInt(input.nextLine());
					
					s.registerOnACourse(courseName, courseSectionNumber, firstName, lastName, list);
					
				}else if(choice == 4) {
					System.out.println("Withdrawing from a course now!\n"
							+ "Please enter course name:");
					courseName = input.nextLine();
					System.out.println("Please enter course section number:");
					courseSectionNumber = Integer.parseInt(input.nextLine());
					
					s.withdrawFromACourse(firstName, lastName, courseName, courseSectionNumber, list);
					
				}else if(choice == 5) {
					System.out.println("Viewing all courses that the current student is being registered in now!");
					
					s.viewAllCoursesRegistered(firstName, lastName);
				}
			}while(choice != 6);
			System.out.println("Logging off now!");
				
		//serialization	
		}
		try{
	         FileOutputStream fos= new FileOutputStream("Student.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(User.allStudent);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		try{
	         FileOutputStream fos= new FileOutputStream("List.ser");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(list);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	}
}
