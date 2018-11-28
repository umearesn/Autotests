package task_2;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MatrixSort {

    public Matrix sortRowsInReverseOrder(Matrix input){
        TreeMap<Integer, Integer> rows = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for(int i = 0; i < input.getHeight(); i++){
            int res = 0;
            for(int j =0; j < input.getWidth(); j++){
                res += input.getElemAtPos(i, j);
            }
            rows.put(res, i);
        }
        Matrix res = new Matrix(input.getHeight(), input.getWidth());
        for(int i = 0; i < input.getHeight(); i++){
            Map.Entry<Integer, Integer> elem = rows.pollFirstEntry();
            for(int j = 0; j < input.getWidth(); j++){
                res.setElemAtPos(i, j, input.getElemAtPos(elem.getValue(), j));
            }
        }
        return res;
    }

}
