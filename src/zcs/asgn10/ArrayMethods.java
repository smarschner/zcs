package zcs.asgn10;

public class ArrayMethods {
	public static void swap(int[] b, int i, int j){
		int x= b[i];
		int z= b[j];
		b[i]= z;
		b[j]= x;
	}
	
	public static void pushFront(int[] b, int a){
		for(int x= b.length-2; x>=0; x--){
			b[x+1]=  b[x];
		}
		b[0]= a;
	}
	
	public static int sum(int[] b){
		int sum= 0;
		for(int x= b.length-1; x>=0; x--){
			sum+=b[x];
		}
		return sum;
	}
	
	public static String join(String[] b, String separator){
		String sum= "";
		for(int x= b.length-1; x>=0; x--){
			sum+=b[x];
			if(x!=0){
				sum+=separator;
			}
		}
		return sum;
	}
	
	public static int fromDigits(int[] b){
		int sum= 0;
		for(int x= 0; x<b.length; x++){
			sum*=10;
			sum+=b[x];
		}
		return sum;
	}
	
	public static int[] toDigits(int n){
		int digits= 0;
		int n1= n;
		for(int x= 0; n1>0; x++){
			digits+=1;
			n1/=10;
		}
		int[] x= new int[digits];
		
		int n2= n;
		for(int y= 0; n2>0; y++){
			x[(digits-1)-y]= n2%10;
			n2/=10;
		}
		return x;
	}
	
	public static int[] remove(int[] b, int i){
		int[] x= new int[b.length-1];
		for(int y= 0; y<b.length; y++){
			if(y<i){x[y]= b[y];}
			if(y>i){x[y-1]= b[y];}
		}
		return x;
	}
	
	public static int[] subArray(int[] b, int h, int k){
		int[]x= new int[k-h];
		for(int y= h; y<k; y++){
			x[y-h]= b[y];
		}
		return x;
	}
	
	public static int[] reverseCopy(int[] b){
		int[]x= new int[b.length];
		for(int y= 0; y<b.length; y++){
			x[b.length-y-1]= b[y];
		}
		return x;
	}

	//for this one, i first tried just 
		//b= reverseCopy(b);
	//but for some reason, that worked when i set it to return int[] and returned b and put
	//that into an assert equals in a test case, but when i just used the testcase i have
	//now it didn't work...
	public static void reverse(int[] b){
		int[] x= reverseCopy(b);
		for(int y= 0; y<b.length; y++){
			b[y]=x[y];
		}

	}
	
	public static int[] shuffle(int[] a, int[] b){
		int[]x= new int[a.length+b.length];
		for(int y= 0; y<x.length; y+=2){
			x[y]=a[y/2];
		}
		for(int y= 0; y<x.length; y+=2){
			x[y+1]=a[y/2];
		}
		return x;
	}
	
	public static int find(int[] b, int x){
		for(int y= 0; y<b.length; y++){
			if(b[y]==x){return y;}
		}
		return -1;
	}
	
	public static int findSmallest(int[] b){
		int small=b[0];
		for(int y= 0; y<b.length; y++){
			if(b[y]<small){
				small= b[y];
			}
		}
		return small;
	}
	
	public static int findSmallest(int[] b, int h, int k){
		int x[]= subArray(b, h, k);
		return findSmallest(x);
		
	}
	
	public static void smallestUpFront(int[] b){
		int small= find(b, findSmallest(b));
		int hold= b[0];
		b[0]= b[small];
		b[small]= hold;
	}
	
	public static void smallestUpFront(int[] b, int h, int k){
		int[] x= subArray(b, h, k);
		smallestUpFront(x);
		for(int y=0; y<b.length; y++){
			if(y>=h&&y<k){b[y]= x[y-h];}
		}
	}
	
	public static void selectionSort(int[] b){
		for(int x=0; x<b.length; x++){
			smallestUpFront(b, x, b.length);
		}
	}
	
	public static int[] merge(int[] a, int[] b){
		int[] x= new int[a.length+b.length];
		int aa= 0, bb= 0;
		while(aa<a.length&&bb<b.length){
			if(a[aa]<=b[bb]){
				x[aa+bb]= a[aa];
				aa++;
			}else{
				x[aa+bb]= b[bb];
				bb++;
			}
		}
		while(bb<b.length){
			x[aa+bb]= b[bb];
			bb++;
		}
		while(aa<a.length){
			x[aa+bb]= a[aa];
			aa++;
		}
		return x;
		
	}
	
	public static int[] mergeSort(int[] a){
		int[] b= new int [a.length/2];
		for(int x= 0; x<b.length; x++){b[x]= a[x];}
		int[] c= new int [a.length-b.length];
		for(int x= 0; x<c.length; x++){c[x]= a[x+b.length];}
		selectionSort(b);
		selectionSort(c);
		return merge(b, c);
	}
	
	public static void partitionValue(int[] b, int x){
		int[] a= new int[b.length];
		int beg= 0;
		int end= b.length-1;
		for(int y= 0; y<b.length; y++){
			if(b[y]<x){
				a[beg]= b[y];
				beg++;
			}else{
				a[end]= b[y];
				end--;
			}
		}
		for(int y= 0; y<b.length; y++){b[y]= a[y];}
	}
	
	public static void partitionIndex(int[] b, int i){
		partitionValue(b, b[i]);
	}
	
	public static void partitionIndex(int[] b, int i, int h, int k){
		int[] s= subArray(b, h, k);
		partitionValue(s, b[i]);
		for(int y= 0; y<b.length; y++){
			if(y>=h&&y<k){b[y]= s[y-h];}
		}
	}
	
	public static void quickSort(int[] b){
		int x= b[0];
		int z= 0;
		partitionIndex(b, 0);
		for(int y= 0; y<b.length; y++){if(b[y]==x){z= y;}}
		int[] l= new int[z+1];
		int[] r= new int[b.length-z];

	}


}
