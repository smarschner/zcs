package rectangle;

public class Move {
	public static void moveRect(Rectangle r, int x1, int y1, int x2, int y2){
		int orgLength= r.getLength();
		int orgHeight= r.getHeight();
		
		r.topx-=x1-x2;
		r.topy-=y1-y2;
		r.bottomx=r.topx+orgLength;
		r.bottomy=r.topy+orgHeight;
	}
}
