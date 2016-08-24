package xctimes;

public class Time {
	public int minutes;
	public double seconds;
	
	//raw is a time xx:xx.xx
	public Time(String raw){
		int d= raw.indexOf(':');
		String mString= raw.substring(0,d);
		mString= mString.trim();
		minutes= Integer.parseInt(mString);
		String sString= raw.substring(d+1);
		sString= sString.trim();
		seconds= Double.parseDouble(raw.substring(d+1));
	}
	
	@Override
	public boolean equals(Object e){
		if(e==null) return false;
		if(e.getClass()==this.getClass()){
			Time n= (Time) e;
			return (this.minutes==n.minutes)&&(this.seconds==n.seconds);
		}else{return false;}
	}
	
	@Override
	public int hashCode(){
		return (int)(Math.round(seconds+(minutes*60)));
	}
	
	@Override
	public String toString(){
		return minutes+":"+((double)((int)(seconds*100)))/100;
	}
}
