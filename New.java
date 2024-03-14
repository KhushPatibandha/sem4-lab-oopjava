public class New {
    int a, b;
    int sum(int a, int b) {
        return a + b;
    }
    int sum() {
        return a + b;
    }
    public static void main(String[] args) {
        New objNew = new New();
        objNew.a = 1;
        objNew.b = 1;

        // System.out.println(objNew.sum(objNew.a, objNew.b));
        System.out.println(objNew.sum());
    }
}
