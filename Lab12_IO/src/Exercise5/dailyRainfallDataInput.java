package Exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class dailyRainfallDataInput {

	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "rainfallReading.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			int rainfallReading = 0;
			int totalRainfallReading = 0;
			int noOfRecords = 0;
			String date = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				date = dis.readUTF();
				rainfallReading = dis.readInt();
				System.out.println( date +  " --> " + rainfallReading);
				
				// Calculate total utilization
				totalRainfallReading += rainfallReading;
				noOfRecords ++;
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate rainfall reading
			int averageRainfallReading = totalRainfallReading / noOfRecords;
			
			System.out.print("\nAverage rainfall from station Simpang Ampat in Alor Gajah for " + noOfRecords 
					+ " days : " + averageRainfallReading + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program 
		System.out.println("\n\nEnd Of Program.");
		

	}
}
