

public class Ex1_2 {




public static int [][]GetMatPeak(int [][] Mat)
{  
	int low = Mat.length / 2;
	int high = Mat[low].length / 2;

	return getMatrixPeakRecursive(Mat, low, high);
}

private static int [][]getMatrixPeakRecursive(int[][] matrix, int low, int high) {
    int[][] res= {{-1,-1}};
	if (low <matrix.length -1 && matrix[low][high] < matrix[low + 1][high]) {
		return getMatrixPeakRecursive(matrix, low + 1, high);
	} 
	else if ( matrix[low][high] < matrix[low - 1][high]) {

		return getMatrixPeakRecursive(matrix, low , high);

	} 
	else if (high < matrix[low].length - 1 && matrix[low][high] < matrix[low][high + 1]) {
		return getMatrixPeakRecursive(matrix, low, high + 1);
	} 
	else if (high >0 && matrix[low][high] < matrix[low][high - 1]) {
		return getMatrixPeakRecursive(matrix, low, high - 1);
	} 
	else {
		
		res[0][0] = high;// O(1).
		res[0][1] = low;// O(1).

		return  res;

	}
}

}







