package Base;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pages.TestingTasksPage;
import utility.Constants;

public class BaseTestingTasks extends BaseTest {

    protected TestingTasksPage page;

    @BeforeClass(alwaysRun = true)
    protected void createPage() {
        if (!Constants.TEST_URL.equals(driver.getCurrentUrl())) {
            driver.get(Constants.TEST_URL);
            driver.manage().window().maximize();
            waitSeconds(5);
        }
        page = new TestingTasksPage(driver);
    }

    protected void checkTaskResult(String taskResult) {
        String msg = "Answer text block is empty. Possibly \"Check Results\" button didn't pushed";
        Assert.assertFalse(taskResult.isEmpty(), msg);
        Assert.assertFalse(taskResult.contains(Constants.NOT_OK_ANSWER));
    }
}
