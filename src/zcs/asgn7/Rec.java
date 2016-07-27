package zcs.asgn7;

/** Lab 06. Writing recursive methods */
public class Rec {
    /** = number of times c occurs in s. */
    public static int numberc(char c, String s) {
	    if(s.length()==0){
	    	return 0;
	    }else{
    		if(s.charAt(0)==(c)){
	        	return 1 + numberc(c, s.substring(1));
	        }else{
	        	return 0+numberc(c,s.substring(1));
	        }
	    }
    }
    
    /** = number of chars in s that are not c. */
    public static int numberNotc(char c, String s) {
        return s.length()-numberc(c, s);
    }

    /** = a copy of s but with all occurrences of c replaced by d. 
          Example: replace("abeabe", 'e', '$') = "ab$ab$".
          For lab purposes, do NOT use the pre-existing String function replace */
    public static String replace(String s, char c, char d) {
    	  if(s.length()==0){
  	    	return "";
  	    }else{
      		if(s.charAt(0)==(c)){
  	        	return d + replace(s.substring(1), c, d);
  	        }else{
  	        	return s.charAt(0) + replace(s.substring(1), c, d);
  	        }
  	    }
    }
    
    /** = a copy of s with adjacent duplicates removed.
          Example: for s = "abbcccdeaaa", the answer is "abcdea".*/
    public static String rem1(String s) {
    	if(s.length()==1){
    	  	return s;
    	}else{
    		if(s.charAt(0)==s.charAt(1)){
	        	return rem1(s.substring(1));
	        }else{
	        	return s.substring(0, 1) + rem1(s.substring(1));
	        }
    	}
    } 
    
    /** = a copy of s but with the FIRST occurrence of c removed (if present).
          Note: This can be done easily using indexOf. Don't do that.
          Do it recursively.*/
    public static String removeFirst(String s, char c) {
    	if(s.length()==0){
  	    	return "";
  	    }else{
      		if(s.charAt(0)==(c)){
  	        	return s.substring(1);
  	        }else{
  	        	return s.charAt(0) + removeFirst(s.substring(1), c);
  	        }
  	    }
    }

    /** = the reverse of s. e.g. rev("abc") is "cba".
          Do this one using this idea: The reverse of s of
          at least one char is the reverse of s[1..] catenated
          with s[0].
      */
    public static String rev1(String s) {
    	if(s.length()==1){
    		return s;
    	}else{
    		return rev1(s.substring(1)) + s.charAt(0);
    	}
    }

    /** = the reverse of s. e.g. rev("abc") is "cba".
          Do this one using this idea. To reverse a string
          that contains at least 2 characters, switch the
          first and last ones and reverse the middle.
      */
    public static String rev2(String s) {
        if(s.length()==1){
        	return s;
        }else{
        	return s.charAt(s.length()-1) + rev2(s.substring(1,s.length()-1)) + s.charAt(0);
        }
    }
    
   /** = the sum of the integers in s.
         Precondition: s contains at least one integer and
         has the form <integer>:<integer>:...:<integer>,
         and all the integers are positive (no - signs).
         Note that s contains no blanks 
         e.g. sumInts("34") = 34.
         e.g. sumInts("7:34:1:2:2") is 46. */
    public static int sumInts(String s) {
	     if(s.indexOf(":") == -1){
	    	 return Integer.parseInt(s);
	     }else{
    		return Integer.parseInt(s.substring(0, s.indexOf(":"))) 
    				+ sumInts(s.substring(s.indexOf(":")+1));
	     }
    }
    
    /** = n!, which is defined by
          0! = 1
          n! = n * (n-1)!  for n > 0
          Example: !5 = 5*4*3*2*1
          Precondition: n >= 0 */
    public static int fact(int n) {
        if(n==0){
        	return 1;
        }else{
        	return n * fact(n-1);
        }
    }

     /** = number of the digits in the decimal representation of n.
      e.g. numDigits(0) = 1, numDigits(3) = 1, numDigits(34) = 2. 
           numDigits(1356) = 4.
      Precondition: n >= 0. */
    public static int numDigits(int n) {
       if(Integer.toString(n)==""){
    	   return 0;
       }else{
    	   // No fair converting to a string!  That's doing all the work for you :-)
    	   // Think in terms of integer division...
    	   return 1 + numDigits(Integer.parseInt((Integer.toString(n)).substring(1)));
       }
    }
   
    //i had to change this method to long since math.round gave me a long
    // Yeah, Math.round(double) returns a long.  You could use 1.0f and it would
    // return an int, or you could cast the long to an int using (int) Math.round(...)
    //also i'm not sure if the next two are what you were thinking of
    
    /** = sum of the digits in the decimal representation of n.
      e.g. sumDigits(0) = 0, sumDigits(3) = 3, sumDigits(34) = 7,
      sumDigits(345) = 12.
      Precondition: n >= 0. */
    public static long sumDigits(int n) {
    	if(n==0){
    		return 0;
    	}else{
    		// This is neat to compare the results of int and float division.
    		// But you don't need floating point arithmetic here.  You could
    		// compute what you are computing as n - 10 * (n/10).  But that is
    		// the remainder after dividing n by 10, also known as n % 10.
    		// With that approach can you make this simpler?
    		long lastdigit= Math.round((((n*1.0)/10)-(n/10))*10);
    		// Incidentally, you can write "(double) n" to convert n to a double
    		// rather than multiplying by 1.0.ss
    		return lastdigit+sumDigits(n/10);
    	}
    }
    
    /** = the number of 2's in the decimal representation of n.
      e.g. number2(0) = 0, number2(2) = 1, number2(234252) = 3.
      Precondition: n >= 0. */
    public static int number2(int n) {
    	if(n==0){
    		return 0;
    	}else{
    		// Can apply the same simplification as the previous one.
    		long lastdigit= Math.round((((n*1.0)/10)-(n/10))*10);
    		if(lastdigit==2){
    			return 1 + number2(n/10);
    		}else{
    			return 0 + number2(n/10);
    		}
    	}
    }
    
    /** = The number of times that c divides n,
          e.g. into(5,3) = 0 because 3 does not divide 5.
          e.g. into(3*3*3*3*7,3) = 4.
          Precondition: n >= 1 and c > 1 */
    public static int into(int n, int c) {
        if (n%c!=0){
        	return 0;
        }else{
        	return 1+ into(n/c, c);
        }
    }  // Awesome!!
    
    /** = Fibonnaci number F(n).
      Precondition:   n � 0.
      Definition: F(0) = 0,
                  F(1) = 1, and
                  F(n) = F(n-1) + F(n-2) for n > 1.
      E.g. the first 10 Fibonnaci numbers are
           0, 1, 1, 2, 3, 5, 8, 13, 21, 34. */
    public static int Fib(int n) {
        return 0;
    }  // Did this one already I guess.
    
    //i have no idea how this works i just wrote the hints out in code
    // Basically it's using the binary representation of c.
    // I'll explain it in person after I'm back.
    /** = b ** c, i.e. b multiplied by itself c times.
      Also called b "to the power" c.
      Precondition: c � 0
      Hints: b ** 0 = 1.
      if c is even and > 0, b**c == (b*b) ** (c/2)
      if c is odd, b**c =  b * (b ** (c-1)). */
    public static int exp(int b, int c) {
        if(c==0){
        	return 1;
        }else if (c%2==0){
        	return exp(b*b, c/2);
        }else{
        	return b * exp(b, (c-1));
        }
    }
    
    public static long number= 0;
    
    //i don't know exactly what any of this means since its using not eclipse but i can gather
    //that you can create two many frames with recursion
    // You can still do this -- you just have to write test functions to call it, instead
    // of using that Interactions pane that we don't have.  Then watch  what it dumps out
    // when they fail (because of the infinite recursion): it will be a stack trace that 
    // shows how many recursive calls it managed to make before it quit.
    /** You know that each execution of a method call causes a frame to be created to hold
      information about the call --its parameters, local variables, the method name, the scope
      box, etc. On your computer, how many frames can be present at one time? To find out, hit
     the Reset button and then type these lines in the Interactions pane, one at a time:
      
      Rec.number= 0;
      Rec.test();
      Rec.number
      
      Look at the body of test. From it, you can see that the number in static
      variable number is the number of calls made, and thus frames created, until
      there was "stack overflow". Write down that number somewhere.
      
      Then hit the reset button and perform this test:
      
      Rec.number= 0;
      Rec.test(5);
      Rec.number
      
      Here, method test(int), which has one parameter but many local variables, is called many times.
      Compare the number of frames created here with the number created when calling method test().
      Why is one bigger than another?
      
      Finally hit the reset button and perform this test:
      
      Rec.number= 0;
      Rec.test(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
      Rec.number
      
      Here, a method with 10 parameters is called many times. Compare the number of frames created
      this time to the number of frames created the other times. Do the numbers make any sense to you?
      */
    public static void test() {
        number= number + 1;
        test();
    }
    
    public static void test(int b) {
        int d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
        number= number + 1;
        test(b);
    }
    
    public static void test(int b0, int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9) {
        number= number + 1;
        test(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
    }
 
    
}
