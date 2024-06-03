import java.util.ArrayList;

public class Lab11 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 50; i++) {
            list.add(i);
        }

        final int[] sum1 = {0};
        final int[] sum2 = {0};
        for(int i = 30; i < 50; i++) {
            System.out.println(list.get(i));
            sum1[0] += list.get(i);
        }

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 15; i++) {
                System.out.println("Thread 1: " + list.get(i));
                sum1[0] += list.get(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 15; i < 30; i++) {
                System.out.println("Thread 2: " + list.get(i));
                sum2[0] += list.get(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Sum of Thread 1: " + sum1[0]);
            System.out.println("Sum of Thread 2: " + sum2[0]);
            System.out.println("Total sum: " + (sum1[0] + sum2[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
