package pracQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// Question: One thread finds minimum number, while 2nd thread finds maximum.

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("How many numbers you want to enter?");
        int n = sc.nextInt();

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        final int[] min = {Integer.MAX_VALUE};
        final int[] max = {Integer.MIN_VALUE};

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < list.size(); i++) {
                System.out.println("Thread 1 currently dealing with " + list.get(i) + " while the max for this thread is "+ max[0]);
                if(list.get(i) > max[0]) {
                    max[0] = list.get(i);
                    System.out.println("Updated max value in thread 1: " + max[0]);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < list.size(); i++) {
                System.out.println("Thread 2 currently dealing with " + list.get(i) + " while the min for this thread is "+ min[0]);
                if(list.get(i) < min[0]) {
                    min[0] = list.get(i);
                    System.out.println("Updated min value in thread 2: " + min[0]);
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

        System.out.println("Min: " + min[0]);
        System.out.println("Max: " + max[0]);

        sc.close();
    }
}
