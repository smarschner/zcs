package zcs.asgn8;

import java.util.ArrayList;

import zcs.asgn1.*;

public class IterPractice {
	//printEm
		public static void printEm(int n, int m){
			while(m<n){
				System.out.println(m);
				m= m+1;
			}
		}
		
		public static void printEm1(int n, int m){
			while(m!=n){
				System.out.println(m);
				m= m+1;
			}
		}
		
		public static void printEm2(int n, int m){
			while(m<=n-1){
				System.out.println(m);
				m= m+1;
			}
		}
		
		public static void printEmBackwards(int n, int m){
			while(n>m){
				System.out.println(n-1);
				n= n-1;
			}
		}
		
		public static void printEmFor(int n, int m){
			for(; m<n; m++){
				System.out.println(m);
			}
		}
		
		public static void printEmBackwardsFor(int n, int m){
		for(; n>m; n--){
			System.out.println(n-1);
		}
	}
		
	//other stuff
		public static void addFromUser(){
			int sum= 0;
			String input= "0";
			InputReader ir = new InputReader();
			
			while(!(input.equals(""))){
				sum += (Integer.parseInt(input));
				System.out.print("Type a number: ");
				input= ir.readLine();
			}
			
			System.out.println("Your sum is " + sum + ".");
		}
		
		public static void listFromUser(){
			String sum= "";
			String input= "";
			InputReader ir = new InputReader();
			boolean stop= false;
			
			while(stop==false){
				System.out.print("Type a word: ");
				input= ir.readLine();
				if (input.indexOf("and ")!=-1){
					sum+=" and";
					input= input.substring(4);
					stop= true;
				}
				if("aeiou".indexOf(input.charAt(0))==-1){
					sum+=" a " + input + ",";
				}else{
					sum+=" an " + input + ",";
				}
			}
			sum= sum.substring(0, sum.length()-1);
			
			System.out.print("You have" + sum + ".");
			
				
		}
		
		public static void listFromUser2(){
			ArrayList<String> list = new ArrayList<String>();
			String input= "";
			InputReader ir = new InputReader();
			boolean stop= false;
			while(stop==false){
				System.out.print("Type a word: ");
				input= ir.readLine();
				if (input.equals("")){
					stop= true;
				}else{
					if("aeiou".indexOf(input.charAt(0))==-1){
						list.add("a " + input);
					}else{
						list.add("an " + input);
					}
				}
			}
			System.out.print("You have ");
			for (int i = 0; i < list.size(); i++) {
				if(i==(list.size()-1)){
					System.out.print("and " + list.get(i)+ ".");
				}else{
					System.out.print(list.get(i)+", ");
				}
			}
		}
		
}
