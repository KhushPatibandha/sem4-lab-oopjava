import java.util.Scanner;

public class Assignment1 {
    int a;
    int b;
    private int sum() {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Assignment1 obj = new Assignment1();
        System.out.print("Enter the value of first variable:");
        obj.a = sc.nextInt();
        System.out.print("Enter the value of second variable:");
        obj.b = sc.nextInt();
        sc.close();

        int res = obj.sum();
        System.out.println(res);    
    }
}
