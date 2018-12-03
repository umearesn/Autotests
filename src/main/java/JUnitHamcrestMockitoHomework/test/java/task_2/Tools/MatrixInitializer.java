package task_2.Tools;

import task_2.Matrix;

public class MatrixInitializer {

    public Matrix givenValuesMatrixInit(int height, int width, Integer[] inputValues){
        Matrix result = new Matrix(height, width);
        if(height * width != inputValues.length){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < inputValues.length; i++) {
            result.setElemAtPos(i / width, i % width, inputValues[i]);
        }
        return result;
    }

}
