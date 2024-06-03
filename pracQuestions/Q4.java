package pracQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// Find maximum number from the list.

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("How many numbers you want to enter?");
        int n = sc.nextInt();

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        final int[] max1 = {Integer.MIN_VALUE};
        final int[] max2 = {Integer.MIN_VALUE};
        int maxMain = Integer.MIN_VALUE;

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < list.size() / 3; i++) {
                System.out.println("Thread 1 currently dealing with " + list.get(i) + " while the max for this thread is "+ max1[0]);
                if(list.get(i) > max1[0]) {
                    max1[0] = list.get(i);
                    System.out.println("Updated max value in thread 1: " + max1[0]);
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            for(int i = list.size() / 3; i < 2 * list.size() / 3; i++) {
                System.out.println("Thread 2 currently dealing with " + list.get(i) + " while the max for this thread is "+ max2[0]);
                if(list.get(i) > max2[0]) {
                    max2[0] = list.get(i);
                    System.out.println("Updated max value in thread 2: " + max2[0]);
                }
            }
        });

        t1.start();
        t2.start();

        for(int i = 2 * list.size() / 3; i < list.size(); i++) {
            System.out.println("main Thread currently dealing with " + list.get(i) + " while the max for this main thread is "+ maxMain);
            if(list.get(i) > maxMain) {
                maxMain = list.get(i);
                System.out.println("Updated max value in thread main: " + maxMain);
            }
        }

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int res = -1;
        if(max1[0] >= max2[0] && max1[0] >= maxMain) {
            res = max1[0];
        } else if(max2[0] >= max1[0] && max2[0] >= maxMain) {
            res = max2[0];
        } else {
            res = maxMain;
        }

        System.out.println("Max: " + res);

        sc.close();
    }
}
