package TestingTasksTests;

import Base.BaseTest;
import org.testng.annotations.Test;
import utility.Constants;

public class OtherEvenTasks extends BaseTest {

    // Tenth Task
    @Test
    public void redBoxTextTest() {
        logger.info("Get Red Box text");
        String text = page.getRedBoxText();

        logger.info("Set received text to Answer #10");
        page.setAnswerValue(text, 10);

        logger.info("Click \"Check results\" button");
        page.pushCheckResults();

        logger.info("Checking test result");
        checkTaskResult(page.getTaskResult(10));

        logger.info("Test PASSED");
    }

    // Twelfth Task
    @Test
    public void browserWindowCanChangeHeightWidthTest() {
        page.setBrowserWidth(850);
        page.setBrowserHeight(650);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(12));
    }

    // Fourteenth Task
    @Test
    public void purpleBoxVisibilityTest() {
        String result = page.isPurpleBoxVisible() ? Constants.YES : Constants.NO;
        page.setAnswerValue(result, 14);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(14));
    }
}














