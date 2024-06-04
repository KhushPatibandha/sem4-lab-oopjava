import java.io.*;

public class Lab12 {
    public static void main(String[] args) {
        FileIOTest fileIOTest = new FileIOTest();
        BufferTest bufferTest = new BufferTest();

        fileIOTest.test();
        bufferTest.test();
    }
}

class FileIOTest {
    void test() {
        try {
            long startTime = System.nanoTime();
            writeFile();
            long endTime = System.nanoTime();
            System.out.println("Time taken by FileOutputStream: " + (endTime - startTime));

            startTime = System.nanoTime();
            readFile();
            endTime = System.nanoTime();
            System.out.println("Time taken by FileInputStream: " + (endTime - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");
        fos.write("Hello, World!".getBytes());
        fos.close();
    }

    void readFile() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, length));
        }
        fis.close();
    }
}

class BufferTest {
    void test() {
        try {
            long startTime = System.nanoTime();
            writeFile();
            long endTime = System.nanoTime();
            System.out.println("Time taken by BufferedWriter: " + (endTime - startTime));

            startTime = System.nanoTime();
            readFile();
            endTime = System.nanoTime();
            System.out.println("Time taken by BufferedReader: " + (endTime - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
        bw.write("Hello, World!");
        bw.close();
    }

    void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        System.out.println(br.readLine());
        br.close();
    }
}