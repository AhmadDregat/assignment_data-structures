
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { {1, 4, 5, 6}
		             ,{2, 5, 7, 100}
		             ,{3 ,6 ,12 ,101}
		             ,{6, 100, 200, 201}};

		System.out.println(FreqX(mat, 6));
	
	// NumOfTriplets
	 int[] array = {3,4,1,-2,2,10,1};
	  
	  System.out.println(NumOfTriplets(array, 3));
	 
		
	}
	//�������� ����� ���� ����� ������� ������� �� O(n)
	public static int FreqX(int[][] mat, int x) {
		int c=0;
		int j = mat.length-1;
		int i = 0; 

		while ( i < mat.length && j >= 0 )// ���� ����� ����� ��� 
		{
			if ( mat[i][j] == x )//���� ����� �� X
			{
				c++;	
			}
			if ( mat[i][j] > x )//�� ����  ��� �������� �� ������ 
				j--;
			else //���� ����� 1 ������� if(  mat[i][j] < x )
				i++;
		}
		return c;//���� ���� ������ ���� ��� 

	}
	//////////////////////////////////////////////////////////////
//����
	public static void sort(int[] arr)
	{
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int arr[], int low, int high) 
	{
		int i = low, j = high;
		int temp;
		int pivot = arr[(low + high) / 2];

		while (i <= j) 
		{
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) 
			{
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(arr, low, j);
		if (i < high)
			quickSort(arr, i, high);
	}//��� ����� ����� 

	/** X  �������� ����� ����� ������ ������ �� ��� ����� � 
	 *������� �� O(n^2)
	 *
	 *
	 * 
	 * @param mat������� ����� 
	 * @param  ����� ����� x ����� ����� ���
	 * @return   X ����� ��� ����� �� ����� �� ������ �  
	 */
	public static int NumOfTriplets(int[] mat, int x)
	{
		int l, r ,c=0; // ����� ����� �� ����� ����� ��� ���� 
		sort(mat);//  ���� ���  quickSort
		for (int i=0;i<mat.length-2;i++){
			r= mat.length-1;
			l = i + 1;
			while (r>l)// ���� ����� �� ����� ���� ����� 
			{
				if( mat[i] + mat[l] + mat[r] == x)
				{
					c++;

				}
				if (mat[i] + mat[l] + mat[r] < x)//�� ���� ���� � X
					l++;
				else //(mat[i] + mat[l] + mat[r] > x)
					r--;	}
		}
		return c;
	}

}