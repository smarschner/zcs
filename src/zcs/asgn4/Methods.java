package zcs.asgn4;

/** Small exercises on developing methods dealing with time formats.
 * This class borrowed from Cornell CS1110, Fall 2011. 
 * */
public class Methods {
    
   /** Time formats:
        1. 24-hour-string:  "<hours>:<minutes>"
                             <hours> is in range 0..23 and <minutes> is in range 0..59
                             Examples: "4:20"  "13:0"   "23:59" "0:0"
                             
        2. AM-PM-string:    "<hours>:<minutes>AM" or "<hours>:<minutes>PM"
                             <hours> is in range 0..11 and <minutes> is in range 0..59
                             Examples: "4:20AM"  "3:0PM"   "11:59PM"  "0:0AM"
                             
        3. 24-hour-verbose  Example: "4 hours and 20 minutes"
                                     "23 hours and 59 minutes"
                             Note: exactly one blank between each of the pieces
        
        4. 24-hour-correct  Exactly like the 24-hour-verbose format except that
                            it is grammatically correct. So, instead of
                            "1 hours and 20 minutes" it reads "1 hour and 20 minutes"
                            and instead of
                            "0 hours and 1 minutes" it reads "0 hours and 1 minute"
                            
        Note: if a String s contains only digits (not even blanks), then the
        function call Integer.parseInt(s) yields the integer represented by s. 
        For example, Integer.parseInt("345") is 345. */
    
    /** = time s in 24-hour-verbose format.
        Precondition: s a time in the 24-hour-string format.  */
    public static String toVerbose(String s) {
    	return "";
    }
    
    /** = time s in AM-PM format.
        Precondition: s is a time in 24-hour-string format. */
    public static String toAMPM(String s) {
    	return "";
    }
    
    /** = time s in 24-hour-correct time.
        s is a time in 24-hour-string format.  */
    public static String timeToCorrect(String s) {
        return "";
    }
    
    /** = time s in 24-hour-string format.
        Precondition: s is a time in AM-PM-string format. */
    public static String eliminateAMPM(String s) {
        return "";
    }
    
    /** = time s in the 24-hour-string format.
        Precondition: s is a time in EITHER the 24-hour-string
        format OR the AM-PM-string format. */
    public static String removeAMPM(String s) {
        return "";
    }
    
    /** = time s as the number of minutes. E.g. "14:35" is 14*60 + 35.
        Precondition: s is a time in the 24-hour-string format. */
    public static int timeInMinutes(String s) {
        return 0;
    }
    
    
    /** = time s as the number of minutes. E.g. "2:35PM" is 14*60 + 35.
        Precondition: s is a time in the AM-PM-string format.             
     */
    public static int AMPMtimeInMinutes(String s) {
        // Note: See if you can write the body as a single return statement.
        return 0;
    }
    
    /** = "time s1 comes before time s2".
        Precondition: s1 and s2 are in either 24-hour-string format
        or AM-PM-string format. */
    public static boolean comesBefore(String s1, String s2) {
        // Note: See if you can write the body as a single return statement.
        return false;
    }
}
