package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AboutPage extends CommonMethods {

    @FindBy (id = "user-menu-button")
    public WebElement menuButton;

    @FindBy (id = "headlessui-menu-item-_r_0_")
    public WebElement signInButton;

    public AboutPage(){
        PageFactory.initElements(driver,this);
    }
}
