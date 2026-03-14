package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

    @FindBy(xpath = "//h1[text() = 'Dashboard']")
    public WebElement dashboardMessage;

    @FindBy (xpath = "//button[text()='Add record']")
    public WebElement addRecordButton;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
