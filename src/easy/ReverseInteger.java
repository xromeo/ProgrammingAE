package easy;

public class ReverseInteger {

    public static void reverse(int v){

        int r = 0;
        
        while(v != 0){
            int d = v % 10;
            r = r * 10 + d;
            v = v / 10;
        }
        System.out.println(r);
    }

    public static void main(String[] args) {
        reverse(-25);
        reverse(0);
    }
    
}
