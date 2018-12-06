package task_2;

public class Main {

    public static void initMatrix(Matrix input){
        CorrectInput reader = new CorrectInput();
        for(int i = 0; i < input.getHeight(); i++) {
            System.out.printf("\n%s%d%s\n", "Enter elements of the ", i, " row:");
            for( int j = 0; j < input.getWidth(); j++){
                System.out.printf("%s%d;%d%s", "Enter the element at the position (", i, j, "): ");;
                input.setElemAtPos(i, j, reader.correctInput());
            }
        }
    }

    public static void printMatrix(Matrix output){
        for(int i = 0; i < output.getHeight(); i++) {
            for( int j = 0; j < output.getWidth(); j++){
                System.out.printf("%d ", output.getElemAtPos(i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CorrectInput reader = new CorrectInput();
        System.out.println("Please, enter the height of the matrix:");
        int height = reader.correctInput();
        System.out.println("Please, enter the width of the matrix:");
        int width = reader.correctInput();
        Matrix table = new Matrix(height, width);
        initMatrix(table);
        MatrixSort sorter = new MatrixSort();
        printMatrix(sorter.sortRowsInReverseOrder(table));
    }

}
