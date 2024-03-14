public class Lab5_2 {
    public static void main(String[] args) {
        String str = "Hello My name is Khush";
        String[] strArr = str.split(" ");
        for(int i = 0; i < strArr.length; i++) {
            if(Character.isUpperCase(strArr[i].charAt(0))) {
                System.out.println(strArr[i]);
            }
        }
    }    
}
