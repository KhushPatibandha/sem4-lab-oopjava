import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab12 {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("lab12.txt")));
            bw.write("Hello my name is khush");
            bw.newLine();
            bw.flush();
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader(new File("lab12.txt")));
            String line = br.readLine();
            System.out.println(line);
            br.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
