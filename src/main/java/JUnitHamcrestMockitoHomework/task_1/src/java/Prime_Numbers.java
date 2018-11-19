import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class Prime_Numbers {

    private static void filterNumbers(int n){
            ArrayList<Boolean> isNumberDeleted = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                isNumberDeleted.add(i, false);
            }

                for (int i = 2; i <= n; i++) {
                    if (!isNumberDeleted.get(i)) {
                        for (int j = i * i; j <= n && i <= sqrt(n); j += i) {
                                isNumberDeleted.set(j, true);
                        }
                    }
                }
            for(int i = 2; i <= n; i++){
                if(!isNumberDeleted.get(i)){
                    System.out.printf("%d ", i);
                }
            }
    }

    public static void main(String[] args) {
        System.out.printf("%s\n", "Please, enter the upper bound of numbers:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        filterNumbers(n);
    }

}
