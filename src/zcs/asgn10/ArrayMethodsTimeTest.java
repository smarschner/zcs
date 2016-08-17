package zcs.asgn10;

public class ArrayMethodsTimeTest {
	public static int[] randomArray(int length){
		int[] array= new int[length];
		for(int y= 0; y<array.length; y++){
			array[y]= (int) Math.round(Math.random()*100);
		}
		return array;
	}
	
	//1= selection sort
	//2= merge sort
	//3= quick sort
	public static long time(int method, int num){
		if(method==1){
			long beg= System.nanoTime();
			ArrayMethods.selectionSort(randomArray(num));
			long end= System.nanoTime();
			return end-beg;
		}
		if(method==2){
			long beg= System.nanoTime();
			ArrayMethods.mergeSort(randomArray(num));
			long end= System.nanoTime();
			return end-beg;
		}
		if(method==3){
			long beg= System.nanoTime();
			ArrayMethods.quickSort(randomArray(num));
			long end= System.nanoTime();
			return end-beg;
		}
		return 0;
	}
	
	public static void main(String[] args){
		System.out.println(time(2, 100000));
	}
}
	
