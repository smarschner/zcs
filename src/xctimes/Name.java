package xctimes;

public class Name {
	public String first, last;
	
	//raw is a persons name last, first
	public Name(String raw){
		int d= raw.indexOf(',');
		last= raw.substring(0,d);
		last= last.trim();
		first= raw.substring(d+1);
		first= first.trim();
	}
	
	@Override
	public boolean equals(Object e){
		if(e==null) return false;
		if(e.getClass()==this.getClass()){
			Name n= (Name) e;
			return (this.first.equals(n.first))&&(this.last.equals(n.last));
		}else{return false;}
	}
	
	@Override
	public int hashCode(){
		return first.hashCode()+last.hashCode();
	}
	
	@Override
	public String toString(){
		return last+','+first;
	}
}
