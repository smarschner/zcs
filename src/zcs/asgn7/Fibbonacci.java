package zcs.asgn7;

public class Fibbonacci {
	public static int F(int n){
		if(n==1 || n==0){
			return 1;
		}else{
			return(F(n-1) + F(n-2));
		}
	}
}
