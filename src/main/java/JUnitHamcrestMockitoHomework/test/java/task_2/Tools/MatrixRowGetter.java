package task_2.Tools;

import task_2.Matrix;

public class MatrixRowGetter {

    public Integer[] getRowAsArray(int rowNumber, Matrix input){
        Integer[] result = new Integer[input.getWidth()];
        for(int i = 0; i < input.getWidth(); i++){
            result[i] = input.getElemAtPos(rowNumber, i);
        }
        return result;
    }

}
