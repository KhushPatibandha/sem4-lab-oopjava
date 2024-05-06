import java.util.ArrayList;
import java.util.List;

public class Lab11_2 {
    
    public static void main(String[] args) {
        Course c1 = new Course("OOPJ", 10, 100);
        
        Student s1 = new Student("Khush", 50);
        Student s2 = new Student("Harsh", 60);
        Student s3 = new Student("Varun", 70);
        
        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);
        
        Course c2 = new Course("MATHS", 11, 100);
        
        Student s4 = new Student("Khush", 90);
        Student s5 = new Student("Harsh", 80);
        
        c2.addStudent(s4);
        c2.addStudent(s5);

        Thread t1 = new Thread(() -> {
            int sum = 0;
            
            for(Student s : c1.getStudents()) {
                sum += s.getMarkAchived();
            }
            c1.setAverage(sum / c1.getStudents().size());
        });

        Thread t2 = new Thread(() -> {
            int sum = 0;
            
            for(Student s : c2.getStudents()) {
                sum += s.getMarkAchived();
            }
            c2.setAverage(sum / c2.getStudents().size());
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            System.out.println("Average of C1: " + c1.getAverage());
            System.out.println("Average of C2: " + c2.getAverage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Student {
    private String studentName;
    private int markAchived;
    
    public Student(String studentName, int markAchived) {
        this.studentName = studentName;
        this.markAchived = markAchived;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getMarkAchived() {
        return markAchived;
    }

    public void setMarkAchived(int markAchived) {
        this.markAchived = markAchived;
    }

}

class Course {
    private String courseName;
    private int credit;
    private int maxMarks;
    private double average;
    private List<Student> students;
    private static List<Course> courses = new ArrayList<>();

    public Course(String courseName, int credit, int maxMarks) {
        this.courseName = courseName;
        this.credit = credit;
        this.maxMarks = maxMarks;
        this.average = 0;
        this.students = new ArrayList<>();
    }
    
    public static List<Course> getCourses() {
        return courses;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double getAverage() {
        return average;
    }
    
    public void setAverage(double average) {
        this.average = average;
    }
}
