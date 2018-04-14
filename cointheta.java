import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Student {
	
	private long id;
	private String name;
	
	private String address;
	private int contact_no;
	
	public Student(long id, String name, String address,
			int contact_no) {
		super();
		this.id = id;
		this.firstName = firstName;
		
		this.address = address;
		this.contact_no = contact_no;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int contact_no() {
		return contact_no;
	}
	
	public void setContact(int contact_no) {
		this.contact_no = contact_no;
	}
	
	
	public String toString() {
		return "Student [id=" + id + ", name=" + name
				+  ", address=" + address + ", contact_no="
				+ contact_no + "]";
	}
}
//writing to CSV file



public class CsvFileWriter {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "id,name,address,contact_no";

	public static void writeCsvFile(String fileName) {
		
		//Create new students objects
		Student student1 = new Student(1, "Ahmed", "Mumbai", 25112);
		Student student2 = new Student(2, "Sara", "Finland", 23345);
		Student student3 = new Student(3, "Ali", "Manglore", 2422);
		Student student4 = new Student(4, "Samar", "agra", 2099);
		Student student5 = new Student(5, "ravi", "patna", 2288);
		Student student6 = new Student(6, "Gopu", "goa", 2176);
		
		//Create a new list of student objects
		List students = new ArrayList();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Student student : students) {
				fileWriter.append(String.valueOf(student.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getName());
				
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(student.getAddress());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(student.getContact()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}