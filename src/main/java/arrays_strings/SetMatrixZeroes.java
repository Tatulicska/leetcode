package arrays_strings;

//Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
public class SetMatrixZeroes {
  public static void main(String[] args) {

	int[][] matr = {{1, 1, 1}
		, {1, 0, 1}
		, {1, 1, 1}};

	int[][] matr2 =
		{{0, 1, 2, 0},
			{3, 4, 5, 2},
			{1, 3, 1, 5}};
	fillUpWIthZeroes(matr2);
  }

  private static void fillUpWIthZeroes(int[][] matrix) {
	int n = matrix.length;
	int m = matrix[0].length;
	int[] rows = new int[n];
	int[] cols = new int[m];
	for (int i = 0; i < n; i++) {
	  for (int j = 0; j < m; j++) {
		if (matrix[i][j] == 0) {
		  rows[i] = 1;
		  cols[j] = 1;
		}
	  }
	}
	for (int i = 0; i < n; i++) {
	  for (int j = 0; j < m; j++) {
		if (rows[i] == 1 || cols[j] == 1) {
		  matrix[i][j] = 0;
		}
	  }
	}
	System.out.println();
  }
}
