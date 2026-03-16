package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer{

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication(){
        switch (ConfigReader.read("browser")){
            case "Chrome":

                /**
                 * use ChromeOptions when running headless during CI/CD
                 */

               /* ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver=new ChromeDriver(options);*/
                driver=new ChromeDriver();
                break;

            case "FireFox":
                driver=new FirefoxDriver();
                break;

            case "Edge":
                driver=new EdgeDriver();
                break;

            case "Safari":
                driver=new SafariDriver();
                break;

            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        //maximize the window - commenting this out only because screen is too big
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //navigate to Syntax website
        driver.get(ConfigReader.read("url"));

        //initialize page objects (POM)
        initializerPageObjects();
        System.out.println("loginPage after init = " + loginPage);
    }

    /**
     * Closes the browser if it is opened
     * will check if the driver is not null before attempting to quit the browser
     */
    public static void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }


    public static void sendText(String text, WebElement element, boolean clear){
        if(clear){
            element.clear();
        }
        element.sendKeys(text);
    }


    public static void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }


    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }


    public static void waitForElementToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }



    public static void selectByValue(WebElement element, String value){
        Select sel=new Select(element);
        sel.selectByValue(value);

    }


    public static void selectByVisibleText(WebElement element, String text){
        Select sel=new Select(element);
        sel.selectByVisibleText(text);
    }


    public static void selectByIndex(WebElement element, int index){
        Select sel=new Select(element);
        sel.selectByIndex(index);
    }


    public byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILE_PATH + fileName+" " +
                    getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return picByte;
    }

    public String getTimeStamp(String pattern){
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

    public void waitForOverlayToDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
