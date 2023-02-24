package utility;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserDriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver getInstance() {
        // if (driver.get() == null) {
        switch (browser) {
            case "chrome" -> {
                System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_PATH);
                driver.set(new ChromeDriver());
            }
            case "safari" -> driver.set(new SafariDriver());
        }
        // }

        return driver.get();
    }

    public void quitDriver() {
        // try ... catch -> for Safari
        try {
            driver.get().close();
            driver.get().quit();
        } catch (NoSuchSessionException e) {
            try {
                Thread.sleep(5000);
                driver.get().quit();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

        driver.remove();
    }
}






























