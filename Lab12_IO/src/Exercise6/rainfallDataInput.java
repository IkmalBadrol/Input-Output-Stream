package Exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class rainfallDataInput {

	public static void main(String[] args) {

		// 1. Declare output file 
		try {

			// 2. Create stream to read data
			String sourceFile = "rainfallReading.txt";
			System.out.println("Reading data from " + sourceFile + "\n");
			
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			int totalAverageStationRainfall = 0;	
			int[] totalRainfallReading =  new int[6];
			int[] totalStation = new int[6];
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				String districtName = dis.readUTF();
				String stationID = dis.readUTF();
				String stationName = dis.readUTF();
				
				// 4. Print details
				System.out.println("\nDistrict Name : " +districtName);
				System.out.println("Station ID : " +stationID);
				System.out.println("Station Name : " +stationName + "\n");
				
				int stationTotalRainfall = 0;
				
				for(int i = 0; i < 6; i++) {
					int data = dis.readInt();
					stationTotalRainfall += data;
					totalRainfallReading[i] += data;
					totalStation[i]++;
					
					System.out.println("Day " +(i+1)+ " - " +data );
				}

				//5. Calculate average rainfall data for each station
				int averageStationRainfall = stationTotalRainfall/6;
				System.out.println("Average rainfall data : " +averageStationRainfall);
				totalAverageStationRainfall += averageStationRainfall;
				
			}
			
			//6. calculate average data for 6 stations
			int averageRainfall = totalAverageStationRainfall/6;
			System.out.println("\nAverage rainfall for 6 stations is " +averageRainfall);
			// 4. Close stream
			dis.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program 
		System.out.println("\n\nEnd Of Program.");

	}
}
