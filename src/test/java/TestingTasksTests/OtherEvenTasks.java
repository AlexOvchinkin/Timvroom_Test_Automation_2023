package TestingTasksTests;

import Base.BaseTestingTasks;
import org.testng.annotations.Test;
import utility.Constants;

public class OtherEvenTasks extends BaseTestingTasks {

    // Tenth Task
    @Test
    public void redBoxTextTest() {
        String text = page.getRedBoxText();
        page.setAnswerValue(text, 10);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(10));
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














