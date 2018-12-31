
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
	//הפונקציה מחפשת מספר מסוים במטריצה בסבכיות של O(n)
	public static int FreqX(int[][] mat, int x) {
		int c=0;
		int j = mat.length-1;
		int i = 0; 

		while ( i < mat.length && j >= 0 )// תנאי עצירה לולאה אחד 
		{
			if ( mat[i][j] == x )//תנאי למצוא את X
			{
				c++;	
			}
			if ( mat[i][j] > x )//אם נתון  קטן מהאינדקס של מטריצה 
				j--;
			else //אחרת יוסיף 1 לעמודות if(  mat[i][j] < x )
				i++;
		}
		return c;//חזרת מספר הפעמים שהוא מצא 

	}
	//////////////////////////////////////////////////////////////
//מיון
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
	}//סוף המיון המהיר 

	/** X  הפונקציה מחפשת חיבור שלישיה מספרים כך שהם שווים ל 
	 *בסבכיות של O(n^2)
	 *
	 *
	 * 
	 * @param matפונקציה מקבלת 
	 * @param  מופיע במערך x צריכה למצוא כמה
	 * @return   X תחזיר כמה פעמים יש בסכמה של שלישיה ה  
	 */
	public static int NumOfTriplets(int[] mat, int x)
	{
		int l, r ,c=0; // הגדרת מצביע על התחלה והסוף וגם מונה 
		sort(mat);//  מיון לפי  quickSort
		for (int i=0;i<mat.length-2;i++){
			r= mat.length-1;
			l = i + 1;
			while (r>l)// תנאי עצירה אם התחלה גדול מהסוף 
			{
				if( mat[i] + mat[l] + mat[r] == x)
				{
					c++;

				}
				if (mat[i] + mat[l] + mat[r] < x)//אם איבר גדול מ X
					l++;
				else //(mat[i] + mat[l] + mat[r] > x)
					r--;	}
		}
		return c;
	}

}