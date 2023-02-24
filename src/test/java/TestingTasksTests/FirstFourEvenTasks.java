package TestingTasksTests;

import Base.BaseTestingTasks;
import org.openqa.selenium.JavascriptException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstFourEvenTasks extends BaseTestingTasks {

    // (1)
    // Second Task
    @Test
    public void setTextToNameTest() {
        page.setNameValue("Kilgore Trout");
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(2));
    }

    // (2)
    // Forth Task
    @Test
    public void numberOfBlueBoxesTest() {
        int blueBoxesNumber = page.getBlueBoxesNumber();
        page.setAnswerValue(Integer.toString(blueBoxesNumber), 4);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(4));
    }

    // (3)
    // Sixth Task
    @Test
    public void redBoxTest() {
        page.setAnswerValue(page.getRedBoxClassName(), 6);
        page.pushCheckResults();
        checkTaskResult(page.getTaskResult(6));
    }

    // (4)
    // Eighth Task
    @Test
    public void gotReturnFromJSFunctionTest() {
        try {
            page.setAnswerValue(page.getResultFromJSFunction(), 8);
            page.pushCheckResults();
            checkTaskResult(page.getTaskResult(8));
        } catch (JavascriptException e) {
            Assert.fail(e.getMessage());
        }
    }
}













