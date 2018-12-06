package task_1;

import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StrictMath.sqrt;

public class PrimeNumbers {

    public Integer[] filterNumbers(Integer n){
        try {
            ArrayList<Integer> allNumbers = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                allNumbers.add(i);
            }
            for (int i = 2; i <= n; i++) {
                for (int j = i * i; j <= n && i <= sqrt(n); j += i) {
                    allNumbers.remove(new Integer(j));
                }
            }
            Integer[] res = new Integer[allNumbers.size()];
            for (int i = 0; i < allNumbers.size(); i++) {
                res[i] = allNumbers.get(i);
            }
            return res;
        } catch (NullPointerException error) {
            return null;
        }
    }

}
