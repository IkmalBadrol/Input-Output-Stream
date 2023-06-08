package Exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class dailyRainfallDataOutput {

	public static void main(String[] args) {
		
		// 1. Declare output file 
			String outFile = "rainfallReading.txt";
				
			// Data declaration
			String date[] = {"02/06/2023 ", "03/06/2023", "04/06/2023", "05/06/2023", "06/06/2023", "07/06/2023"};
			int  rainfallReading[] = {0, 0, 4, 1, 0, 6};
				
			try {
					
				// 2. Create stream to read data
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
					
					// Process data
					for (int index = 0; index < date.length; index++) {
						
						// 3. Write data into data stream
						dos.writeUTF(date[index]);
						dos.writeInt(rainfallReading[index]);
						
						// 4. Flush for each writing
						dos.flush();
					}
					
					// 5. Close stream
					dos.close();
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				
				// Indicate end of program - Could be successful
				System.out.println("End of program. Check out " + outFile); 
			}
}
