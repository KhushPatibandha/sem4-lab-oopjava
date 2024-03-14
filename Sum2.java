public class Sum2 {
    public static int fundSum(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        InnerSum2 sum = new InnerSum2();
        System.out.println(sum.sum = fundSum(1, 2));
    }
}

class InnerSum2 {
    int sum;
}