package zcs.asgn10;

public class ArrayMethodsTimeTest {
	public static int[] randomArray(int length){
		int[] array= new int[length];
		for(int y= 0; y<array.length; y++){
			array[y]= (int) Math.round(Math.random()*10);
		}
		return array;
	}
	
	//1= selection sort
	//2= merge sort
	//3= quick sort
	//4= old sort
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
		if(method==4){
			long beg= System.nanoTime();
			ArrayMethods.oldSort(randomArray(num));
			long end= System.nanoTime();
			return end-beg;
		}
		return 0;
	}
	
	public static void main(String[] args){
		  System.out.println("length\tselectionSort()\tmergeSort()\tquickSort()\toldSort()");
	        for (int i = 1; i <= 10; i++) {
	            int n = 10000 * i;
	            System.out.print(n);
	            for (int alg = 2; alg <= 4; alg++) {
	                double time = time(alg, n);
	                double seconds= time/1000000000;
	                System.out.print("\t" + seconds);
	            }
	            System.out.println();
	        }
	}
}
	
