package pracQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// Question: Do sum in parallel. One thread adds only even numbers from the list, while the 2nd thread does the sum of odd numbers

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("How many numbers you want to enter?");
        int n = sc.nextInt();

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        final int[] sum1 = {0};
        final int[] sum2 = {0};

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) % 2 == 0) {
                    sum1[0] += list.get(i);
                    System.out.println("Adding ON THREAD 1: " + list.get(i));
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) % 2 != 0) {
                    sum2[0] += list.get(i);
                    System.out.println("Adding ON THREAD 2: " + list.get(i));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(sum1[0] + sum2[0]);

        sc.close();
    }
}
