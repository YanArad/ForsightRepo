import java.util.ArrayList;
import java.util.List;

/**
 * Student class with name, age, and faculty properties
 */
class Student {
    private String name;
    private int age;
    private String faculty;
    
    public Student(String name, int age, String faculty) {
        this.name = name;
        this.age = age;
        this.faculty = faculty;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", faculty='" + faculty + "'}";
    }
}

/**
 * College class that stores a list of Student objects
 */
class College {
    private String collegeName;
    private List<Student> students;
    
    public College(String collegeName) {
        this.collegeName = collegeName;
        this.students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void removeStudent(Student student) {
        students.remove(student);
    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    public String getCollegeName() {
        return collegeName;
    }
    
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    
    public void displayAllStudents() {
        System.out.println("Students in " + collegeName + ":");
        for (Student student : students) {
            System.out.println("  " + student);
        }
    }
    
    public int getStudentCount() {
        return students.size();
    }
}

/**
 * CollegeUtils - Main class with example usage
 */
public class CollegeUtils {
    public static void main(String[] args) {
        // Create a College object
        College college = new College("Foresight University");
        
        // Create at least 3 Student objects
        Student student1 = new Student("Alice Johnson", 20, "Computer Science");
        Student student2 = new Student("Bob Smith", 22, "Engineering");
        Student student3 = new Student("Carol Williams", 21, "Business Administration");
        
        // Add students to the college
        college.addStudent(student1);
        college.addStudent(student2);
        college.addStudent(student3);
        
        // Display all students
        college.displayAllStudents();
        
        // Display student count
        System.out.println("\nTotal students: " + college.getStudentCount());
    }
}
