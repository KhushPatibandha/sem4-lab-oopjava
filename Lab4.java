import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Volumes v1 = new Volumes(5);
        
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter length: ");
                int length = sc.nextInt();
                Volumes v2 = new Volumes(length);
                System.out.println("Volume of cube: " + v2.getVolume());
                break;
            case 2:
                System.out.println("Enter length, breadth, height: ");
                int l = sc.nextInt();
                int b = sc.nextInt();
                int h = sc.nextInt();
                Volumes v3 = new Volumes(l, b, h);
                System.out.println("Volume of cuboid: " + v3.getVolume());
                break;
            case 3:
                System.out.println("Enter radius, height: ");
                int r = sc.nextInt();
                int h1 = sc.nextInt();
                Volumes v4 = new Volumes(r, h1);
                System.out.println("Volume of cylinder: " + v4.getVolume());
            case 4:
                System.out.println("Enter variable name: ");
                Volumes v5 = new Volumes(v1);
                System.out.println("Volume of cube: " + v5.getVolume());
                break;

            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}

class Volumes {
    int length;
    int breadth;
    int height;
    int radius;
    double result;

    public Volumes(int length) {
        this.length = length;
        result = this.length * this.length * this.length;
    }

    public Volumes(int length, int breadth, int height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        result = this.length * this.breadth * this.height;
    }

    public Volumes(int radius, int height) {
        this.radius = radius;
        this.height = height;
        result = 3.14 * this.radius * this.radius * this.height;
    }

    public Volumes(Volumes v) {
        result = v.result;
    }

    public double getVolume() {
        return result;
    } 
}
