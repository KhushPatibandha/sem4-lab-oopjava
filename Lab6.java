import java.util.ArrayList;
import java.util.Scanner;

public class Lab6 {

    private static ArrayList<Integer> counts = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a sentence to find the number of vowels: ");
            String str = sc.nextLine();
            String newStr = str.toLowerCase();
            if(newStr.equals("quit")) {
                break;
            }
            findCountForEachVowel(newStr);
        }
        sc.close();
    }

    private static void findCountForEachVowel(String str) {
        for (int i = 0; i < 5; i++) {
            counts.add(0);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a') {
                counts.set(0, counts.get(0) + 1);
            } else if (c == 'e') {
                counts.set(1, counts.get(1) + 1);
            } else if (c == 'i') {
                counts.set(2, counts.get(2) + 1);
            } else if (c == 'o') {
                counts.set(3, counts.get(3) + 1);
            } else if (c == 'u') {
                counts.set(4, counts.get(4) + 1);
            }
        }

        System.out.println("Number of A's: " + counts.get(0));
        System.out.println("Number of E's: " + counts.get(1));
        System.out.println("Number of I's: " + counts.get(2));
        System.out.println("Number of O's: " + counts.get(3));
        System.out.println("Number of U's: " + counts.get(4));
    }
}
