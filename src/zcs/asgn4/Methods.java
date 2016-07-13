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
	// This method works, but it could be simpler if you 
	// convert the hours and minutes to integers, as you
	// do in some of the later ones.
    public static String toVerbose(String s) {
    	// Most people put spaces outside the parentheses: 
    	// if (s.startsWith("1") || s.startsWith("2")) {
    	if(s.startsWith("1") || s.startsWith("2")){
    		String h = s.substring(0,2);
        	String m = s.substring(3);
        	// You don't need parentheses around the return value.
        	return (h +" hours and " + m + " minutes");
    	}else{  // and also around "else" : "} else {"
    		if(s.startsWith("0")){
    			String h = s.substring(1,2);
            	String m = s.substring(3);
            	return (h +" hours and " + m + " minutes");
    		}else{
    			String h = s.substring(0,1);
    			String m = s.substring(2);
    			return (h +" hours and " + m + " minutes");
    		}
    	}
    }
    
    // This one supports times with hour == 24.  But I don't
    // think this is part of the expected input: the description 
    // of the 24-hour string format at the top of this file
    // says the hour is in the range 0..23.
    // This method doesn't work with a string that starts with "0:".
    private static String toAMPM_Z(String s) {
    	if(s.startsWith("1")||s.startsWith("2")||s.startsWith("0")){
    		String hs = s.substring(0,2);
    		int h = Integer.parseInt(hs);
    		// Here you can write "h > 12 && h != 24"
    		if(h>12 && (!(h==24))){
    			String u = s.substring(0,2);
    			int ui = Integer.parseInt(u);
    			ui = (ui-12);
            	String m = s.substring(3);
            	return (ui + ":" + m + " PM");
    		}else{
    			if(h==12){
    			 	String m = s.substring(3);
                	return (12 + ":" + m + " PM");
    			}else{
	    			if(s.startsWith("1")){
	    			String u = s.substring(0,2);
	            	String m = s.substring(3);
	            	return (u + ":" + m + " AM");
	    			}else{
	    				if(s.startsWith("0")){
	    				String u = s.substring(1,2);
	                	String m = s.substring(3);
	                	return (u + ":" + m + " AM");
	    				}else{
	                	return ("12:00 AM");
	    				}
	    			}
    			}
    		}
    	}else{
    		String u = s.substring(0,1);
			String m = s.substring(2);
			return (u + ":" + m + " AM");
    	}
    		
    }
    
    // Here is my simpler version...
    private static String toAMPM_D(String s) {
    	int iColon = s.indexOf(':');
    	int h = Integer.parseInt(s.substring(0, iColon));
    	String ms = s.substring(iColon + 1);
    	if (h >= 12)
    		return (h > 12 ? h - 12 : h) + ":" + ms + " PM";
    	else
    		return (h == 0 ? 12 : h) + ":" + ms + " AM";
    }
    
    /** = time s in AM-PM format.
        Precondition: s is a time in 24-hour-string format. */
    public static String toAMPM(String s) {
    	return toAMPM_D(s);
    }
    
   /** = time s in 24-hour-correct time.
        s is a time in 24-hour-string format.  */
    public static String timeToCorrect(String s) {
    	int x = s.indexOf("h");
    	String HourS = s.substring(0,(x-1));
    	int HourI = Integer.parseInt(HourS);
    	
    	int y = s.indexOf("m");
    	int z = s.indexOf("d");
    	String MinS = s.substring((z+2),(y-1));
    	int MinI = Integer.parseInt(MinS);
    
    	// You can do this in a slick way with conditional expressions.
    	// Can you get rid of all the if/elses and write a single 
    	// return statement with two conditional expressions in it?
    	if(HourI==1&&MinI==1){
    		return (HourI + " hour and " + MinI + " minute");
    	}else{
    		if(HourI==1){
    			return (HourI + " hour and " + MinI + " minutes");
    		}else{
    			if(MinI==1){
    				return (HourI + " hours and " + MinI + " minute");
    			}else{
    				return (HourI + " hours and " + MinI + " minutes");
    			}
    		}
    	}
    	
    }
    
    /** = time s in 24-hour-string format.
        Precondition: s is a time in AM-PM-string format. */
    public static String eliminateAMPM(String s) {
    	int x = s.indexOf("M");
    	String AMPM = s.substring(x-1);
    	
    	int y = s.indexOf(":");
    	String HourS = s.substring(0,y);
    	String MinS = s.substring(y+1,x-2);
    	int HourI = Integer.parseInt(HourS);
    	int MinI = Integer.parseInt(MinS);
    	
    	// I wonder if there is a simpler way to write
    	// this logic.
    	if(HourI==12&&(AMPM.compareTo("AM") == 0)){
    		return ("0:" + MinI);
    	}else{
    			if(AMPM.compareTo("AM")==0){
    				return (HourI + ":" + MinI);
    			}else{
    				if(HourI==12){
    					return (HourI + ":" + MinI);
    				}else{
    					return (HourI+12 + ":" + MinI);
    				}
    			}
    		}
    }
    
    /** = time s in the 24-hour-string format.
        Precondition: s is a time in EITHER the 24-hour-string
        format OR the AM-PM-string format. */
    // This one is nice: you reused what you did before,
    // so this method is very simple.
    public static String removeAMPM(String s) {
    	int x = s.indexOf("M");
    	// don't forget to remove debugging output after you are
    	// finished debugging.
        System.out.print(x);  
        if(x==-1){
        	return s;
        }else{
        	return eliminateAMPM(s);
        }
    }
    
    /** = time s as the number of minutes. E.g. "14:35" is 14*60 + 35.
        Precondition: s is a time in the 24-hour-string format. */
	// This one is beautiful -- just like a professional programmer
	// would write it.  It's easy to understand and your variable
	// names make it obvious what you're thinking.  Nice!
    public static int timeInMinutes(String s) {
    	int y = s.indexOf(":");
    	String HourS = s.substring(0,y);
    	String MinS = s.substring(y+1);
    	int HourI = Integer.parseInt(HourS);
    	int MinI = Integer.parseInt(MinS);
    	
    	return HourI*60+MinI;
    } 
    
    
    /** = time s as the number of minutes. E.g. "2:35PM" is 14*60 + 35.
        Precondition: s is a time in the AM-PM-string format.             
     */
    // Very nice!
    public static int AMPMtimeInMinutes(String s) {
        // Note: See if you can write the body as a single return statement.
        return timeInMinutes(eliminateAMPM(s));
    }
    
    /** = "time s1 comes before time s2".
        Precondition: s1 and s2 are in either 24-hour-string format
        or AM-PM-string format. */
    // Nice and clear, but do you really need s11 and s22?  Can you do
    // it all on one line?
    public static boolean comesBefore(String s1, String s2) {
        // Note: See if you can write the body as a single return statement.
    		int s11 = timeInMinutes(removeAMPM(s1));
    		int s22 = timeInMinutes(removeAMPM(s2));
    				
    		// Nice use of boolean expression.  Most beginners will write
    		// "if (s11 < s22) { return true; } else { return false; }"
    		// which is just redundant!
        	return (s11 < s22);
         }
    }

