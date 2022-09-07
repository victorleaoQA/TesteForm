import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{
    private final String FIRST_NAME = "Victor";
    private final String LAST_NAME = "Leao";

    private final String JOB_TITLE = "Marinheiro";

    @FindBy(id = "first-name")
    private WebElement first_name;

    @FindBy(id = "last-name")
    private WebElement last_name;

    @FindBy(id = "job-title")
    private WebElement job_title;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement submit_button;


    @FindBy(xpath = "//div[contains(text(),'The form was successfully submitted!')]")
    private WebElement alertSuccess;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(){
        this.first_name.sendKeys(FIRST_NAME);
    }

    public void enterLastName(){
        this.last_name.sendKeys(LAST_NAME);
    }

    public void enterJobTitle(){
        this.job_title.sendKeys(JOB_TITLE);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void verifyAlertSuccess(){
        this.alertSuccess.isDisplayed();
    }
}
