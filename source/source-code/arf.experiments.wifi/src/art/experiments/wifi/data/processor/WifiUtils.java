package art.experiments.wifi.data.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.Map.Entry;



public class WifiUtils {

	public static List<String> getLines(String inputFile) {
		//System.out.println(inputFile);
		Pattern pattern = Pattern.compile("\\n");	
		Scanner scan = null;
		try {
			scan = new Scanner(new File(inputFile));	
			scan.useDelimiter(pattern);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		List<String> lines = new ArrayList<String>();
		while (scan.hasNext()){
			String text = scan.next();	
			if (!text.isEmpty()) {
			 lines.add(text);
			}
		}
		
		return lines;
	}
	
	public static void printMap(Map<String, List<String>> mymap) {
		//System.out.println("Map: ");
		for (Entry<String, List<String>> entry : mymap.entrySet()) {
			System.out.print(entry.getKey() + " --> " );
			List<String> values =  entry.getValue();
			for (int i=0; i < values.size(); i++) {
				if (i > 0) {
					System.out.print(", ");
				}
				System.out.print(values.get(i) );
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static void printEventInfoMap(Map<String, List<EventInfo>> mymap) {
		//System.out.println("Map: ");
		for (Entry<String, List<EventInfo>> entry : mymap.entrySet()) {
			System.out.print(entry.getKey() + " --> " );
			List<EventInfo> values =  entry.getValue();
			for (int i=0; i < values.size(); i++) {
				if (i == 0) {
					System.out.println();
				}
				System.out.println(values.get(i) );
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static void printSensorTreeMap(Map<String, Sensor> mymap) {
		for (Entry<String, Sensor> entry : mymap.entrySet()) {
			System.out.print(entry.getKey() + " --> " );
			Sensor value =  entry.getValue();
			System.out.println(value);
		}
		System.out.println();
	}
	
	public static void printMapNewlines(Map<String, List<String>> mymap) {
		//System.out.println("Map: ");
		for (Entry<String, List<String>> entry : mymap.entrySet()) {
			System.out.print(entry.getKey() + " --> " );
			List<String> values =  entry.getValue();
			for (int i=0; i < values.size(); i++) {		
				if (i == 0) {
					System.out.println();
				}
				System.out.println("\t" + values.get(i) );
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	
	public static void printList(List<String> l) {
		//System.out.println("List: ");
		for (String s : l) {
			System.out.println(s);
		}
		System.out.println();
	}
	
	public static void stop() {
		System.out.println("Terminating because of user stop.");
		System.exit(0);
	}
	
	public static String intToString(int i) {
		char c = (char) (97 + i);
		String s = Character.toString(c);
		return s.toUpperCase();
	}
	
//	
//	public static void resultsToMatlab(String matlabFile, double[][][] results) {
//		BufferedWriter bw = null;
//		try {
//	          File file = new File(matlabFile);
//	          bw = new BufferedWriter(new FileWriter(file));
//	          //bw.write(text);
//	         
//        } catch ( IOException e ) {
//           e.printStackTrace();
//        }
//		finally {
//			if (bw != null) {
//				try {
//					bw.close();
//				}
//				catch (Exception e) {
//					 e.printStackTrace();
//				}
//			}
//			
//		}
//	}

}
