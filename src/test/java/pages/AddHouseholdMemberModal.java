package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

public class AddHouseholdMemberModal extends CommonMethods {


    @FindBy (name = "relationship")
    public WebElement relationshipDropdown;

    @FindBy (id = "firstName")
    public WebElement firstNameField;

    @FindBy (id = "lastName")
    public WebElement lastNameField;

    @FindBy (xpath = "//input[@placeholder='Pick a date']")
    public WebElement dobField;

    @FindBy (xpath = "//select[@aria-label='Choose the Month']")
    public WebElement monthDropdown;

    @FindBy (xpath = "//select[@aria-label='Choose the Year']")
    public WebElement yearDropdown;

    public void selectDOB(String dob) {
        click(dobField);

        String[] parts = dob.split("/");
        String month = parts[0];   // 03
        String day = parts[1];     // 11
        String year = parts[2];    // 2026

        selectMonthFromHiddenDropdown(month);
        selectYearFromHiddenDropdown(year);

        String formattedDate = Integer.parseInt(month) + "/" + Integer.parseInt(day) + "/" + year;
        click(driver.findElement(By.xpath("//button[@data-day='" + formattedDate + "']")));

    }

    public void selectMonthFromHiddenDropdown(String month) {
        String monthValue = String.valueOf(Integer.parseInt(month) - 1);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                monthDropdown,
                monthValue);

    }

    public void selectDay(String month, String day, String year) {
        String formattedDate = Integer.parseInt(month) + "/" + Integer.parseInt(day) + "/" + year;



        WebElement dayButton = driver.findElement(By.xpath("//button[@data-day='" + formattedDate + "']"));

        waitForElementToBeClickable(dayButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dayButton);

    }

    public void selectYearFromHiddenDropdown(String year) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                yearDropdown,
                year
        );
    }


    public String getMonthText(String month) {
        switch (month) {
            case "01": return "Jan";
            case "02": return "Feb";
            case "03": return "Mar";
            case "04": return "Apr";
            case "05": return "May";
            case "06": return "Jun";
            case "07": return "Jul";
            case "08": return "Aug";
            case "09": return "Sep";
            case "10": return "Oct";
            case "11": return "Nov";
            case "12": return "Dec";
            default: throw new IllegalArgumentException("Invalid month: " + month);
        }
    }


    public void selectGender(String gender) {
        waitForElementToBeClickable(maleButton);
        switch (gender.trim().toLowerCase()) {
            case "male":
                click(maleButton);
                break;
            case "female":
                click(femaleButton);
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }
    @FindBy (xpath = "//label[text()='Male']/preceding-sibling::button")
    public WebElement maleButton;

    @FindBy (xpath = "//label[text()='Female']/preceding-sibling::button")
    public WebElement femaleButton;

    @FindBy (xpath = "//label[text()='Hispanic']/following-sibling::button")
    public WebElement hispanicDropdown;

    @FindBy(xpath = "//label[text()='Hispanic']/following-sibling::select")
    public WebElement hispanicSelect;

    public void selectHispanic(String hispanic){
        //click(hispanicDropdown);

        //WebElement hispanicSelect = driver.findElement(By.xpath("//label[text()='Hispanic']/following-sibling::select/option[@value='" + hispanic + "']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                hispanicSelect,
                hispanic);
    }


    @FindBy (xpath = "//label[text()='Race']/following-sibling::button")
    public WebElement raceDropdown;

    @FindBy (xpath = "//label[text()='Race']/following-sibling::select")
    public WebElement raceSelect;

    public void selectRace(String race){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                raceSelect,
                race);
    }

    @FindBy (id = "//label[text()='Other stay']/following-sibling::button")
    public WebElement otherStayDropdown;

    @FindBy (xpath = "//label[text()='Other stay']/following-sibling::select")
    public WebElement otherStaySelect;

    public void selectOtherStay(String otherStay){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                otherStaySelect,
                otherStay);

    }

    @FindBy (xpath = "//button[text()='Update']")
    public WebElement updateButton;

    @FindBy (xpath = "//p[contains(text(),'Successfully saved new record')]")
    public WebElement messageConfirmation;

    public String getConfirmationText(String confirmation){
        return messageConfirmation.getText();
    }

    public void selectRelationship(String relationship) {

        Select select = new Select(relationshipDropdown);
        select.selectByVisibleText(relationship);

    }

    public void createMember(String relationship,
                             String firstName,
                             String lastName,
                             String dob,
                             String gender,
                             String hispanic,
                             String race,
                             String otherStay) {

        click(dashboardPage.addRecordButton);

        selectRelationship(relationship);

        sendText(firstName, firstNameField);
        sendText(lastName, lastNameField);

        selectDOB(dob);

        selectGender(gender);

        selectHispanic(hispanic);
        selectRace(race);
        selectOtherStay(otherStay);

        click(updateButton);

    }

    public AddHouseholdMemberModal(){
        PageFactory.initElements(driver,this);
    }
}
