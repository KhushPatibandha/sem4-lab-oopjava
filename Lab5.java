import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        int vovelCount = 0;
        int consonantCount = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int asciiVal = (int) c;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vovelCount++;
            } else if (asciiVal >= 97 && asciiVal <= 122) {
                consonantCount++;
            } else {
                continue;
            }
        }
        System.out.println("Total vovels found: " +vovelCount);
        System.out.println("Total consonat found: " + consonantCount);
        sc.close();
    }
}
