import java.io.BufferedReader;
import java.io.FileReader;

public class Lab9 {
    public static void main(String[] args) {
        // unchecked exception
        try {
            int a = 10;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        } catch (Exception e) {
            System.err.println("Division by zero");
        }

        // checked exception
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(file);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File not found");
        }

        // User defined exception
        try {
            int b = 0;
            if(b == 0) {
                throw new ExceptionA("hii....");
            }
        } catch (ExceptionA e) {
            System.out.println(e.getMessage()); 
        }
    }
}

class ExceptionA extends Exception {
    public ExceptionA(String message) {
        super(message);
    }
}
