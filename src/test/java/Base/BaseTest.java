package Base;

import org.testng.annotations.*;
import utility.BrowserDriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

    private BrowserDriverFactory factory;
    protected static WebDriver driver;

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















