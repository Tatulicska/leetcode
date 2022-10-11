package arrays_strings;

public class RotateMatrix {

  //  Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
//  write a method to rotate the image by 90 degrees. Can you do this in place?
  public static void main(String[] args) {
	int[][] matr = {{1,2,3}
					,{4,5,6}
					,{7,8,9}};
	rotate(matr);
	System.out.println(matr);
  }

  public static void rotate(int[][] matrix) {
	int n = matrix.length;
	for (int i=0; i< n; i++){
	  for(int j=i; j<n ;j++){            //1,4,7
		int temp =  matrix[i][j];       //2,5,8
		matrix[i][j]=matrix[j][i];      //3,6,9
		matrix[j][i]=temp;//transpose matrix, turn raws to columns
	  }
	}
//now swap columns
	for(int i=0;i<n;i++){
	  for(int j=0;j<n/2;j++){ //go until middle because middle col remains same
			int temp = matrix[i][j];         ///    7 4 1
			matrix[i][j]=matrix[i][n-1-j];   ///    8 5 2
			matrix[i][n-1-j]=temp;           ///    9 6 3
	  }
	}
	System.out.println();
  }
}
