package zcs.asgn8;

/**
 * These are the same methods as in the recursion lab -- so you can use the same 
 * test cases.  But this time, write them using loops instead of recursion.
 */

public class Iter {
    /** = number of times c occurs in s. */
    public static int numberc(char c, String s) {
        int ch= 0;
    	for(int n=s.length()-1; n!=-1; n--){
        	if(s.charAt(n)==c){ch++;}
        }
        return ch;
    }
    
    /** = number of chars in s that are not c. */
    public static int numberNotc(char c, String s) {
        return s.length()-numberc(c, s);
    }

    /** = a copy of s but with all occurrences of c replaced by d. 
          Example: replace("abeabe", 'e', '$') = "ab$ab$".
          For lab purposes, do NOT use the pre-existing String function replace */
    public static String replace(String s, char c, char d) {
        String sum= "";
    	for(int n=0; n!=s.length(); n++){
        	if(s.charAt(n)==c){sum+=d;}
        	else{sum+=s.charAt(n);}
        }
    	return sum;
    }
    
    /** = a copy of s with adjacent duplicates removed.
          Example: for s = "abbcccdeaaa", the answer is "abcdea".*/
    public static String rem1(String s) {
        String sum= "" + s.charAt(0);
        int n= 1;
    	while(n!=s.length()){
        	if(s.charAt(n)==s.charAt(n-1)){
        		n++;
        	}else{
        		sum+=s.charAt(n);
        		n++;
        	}
        }
    	return sum;
     }
    
    /** = a copy of s but with the FIRST occurrence of c removed (if present).
          Note: This can be done easily using indexOf. Don't do that.
          Do it using a String accumulator.*/
    public static String removeFirst(String s, char c) {
    	String sum= "" + s.charAt(0);
        int n= 1;
        boolean removed= false;
    	while(n!=s.length()){
        	if((s.charAt(n)==s.charAt(n-1))&&(removed==false)){
        		removed= true;
        		n++;
        		}
        	else{
        		sum+=s.charAt(n);
        		n++;
        	}
        }
    	return sum;    }

    /** = the reverse of s. e.g. rev("abc") is "cba". */
    public static String rev1(String s) {
        String sum= "";
    	for(int n=s.length()-1; n!=-1; n--){
    		sum+=s.charAt(n);
        }
    	return sum;
    }
    
   /** = the sum of the integers in s.
         Precondition: s contains at least one integer and
         has the form <integer>:<integer>:...:<integer>,
         and all the integers are positive (no - signs).
         Note that s contains no blanks 
         e.g. sumInts("34") = 34.
         e.g. sumInts("7:34:1:2:2") is 46. */
    public static int sumInts(String s) {
        int sum= 0;
        int last= 0;
        s= s + ':';
        for(int n=0; n!=s.length(); n++){
        	if(s.charAt(n)==':'){
        		sum+=(Integer.parseInt(s.substring(last, n)));
        		last= n+1;
        	}
        }
        return sum;
    }
    
    /** = n!, which is defined by
          0! = 1
          n! = n * (n-1)!  for n > 0
          Example: !5 = 5*4*3*2*1
          Precondition: n >= 0 */
    public static int fact(int n) {
        int sum= 1;
    	for(; n>0; n--){
        	sum *= n;
        }
    	return sum;
    }

     /** = number of the digits in the decimal representation of n.
      e.g. numDigits(0) = 1, numDigits(3) = 1, numDigits(34) = 2. 
           numDigits(1356) = 4.
      Precondition: n >= 0. */
    public static int numDigits(int n) {
        int d= 0;
        if(n==0){return 1;};
        for(; n>0; n=(n/10)){
        	d++;
        }
        return d;
    }
   
    /** = sum of the digits in the decimal representation of n.
      e.g. sumDigits(0) = 0, sumDigits(3) = 3, sumDigits(34) = 7,
      sumDigits(345) = 12.
      Precondition: n >= 0. */
    public static int sumDigits(int n) {
       int sum= 0;
       for(; n>0; n=(n/10)){
    	   sum += n%10;
       }
       return sum;
    }
    
    /** = the number of 2's in the decimal representation of n.
      e.g. number2(0) = 0, number2(2) = 1, number2(234252) = 3.
      Precondition: n >= 0. */
    public static int number2(int n) {
    	 int two= 0;
         for(; n>0; n=(n/10)){
      	   if(n%10==2){two += 1;}
         }
         return two;
    }
    
    /** = The number of times that c divides n,
          e.g. into(5,3) = 0 because 3 does not divide 5.
          e.g. into(3*3*3*3*7,3) = 4.
          Precondition: n >= 1 and c > 1 */
    public static int into(int n, int c) {
        int x= 0;
    	for(; n%c==0; n/=c){
        	x+=1;
        }
    	return x;
    }  
    
    /** = Fibonnaci number F(n).
      Precondition: n >= 0.
      Definition: F(0) = 0,
                  F(1) = 1, and
                  F(n) = F(n-1) + F(n-2) for n > 1.
      E.g. the first 10 Fibonnaci numbers are
           0, 1, 1, 2, 3, 5, 8, 13, 21, 34. */
    public static int Fib(int n) {
        int num= 0;
        int lastnum= 1;
        for(int x= 0; x!=n; x++){
        	int hold= num+lastnum;
        	lastnum= num;
        	num= hold;
        }
        return num;
    }
    
    
    /** = b ** c, i.e. b multiplied by itself c times.
      Also called b "to the power" c.
      Precondition: c >= 0
      Hint: You can do this the simple way, and b**c will take c-1 multiplications.
      Can you find a way to do it where, e.g., b**8 only takes 3 multiplications? */
    public static int exp(int b, int c) {
        int sum= 1;
    	while(c!=0){
        	if (c%2==0){
            	b*=b;
            	c/=2;
            }else{
            	sum*= b;
            	c--;
            }
        }
    	return sum;
    }

}
