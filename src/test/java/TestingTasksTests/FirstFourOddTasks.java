package TestingTasksTests;

import Base.BaseTestingTasks;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utility.Constants;
import org.testng.annotations.Test;

public class FirstFourOddTasks extends BaseTestingTasks {

    // (1)
    // First task
    @Test
    public void grabTitlePlaceTextToInputTest() {
        page.setAnswerValue(page.getTitle(), 1);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(1));
    }

    // (2)
    // Third task
    @Test
    public void setOccupationSciFiAuthorTest() {
        try {
            page.selectOccupationValue(Constants.SCI_FI_AUTHOR);
            page.pushCheckResults();
            checkTaskResult(page.getTaskResult(3));
        } catch (NoSuchElementException e) {
            Assert.fail(e.getMessage());
        }
    }

    // (3)
    // Fifth Task
    @Test
    public void checkClickMeLinkTest() {
        page.clickClickMeLink();
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(5));
    }

    // (4)
    // Seventh Task
    @Test
    public void checkRanThisJSFunctionTest() {
        try {
            page.executeJSFunctionRanThisJSFunction();
            page.pushCheckResults();
            checkTaskResult(page.getTaskResult(7));
        } catch (JavascriptException e) {
            Assert.fail(e.getMessage());
        }
    }
}















