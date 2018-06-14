package patch;

import java.io.FileWriter;
import java.io.IOException;

public class CreateCsvFile {

private static void generateCsvFile(String fileName) {

      FileWriter writer = null;

 try {
	 /*"email":"lama@clovity.com",
	 "password":"password1",
	 "gender":"male",
	 "dob":"1984/01/11",
	 "height":"5.8",
	 "weight":"50",
	 "confirmationPassword":"password1",
	 "lastName":"Rangarajan",
	 "firstName":"srinivasan",
	 "displayMeasurement":"standard",
	 "countryOfResidence":"US",
	 "noMedicalDeviceApproval":"true",
	 "agreeToTerms":"true",
	 "heightUnit":"ft",
	 "weightUnit":"ibs"
	 }    */                      

     writer = new FileWriter(fileName);
  
  for(int i=0;i<100;i++)
  {
  if(i==0){//header names
   writer.append("email");
   writer.append(',');
   writer.append("password");
   writer.append(',');
   writer.append("gender");
   writer.append(',');
   writer.append("height");
   writer.append(',');
   writer.append("weight");
   writer.append(',');
   writer.append("confirmationPassword");
   writer.append(',');
   writer.append("lastName");
   writer.append(',');
   writer.append("firstName");
   writer.append(',');
   writer.append("displayMeasurement");
   writer.append(',');
   writer.append("countryOfResidence");
   writer.append(',');
   writer.append("noMedicalDeviceApproval");
   writer.append(',');
   writer.append("agreeToTerms");
   writer.append(',');
   writer.append("heightUnit");
   writer.append(',');
   writer.append("weightUnit");
   writer.append(',');
   
   
   writer.append('\n');
  }
  if(i>0){
   writer.append("satishpat1"+i+"@gmail1.com");
   writer.append(',');
   writer.append("Pass@1234"+i);
   writer.append(',');
   writer.append("male");
   writer.append(',');
   writer.append("6."+i);
   writer.append(',');
   writer.append("68"+i);
   writer.append(',');
   writer.append("Pass@1234"+i);
   writer.append(',');
   writer.append("patnaik"+i);
   writer.append(',');
   writer.append("prasad"+i);
   writer.append(',');
   
   writer.append("standard");
   writer.append(',');
   writer.append("US");
   writer.append(',');
   writer.append("TRUE");
   writer.append(',');
   writer.append("TRUE");
   writer.append(',');
   writer.append("FT");
   writer.append(',');
   writer.append("IBS");
   writer.append(',');
   
   
   
   writer.append('\n');
  }
  }

     System.out.println("CSV file is created...");

  } catch (IOException e) {
     e.printStackTrace();
  } finally {
        try {
      writer.flush();
      writer.close();
        } catch (IOException e) {
      e.printStackTrace();
}
}
}

public static void main(String[] args) {

 String location = "E:\\Learning\\addteam.csv";
 generateCsvFile(location);

}

}