package lab2_v2.matrix;
import lab2_v2.ring.*;

public class Matrix<T> {
    private Ring<T> ring;
    private T[][] data;

    public Matrix(Ring<T> ring, int rows, int cols) {
        this.ring = ring;
        this.data = (T[][]) new Object[rows][cols];
    }

    public void set(int row, int col, T value) {
        data[row][col] = value;
    }

    public T get(int row, int col) {
        return data[row][col];
    }

    public Matrix<T> add(Matrix<T> other) {
        if (data.length != other.data.length || data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        Matrix<T> result = new Matrix<>(ring, data.length, data[0].length);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.data[i][j] = ring.add(data[i][j], other.data[i][j]); // Исправлено
            }
        }

        return result;
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        Matrix<T> result = new Matrix<>(ring, data.length, other.data[0].length);

        for (int i = 0; i < result.data.length; i++) {
            for (int j = 0; j < result.data[0].length; j++) {
                T sum = ring.getZero();
                for (int k = 0; k < data[0].length; k++) {
                    sum = ring.add(sum, ring.multiply(data[i][k], other.data[k][j]));
                }
                result.data[i][j] = sum;
            }
        }

        return result;
    }


    public void printMatrix() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setSubmatrix(int startRow, int startCol, Matrix<T> submatrix) {
        for (int i = 0; i < submatrix.data.length; i++) {
            for (int j = 0; j < submatrix.data[0].length; j++) {
                data[startRow + i][startCol + j] = submatrix.data[i][j];
            }
        }
    }
}
