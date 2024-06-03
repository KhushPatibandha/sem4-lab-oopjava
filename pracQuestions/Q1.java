package pracQuestions;

import java.util.ArrayList;
import java.util.Scanner;

// Question: Do sum, multiplication, etc in parallel for number in a list.

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("How many numbers you want to enter?");
        int n = sc.nextInt();

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter 1 to add or 2 to multiply the numbers: ");
        int choice = sc.nextInt();

        int result = 0;
        if(choice == 1) {
            result = add(list);
        } else if(choice == 2) {
            result = mul(list);
        }

        System.out.println(result);

        sc.close();
    }

    public static int add(ArrayList<Integer> list) {
        final int[] sum1 = {0};
        final int[] sum2 = {0};
        
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < list.size() / 2; i++) {
                sum1[0] += list.get(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = list.size() / 2; i < list.size(); i++) {
                sum2[0] += list.get(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sum1[0] + sum2[0];
    }

    public static int mul(ArrayList<Integer> list) {
        final int[] mul1 = {1};
        final int[] mul2 = {1};
        
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < list.size() / 2; i++) {
                mul1[0] *= list.get(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = list.size() / 2; i < list.size(); i++) {
                mul2[0] *= list.get(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mul1[0] * mul2[0];
    }
}
