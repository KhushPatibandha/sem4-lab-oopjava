public class Lab3 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        System.out.println(printer.print(1));
        System.out.println(printer.print("Hello"));
        System.out.println(printer.print(3.14));
        System.out.println(printer.print(true));
    }
}

class Printer {
    public int print(int i) {
        return i;
    }

    public String print(String s) {
        return s;
    }

    public double print(double d) {
        return d;
    }

    public boolean print(boolean b) {
        return b;
    }
}