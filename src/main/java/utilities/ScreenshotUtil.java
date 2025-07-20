package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {
    	
    	// take screenshot in peoject project folder for production
    /*	 try {
             File folder = new File("screenshots");
             if (!folder.exists()) folder.mkdirs();

             String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
             File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
             String path = "screenshots/" + testName + "_" + timestamp + ".png";
             FileUtils.copyFile(src, new File(path));
             System.out.println("📷 Screenshot saved: " + path);
         } catch (IOException e) {
             System.out.println("❌ Screenshot capture failed");
             e.printStackTrace();
         }  */
    	
    	 /* code to take screenshot in  desktop folder */
    	   File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        
        // code to take screenshot in  desktop folder
      String folderPath = "C:\\Users\\Cloud Laptop\\OneDrive\\Desktop\\scnpatth";
        File folder = new File(folderPath);
//        if (!folder.exists()) {
//            folder.mkdirs(); // ✅ Create folder if it doesn't exist
//        }
///

        String path = folderPath + "/" + testName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(src, new File(path));
            System.out.println("📸 Screenshot saved: " + path);
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot");
            e.printStackTrace();
        }   
    	
    }
    
    public static byte[] getScreenshotBytes(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
