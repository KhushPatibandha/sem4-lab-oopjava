package pracQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// Question: Find the minimum number from the list.

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("How many numbers you want to enter?");
        int n = sc.nextInt();

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        final int[] min1 = {Integer.MAX_VALUE};
        final int[] min2 = {Integer.MAX_VALUE};

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < list.size() / 2; i++) {
                System.out.println("Thread 1 currently dealing with " + list.get(i) + " while the min for this thread is "+ min1[0]);
                if(list.get(i) < min1[0]) {
                    min1[0] = list.get(i);
                    System.out.println("Updated min value in thread 1: " + min1[0]);
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            for(int i = list.size() / 2; i < list.size(); i++) {
                System.out.println("Thread 2 currently dealing with " + list.get(i) + " while the min for this thread is "+ min2[0]);
                if(list.get(i) < min2[0]) {
                    min2[0] = list.get(i);
                    System.out.println("Updated min value in thread 2: " + min2[0]);
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

        int res = -1;
        if(min1[0] <= min2[0]) {
            res = min1[0];
        } else {
            res = min2[0];
        }

        System.out.println("Min: " + res);

        sc.close();
    }
}
