package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DeleteModalPage extends CommonMethods {

    @FindBy (xpath = "//h2[text()='Are you absolutely sure?']")
    public WebElement confirmationModal;

    @FindBy (xpath = "//button[text()='Cancel']/following-sibling::button[text()='Delete']")
    public WebElement deleteConfirmationButton;

    @FindBy (xpath = "//button[text()='OK']")
    public WebElement okButton;

    public DeleteModalPage(){
        PageFactory.initElements(driver,this);
    }
}
