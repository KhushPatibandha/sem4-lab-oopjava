import java.util.Scanner;

public class Practical2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Subject obj = new Subject();
        System.out.println("Enter marks of first subject");
        obj.sub1 = sc.nextInt();
        System.out.println("Enter marks of second subject");
        obj.sub2 = sc.nextInt();
        System.out.println("Enter marks of third subject");
        obj.sub3 = sc.nextInt();
        System.out.println("Enter marks of fourth subject");
        obj.sub4 = sc.nextInt();

        System.err.println("Average marks: " + obj.average());
        sc.close(); 
    }
}

class Subject {
    int sub1;
    int sub2;
    int sub3;
    int sub4;

    int average() {
        return (sub1 + sub2 + sub3 + sub4) / 4;
    }
}