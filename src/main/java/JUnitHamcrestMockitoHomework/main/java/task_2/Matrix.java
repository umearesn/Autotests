package task_2;

public class Matrix {
    private int width = 0, height = 0;
    private int matrix[][];

    Matrix(){
        this.height = 0;
        this.width = 0;
        this.matrix = null;
    }

    Matrix(int height, int width){
        this.height = height;
        this.width = width;
        this.matrix = new int[height][width];
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }

    public int getElemAtPos(int i, int j){
        return this.matrix[i][j];
    }

    public void setElemAtPos(int i, int j, int value){
        this.matrix[i][j] = value;
    }
}
