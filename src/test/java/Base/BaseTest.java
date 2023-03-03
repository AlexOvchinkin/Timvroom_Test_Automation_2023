package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.TestingTasksPage;
import utility.BrowserDriverFactory;
import org.openqa.selenium.WebDriver;
import utility.Constants;

import java.time.Duration;

public class BaseTest {

    private BrowserDriverFactory factory;
    protected static WebDriver driver;
    protected Logger logger;
    protected TestingTasksPage page;

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) {
        factory = new BrowserDriverFactory(browser);
        driver = factory.getInstance();
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        // for educational purposes
        waitForWatchResults(10);

        factory.quitDriver();
    }


    @BeforeClass(alwaysRun = true)
    protected void createPage() {
        logger = LogManager.getLogger(getClass());
        page = new TestingTasksPage(driver);

        if (!Constants.TEST_URL.equals(driver.getCurrentUrl())) {
            driver.get(Constants.TEST_URL);
            driver.manage().window().maximize();
            waitSeconds(5);
        }
    }

    protected void checkTaskResult(String taskResult) {
        String msg = "Answer text block is empty. Possibly \"Check Results\" button wasn't pushed";
        Assert.assertFalse(taskResult.isEmpty(), msg);
        Assert.assertFalse(taskResult.contains(Constants.NOT_OK_ANSWER), "Test FAIL");
    }

    protected void waitSeconds(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    protected void waitForWatchResults(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}















