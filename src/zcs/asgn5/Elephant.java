package zcs.asgn5;

public class Elephant {

		private String nickname; //Name given to Elephant, a String length > 0. Need not be unique.
		private int yearofbirth; //Year the Elephant was born —must be > 1900.
		private int monthofbirth; //Month the Elephant was born —in range 1..12, 1 = January.
		private char gender; //gender of this Elephant. Must be either ‘B’ (boy) or ‘G’ (girl).
		private int tag = -1; //this Elephant’s tag. An integer >= 0. –1 means Elephant has no tag
		private Elephant mother; //object of class Elephant that is mother of object null=unknown.
		private Elephant father; //object of class Elephant that is father of object null=unknown.
		private int children; //# of children of this Elephant (based on the mother and father).
		
		//Constructor: a new Elephant with nickname n, birth year y, birth month m, and gender g. 
		//Its parents are unknown, and it has no children.
		//Precondition: n's length is > 0. y > 1900. g is either ‘B’ (for boy) or ‘G’ (for girl)
		public Elephant(String n, int y, int m, char g){
			nickname= n;
			yearofbirth= y;
			monthofbirth= m;
			gender= g;
		}
		
		//Constructor: a new Elephant with nickname n, birth year y, birth month m, gender g, 
		//tag t, mother ma, and father pa.
		//Precondition: n’s length is > 0, y > 1900, m is the month number, in 1..12, g is ‘B’ for
		//boy or ‘G’ for girl, tag t >= 0 (or –1 if not tagged), and ma and pa may not be null.
		public Elephant(String n, int y, int m, char g, int t, Elephant ma, Elephant pa){
			nickname= n;
			yearofbirth= y;
			monthofbirth= m;
			gender= g;
			tag= t;
			
			mother= ma;
			ma.children= ma.children + 1;
			
			father= pa;
			pa.children= pa.children + 1;
		}	
		
		//= this Elephant’s nickname
		public String getName(){
			return nickname;
		}

		//= year this Elephant was born
		public int getYear(){
			return yearofbirth;
		}
		
		//= month this Elephant was born --1 means jan, 2 feb, etc.
		public int getMonth(){
			return monthofbirth;
		}
		
		//= "this Elephant is a boy"
		public boolean isMale(){
			return gender=='b';
		}
		
		//= this Elephant’s tag (>= 0; -1 if one)
		public int getTag(){
			return tag;
		}
		
		//= this Elephant’s mother (null if unknown)
		public Elephant getMother(){
			return mother;
		}
		
		//= this Elephant's father (null if unknown)
		public Elephant getFather(){
			return father;
		}
		
		//= the number of children of this Elephant
		public int getNumChildren(){
			return children;
		}
		
		//Set this Elephant's tag to n. Precondition: n >= 0.
		public void setTag(int n){
			tag= n;
		}
		
		//Add e as this Elephant's mother. 
		//Precondition: e is not null, e is a girl, and this Elephant does not have a mother.
		public void addMother(Elephant e){
			mother= e;
			e.children= e.children+1;
		}

		//Add e as this Elephant's mother. 
		//Precondition: e is not null, e is a girl, and this Elephant does not have a mother.
		public void addFather(Elephant e){
			father= e;
			e.children= e.children+1;
		}
		
		
}
