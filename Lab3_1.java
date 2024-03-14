public class Lab3_1 {
    public static void main(String[] args) {
        String s = "Hello";
        int length = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            length++;
        }
        System.out.println(length);
    }
}
