package zcs.asgn10;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

public class ArrayMethodsTest {

	@Test
	public void test() {
		int[] a= new int[] {3, 5, 9, 1, 3};
		ArrayMethods.swap(a, 1, 3);
		assertEquals(a[1], 1);
		assertEquals(a[3], 5);
		
		int [] b= new int[] {3, 5, 9, 1, 3};
		ArrayMethods.pushFront(b, 1);
		int [] c= new int[] {1, 3, 5, 9, 1};
		assertArrayEquals(c, b);
		
		int [] d= new int[] {1, 3, 5, 9, 1};
		assertEquals(ArrayMethods.sum(d), 19);

		String [] e= new String[] {"hi", "hi", "hi"};
		assertEquals(ArrayMethods.join(e, ", "), "hi, hi, hi");
		
		int [] f= new int[] {1, 3, 5, 9, 1};
		assertEquals(ArrayMethods.fromDigits(f), 13591);
		
		int [] g= new int[] {5, 3, 1};
		assertArrayEquals(ArrayMethods.toDigits(531), g);
		
		int [] h= new int[] {3, 5, 9, 1, 3};
		int [] i= new int[] {3, 9, 1, 3};
		assertArrayEquals(ArrayMethods.remove(h, 1), i);
		
		int [] j= new int[] {3, 5, 9, 1, 3};
		int [] k= new int[] {5, 9, 1};
		assertArrayEquals(ArrayMethods.subArray(j, 1, 4), k);
		
		int [] l= new int[] {3, 5, 9, 1, 3};
		int [] m= new int[] {3, 1, 9, 5, 3};
		assertArrayEquals(ArrayMethods.reverseCopy(l), m);
		
		int [] n= new int[] {3, 5, 9, 1, 3};	
		ArrayMethods.reverse(n);
		int [] o= new int[] {3, 1, 9, 5, 3};
		assertArrayEquals(o, n);
		
		int [] p= new int[] {1, 2, 3};
		int [] q= new int[] {1, 2, 3};
		int [] r= new int[] {1, 1, 2, 2, 3, 3};
		assertArrayEquals(ArrayMethods.shuffle(p, q), r);
		
		int [] s= new int[] {1, 3, 5, 9, 1};
		assertEquals(ArrayMethods.find(s, 9), 3);
		
		int [] t= new int[] {7, 3, 5, 9, 1};
		assertEquals(ArrayMethods.findSmallest(t), 1);
		int [] u= new int[] {7, 1, 5, 9, 1};
		assertEquals(ArrayMethods.findSmallest(u), 1);
		
		int [] v= new int[] {7, 2, 5, 9, 1};
		assertEquals(ArrayMethods.findSmallest(v, 1, 4), 2);
		
		int [] w= new int[] {3, 5, 9, 1, 3};	
		ArrayMethods.smallestUpFront(w);
		int [] x= new int[] {1, 5, 9, 3, 3};
		assertArrayEquals(w, x);
		
		int [] y= new int[] {3, 5, 9, 1, 3};	
		ArrayMethods.smallestUpFront(y, 1, 4);
		int [] z= new int[] {3, 1, 9, 5, 3};
		assertArrayEquals(y, z);
		
		int [] aa= new int[] {3, 5, 9, 1, 3};	
		ArrayMethods.selectionSort(aa);
		int [] bb= new int[] {1, 3, 3, 5, 9};
		assertArrayEquals(aa, bb);
		
		int [] cc= new int[] {1, 2, 3};
		int [] dd= new int[] {2, 4, 5};
		int [] ee= new int[] {1, 2, 2, 3, 4, 5};
		assertArrayEquals(ArrayMethods.merge(cc, dd), ee);
		
		int [] ff= new int[] {2, 4, 1, 5, 2, 3};
		int [] gg= new int[] {1, 2, 2, 3, 4, 5};
		assertArrayEquals(ArrayMethods.mergeSort(ff), gg);
		
		int [] hh= new int[] {3, 5, 9, 1, 3};	
		ArrayMethods.partitionValue(hh, 4);
		int [] ii= new int[] {3, 1, 3, 9, 5};
		assertArrayEquals(hh, ii);		
		
//		int [] jj= new int[] {3, 5, 9, 1, 3};	
//		ArrayMethods.partitionIndex(jj, 0);
//		for(int ë : jj){System.out.print(ë);}
		
//		int [] kk= new int[] {3, 5, 9, 1, 3, 6, 8, 9, 2, 5, 6, 6, 7, 4, 2, 1};	
//		ArrayMethods.partitionIndex(kk, 0, 3, 7);
//		for(int ll : kk){System.out.print(ll);}
		
		int [] mm= new int[] {5, 1, 3, 2, 8, 6, 5, 2, 4, 7, 9, 0, 2, 4, 7, 1, 8, 1};	
		ArrayMethods.quickSort(mm);
		for(int ë : mm){System.out.print(ë);}

	}

}
