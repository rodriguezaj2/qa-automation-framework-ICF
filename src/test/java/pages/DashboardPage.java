package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashboardPage extends CommonMethods {

    @FindBy(xpath = "//h1[text() = 'Dashboard']")
    public WebElement dashboardMessage;

    @FindBy (xpath = "//button[text()='Add record']")
    public WebElement addRecordButton;

    public void clickLastDeleteButton() {

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[@name='delete-record-button btn']"));

        WebElement lastDelete = deleteButtons.get(deleteButtons.size() - 1);

        waitForElementToBeClickable(lastDelete);

        lastDelete.click();
    }


    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
