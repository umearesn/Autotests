package task_12;

import java.lang.String;
import java.lang.Integer;

public class EncodingByROT1 implements Encoding{
    private char nextLetter(char old){
        if((('a' <= old) && (old < 'z')) || (('A' <= old) && (old < 'Z'))){
            return (char)((int)old + 1);
        } else {
            switch(old) {
                case 'z':
                    return 'a';
                case 'Z':
                    return 'A';
                default:
                    return old;
            }
        }
    }

    private char previousLetter(char old){
        if((('a' < old) && (old <= 'z')) || (('A' < old) && (old <= 'Z'))){
            return (char)((int)old - 1);
        } else {
            switch(old) {
                case 'a':
                    return 'z';
                case 'A':
                    return 'Z';
                default:
                    return old;
            }
        }
    }

    public String encode(String str){
        StringBuilder result = new StringBuilder(str);
        for(int i = 0; i < str.length(); i++) {
            result.setCharAt(i, nextLetter(str.charAt(i)));
        }
        return result.reverse().toString();
    }

    public String decode(String str){
        StringBuilder result = new StringBuilder(str);
        for(int i = 0; i < str.length(); i++) {
            result.setCharAt(i, previousLetter(str.charAt(i)));
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "I know what you did last summer z Zz zZ Z AaaAAa";
        EncodingByROT1 enc = new EncodingByROT1();
        str = enc.encode(str);
        System.out.println(str);
        System.out.println(enc.decode(str));
    }
}
