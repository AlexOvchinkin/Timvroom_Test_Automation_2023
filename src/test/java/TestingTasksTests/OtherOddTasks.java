package TestingTasksTests;

import Base.BaseTestingTasks;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utility.Constants;

import java.time.Duration;

public class OtherOddTasks extends BaseTestingTasks {

    // Ninth Task
    @Test
    public void writeBookYesTest() {
        page.selectWrittenBookRadioBtn("Yes");
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(9));
    }

    // Eleventh Task
    @Test
    public void greenOrangeBoxesWhichOneIsHigherTest() {
        String box = page.getYPosOrangeBox() > page.getYPosGreenBox()
                ? Constants.GREEN
                : Constants.ORANGE;
        page.setAnswerValue(box, 11);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(11));
    }

    // Thirteenth Task
    @Test
    public void checkIfIsHereLocatedOnThePageTest() {
        String located = page.isIsHereLocated() ? Constants.YES : Constants.NO;
        page.setAnswerValue(located, 13);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(13));
    }

    // Fifteenth and Sixteenth Tasks
    @Test
    public void clickThenWaitAndClickAfterWaitTest() {
        page.clickClickThenWaitLink();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.getClickAfterWaitLocator()));

        page.clickClickAfterWaitLink();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        page.pushCheckResults();

        checkTaskResult(page.getTaskResult(15));
        checkTaskResult(page.getTaskResult(16));
    }

    // Seventeenth Task
    @Test
    public void btnSubmitTest() {
        page.pushSubmitBtn();
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(17));
    }

}















