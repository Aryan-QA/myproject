package listeners;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = BaseTest.getDriver();

        // Screenshot capture in Desktop or desired path
        ScreenshotUtil.captureScreenshot(driver, result.getName());

        // Allure screenshot
        byte[] screenshot = ScreenshotUtil.getScreenshotBytes(driver);
        saveScreenshotToAllure(screenshot);

        // Allure text log
        saveTextLog("Test Failed: " + result.getName());
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshotToAllure(byte[] screenShot) {
        return screenShot;
    }

    @Attachment(value = "Log", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
