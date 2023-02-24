package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utility.Constants;

import java.util.List;

public class TestingTasksPage {

    private final WebDriver driver;

    private final By btnCheckResultsLocator = By.id("checkresults");
    private final By nameLocator = By.id("name");
    private final By occupationLocator = By.id("occupation");
    private final By linkClickMeLocator = By.xpath(".//a[text()='click me']");
    private final By blueBoxLocator = By.xpath("//span[text()='Blue Box']");
    private final By redBoxLocator = By.id("redbox");
    private final By wroteBookRadioLocator = By.xpath("//input[@value='wrotebook']");
    private final By didntWriteBookRadioLocator = By.xpath("//input[@value='didntwritebook']");
    private final By greenBoxLocator = By.id("greenbox");
    private final By orangeBoxLocator = By.id("orangebox");
    private final By isHereLocator = By.id("ishere");
    private final By clickThenWaitLocator = By.xpath(".//a[text()='click then wait']");
    private final By clickAfterWaitLocator = By.xpath(".//a[text()='click after wait']");
    private final By btnSubmitLocator = By.id("submitbutton");
    private final By purpleBoxLocator = By.id("purplebox");


    public TestingTasksPage(WebDriver driver) {
        this.driver = driver;
    }

    private int getYPosOfElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getLocation().getY();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setNameValue(String text) {
        driver.findElement(nameLocator).sendKeys(text);
    }

    public void selectOccupationValue(String occupation) throws NoSuchElementException {
        Select drpOccupation = new Select(driver.findElement(occupationLocator));
        drpOccupation.selectByVisibleText(occupation);
    }

    public void clickClickMeLink() {
        driver.findElement(linkClickMeLocator).click();
    }

    public void executeJSFunctionRanThisJSFunction() throws JavascriptException {
        ((JavascriptExecutor)driver).executeScript("ran_this_js_function();");
    }

    public int getBlueBoxesNumber() {
        List<WebElement> blueBoxes = driver.findElements(blueBoxLocator);
        return blueBoxes.size();
    }

    public String getRedBoxClassName() {
        return driver.findElement(redBoxLocator).getAttribute("class");
    }

    public String getRedBoxText() {
        return driver.findElement(redBoxLocator).getText();
    }

    public String getResultFromJSFunction() throws JavascriptException {
        Object value = ((JavascriptExecutor)driver).executeScript("return got_return_from_js_function();");
        return value.toString();
    }

    public void selectWrittenBookRadioBtn(String yesNo) {
        if (yesNo.equalsIgnoreCase(Constants.YES)) {
            driver.findElement(wroteBookRadioLocator).click();
        } else {
            driver.findElement(didntWriteBookRadioLocator).click();
        }
    }

    public int getYPosGreenBox() {
        return getYPosOfElement(greenBoxLocator);
    }

    public int getYPosOrangeBox() {
        return getYPosOfElement(orangeBoxLocator);
    }

    public boolean isIsHereLocated() throws NoSuchElementException {
        return driver.findElements(isHereLocator).size() > 0;
    }

    public void clickClickThenWaitLink() {
        driver.findElement(clickThenWaitLocator).click();
    }

    public void clickClickAfterWaitLink() {
        driver.findElement(clickAfterWaitLocator).click();
    }

    public By getClickAfterWaitLocator() {
        return clickAfterWaitLocator;
    }

    public void setBrowserHeight(int height) {
        Dimension dimension = driver.manage().window().getSize();
        Dimension newDimension = new Dimension(dimension.getWidth(), height);
        driver.manage().window().setSize(newDimension);
    }

    public void setBrowserWidth(int width) {
        Dimension dimension = driver.manage().window().getSize();
        Dimension newDimension = new Dimension(width, dimension.getHeight());
        driver.manage().window().setSize(newDimension);
    }

    public boolean isPurpleBoxVisible() {
        return driver.findElement(purpleBoxLocator).isDisplayed();
    }

    public void pushSubmitBtn() {
        driver.findElement(btnSubmitLocator).click();
    }

    public void pushCheckResults() {
        driver.findElement(btnCheckResultsLocator).click();
    }

    public String getTaskResult(int taskNumber) {
        By taskLocator = By.id("ok_" + taskNumber);
        return driver.findElement(taskLocator).getText();
    }

    public void setAnswerValue(String value, int answerNumber) {
        By answerLocator = By.id("answer" + answerNumber);
        driver.findElement(answerLocator).sendKeys(value);
    }
}
















