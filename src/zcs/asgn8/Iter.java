package zcs.asgn8;

/**
 * These are the same methods as in the recursion lab -- so you can use the same 
 * test cases.  But this time, write them using loops instead of recursion.
 */

public class Iter {
    /** = number of times c occurs in s. */
    public static int numberc(char c, String s) {
        return 0;
    }
    
    /** = number of chars in s that are not c. */
    public static int numberNotc(char c, String s) {
        return 0;
    }

    /** = a copy of s but with all occurrences of c replaced by d. 
          Example: replace("abeabe", 'e', '$') = "ab$ab$".
          For lab purposes, do NOT use the pre-existing String function replace */
    public static String replace(String s, char c, char d) {
        return "";
    }
    
    /** = a copy of s with adjacent duplicates removed.
          Example: for s = "abbcccdeaaa", the answer is "abcdea".*/
    public static String rem1(String s) {
        return "";
    } 
    
    /** = a copy of s but with the FIRST occurrence of c removed (if present).
          Note: This can be done easily using indexOf. Don't do that.
          Do it using a String accumulator.*/
    public static String removeFirst(String s, char c) {
        return "";
    }

    /** = the reverse of s. e.g. rev("abc") is "cba". */
    public static String rev1(String s) {
        return "";   
    }
    
   /** = the sum of the integers in s.
         Precondition: s contains at least one integer and
         has the form <integer>:<integer>:...:<integer>,
         and all the integers are positive (no - signs).
         Note that s contains no blanks 
         e.g. sumInts("34") = 34.
         e.g. sumInts("7:34:1:2:2") is 46. */
    public static int sumInts(String s) {
        return 0;
    }
    
    /** = n!, which is defined by
          0! = 1
          n! = n * (n-1)!  for n > 0
          Example: !5 = 5*4*3*2*1
          Precondition: n >= 0 */
    public static int fact(int n) {
        return 1;
    }

     /** = number of the digits in the decimal representation of n.
      e.g. numDigits(0) = 1, numDigits(3) = 1, numDigits(34) = 2. 
           numDigits(1356) = 4.
      Precondition: n >= 0. */
    public static int numDigits(int n) {
        return 0;
    }
   
    /** = sum of the digits in the decimal representation of n.
      e.g. sumDigits(0) = 0, sumDigits(3) = 3, sumDigits(34) = 7,
      sumDigits(345) = 12.
      Precondition: n >= 0. */
    public static int sumDigits(int n) {
        return 0;
    }
    
    /** = the number of 2's in the decimal representation of n.
      e.g. number2(0) = 0, number2(2) = 1, number2(234252) = 3.
      Precondition: n >= 0. */
    public static int number2(int n) {
        return 0;
    }
    
    /** = The number of times that c divides n,
          e.g. into(5,3) = 0 because 3 does not divide 5.
          e.g. into(3*3*3*3*7,3) = 4.
          Precondition: n >= 1 and c > 1 */
    public static int into(int n, int c) {
        return 0;
    }  
    
    /** = Fibonnaci number F(n).
      Precondition: n >= 0.
      Definition: F(0) = 0,
                  F(1) = 1, and
                  F(n) = F(n-1) + F(n-2) for n > 1.
      E.g. the first 10 Fibonnaci numbers are
           0, 1, 1, 2, 3, 5, 8, 13, 21, 34. */
    public static int Fib(int n) {
        return 0;
    }
    
    
    /** = b ** c, i.e. b multiplied by itself c times.
      Also called b "to the power" c.
      Precondition: c >= 0
      Hint: You can do this the simple way, and b**c will take c-1 multiplications.
      Can you find a way to do it where, e.g., b**8 only takes 3 multiplications? */
    public static int exp(int b, int c) {
        return 0;
    }

}
