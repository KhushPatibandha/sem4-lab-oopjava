public class Sum {
    static int sum = 0;
    private static int sumFunc(int... numbers) {
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumFunc(1, 2, 3, 4, 5));
    }
}