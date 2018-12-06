package task_2;

import javafx.util.Pair;
import java.util.ArrayList;

public class MatrixSort {

    public Matrix sortRowsInReverseOrder(Matrix input){
         try {
             ArrayList<Pair<Integer, Integer>> newOrderOfRows = new ArrayList<>();
             for (int i = 0; i < input.getHeight(); i++) {
                 int res = 0;
                 for (int j = 0; j < input.getWidth(); j++) {
                     res += input.getElemAtPos(i, j);
                 }
                 int j = 0;
                 while (j < newOrderOfRows.size() && res <= newOrderOfRows.get(j).getValue()) {
                     j++;
                 }
                 newOrderOfRows.add(j, new Pair<>(i, res));
             }
             Matrix result = new Matrix(input.getHeight(), input.getWidth());
             for (int i = 0; i < result.getHeight(); i++) {
                 for (int j = 0; j < result.getWidth(); j++) {
                     result.setElemAtPos(i, j, input.getElemAtPos(newOrderOfRows.get(i).getKey(), j));
                 }
             }
             return result;
         } catch (NullPointerException error) {
             return null;
         }
    }

}
