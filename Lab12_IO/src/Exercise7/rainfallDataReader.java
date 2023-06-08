package Exercise7;

import java.io.BufferedReader;
import java.io.FileReader;

public class rainfallDataReader {

	public static void main(String[] args) {
		

		// 1. Declare output file 
		String sourceFile = "rainfallReading.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			BufferedReader dis = new BufferedReader(new FileReader(sourceFile));

			// Variables for processing byte-based data
			String rainfallReading;
			String rainfallReadingData[] = {};
			int totalRainfallReading = 0;
			int noOfRecords = 0;

			// 3. Process data until end-of-file
			 while ((rainfallReading = dis.readLine()) != null) {
				
				 rainfallReadingData = rainfallReading.split("-");
			 }
			 
				String station ;
				station = rainfallReadingData[0];
				System.out.println(station);
				System.out.println("Rainfall data : ");
				
				for(int i = 1; i < rainfallReadingData.length; i++) {
					System.out.println(rainfallReadingData[i] + ",");
					totalRainfallReading += Integer.parseInt(rainfallReadingData[i]);
					noOfRecords++;
				}
				
			dis.close();
							
			// Calculate average rainfall reading
			int averageRainfallReading = totalRainfallReading / noOfRecords;
			
			System.out.print("\nAverage rainfall from station Simpang Ampat in Alor Gajah for " + noOfRecords + " days : " + averageRainfallReading);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program 
		System.out.println("\n\nEnd Of Program.");
		

	}
}
