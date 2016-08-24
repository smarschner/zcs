package xctimes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class TimeSorter {
	public static void main(String[] args) throws IOException {

		HashMap<Name, Time> times= new HashMap<Name, Time>();

		//puts current times into a map

		BufferedReader inputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader(args[0]));
			String l;
			while ((l = inputStream.readLine()) != null) {
				if(!(l.trim().equals(""))){
					String rawName= l.substring(0, l.indexOf(':'));
					String rawTime= l.substring(l.indexOf(':')+1);
					times.put(new Name(rawName), new Time(rawTime));
				}
			}
		}catch(NumberFormatException e){
			System.out.println(e.getMessage()+": expected number");
		}catch(FileNotFoundException e){
			System.out.println("Roaster file not found: "+ e.getMessage());
		}finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		//replaces any times that are faster

		BufferedReader inputStream2 = null;

		try {
			inputStream2 = new BufferedReader(new FileReader(args[1]));
			String l;
			while ((l = inputStream2.readLine()) != null) {
				if(!(l.trim().equals(""))){
					Name name= new Name(l.substring(0, l.indexOf(':')));
					Time time= new Time(l.substring(l.indexOf(':')+1));
					for(Name key : times.keySet()){
						if(name.equals(key)){
							Time oldtime= times.get(key);
							if((time.minutes==oldtime.minutes&&time.seconds<oldtime.seconds)||(time.minutes<oldtime.minutes)){
								times.put(name, time);
							}
						}
					}
					if(!times.containsKey(name)){
						times.put(name, time);
					}	
				}
			}
		}catch(NumberFormatException e){
			System.out.println(e.getMessage()+": expected number");
		}catch(FileNotFoundException e){
			System.out.println("Race times file not found: "+e.getMessage());
		}finally {
			if (inputStream2 != null) {
				inputStream2.close();
			}
		}

		//outputs the new list
		PrintWriter outputStream = null;

		try {
			outputStream = new PrintWriter(new FileWriter(args[2]));
			for(Entry<Name, Time> entry : times.entrySet()){
				outputStream.println(entry.getKey().toString()+" : "+entry.getValue().toString());
			}
		}catch(FileNotFoundException e){
			System.out.println("Output file not found: "+e.getMessage());
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}
