import java.util.Arrays;

public class Ex2 {
	public static void main(String[] args) {
		int a[] = {1,1,15,4,1,8,1,3};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void sort(int[] a) {
		int [] ans =new int [a.length];
		int currentmin =Integer.MAX_VALUE,perviesMIN ,c=0,index=0, x=0;
		for (int i = 0; i < a.length; i++) 
			if(a[i]< currentmin) {
				currentmin=a[i];
				c=1;
			}
			else if (a[i] == currentmin) 
				c++;
		perviesMIN=currentmin;

		while (c > 0 && currentmin!=Integer.MAX_VALUE) {
			for (int i = 0; index < ans.length&& i<c; i++) 
				ans [index++]=currentmin;
			c=0;
			currentmin=Integer.MAX_VALUE;
			//x++	;


		for (int i = 0; i < a.length; i++) {
				if( a[i] == perviesMIN)
					a[i]=Integer.MIN_VALUE  ;
				else 
				{
					if (a[i]<currentmin && a[i]!=Integer.MIN_VALUE) {
						currentmin=a[i];
						c=1;
					}
					else if(a[i] == currentmin && a[i]!=Integer.MIN_VALUE)
						c++;
				} 
		}
			perviesMIN = currentmin;
		}
		for (int i = 0; i < ans.length; i++) {
			a[i]=ans[i];	
		}
		System.out.println(x);

	}
}
