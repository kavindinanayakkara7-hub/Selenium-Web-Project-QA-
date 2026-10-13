import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final String BASE_URL =
            "https://www.demoblaze.com/";

    protected static final String SAMSUNG =
            "Samsung galaxy s6";

    protected static final String NOKIA =
            "Nokia lumia 1520";


    @BeforeMethod
    public void setUp() {

        System.out.println("--------------------------------");
        System.out.println("Starting Test");

        ChromeOptions options = new ChromeOptions();

        // Page does not need to wait for every resource to finish
        options.setPageLoadStrategy(
                org.openqa.selenium.PageLoadStrategy.EAGER
        );

        driver = new ChromeDriver(options);

        // Maximum time allowed for page loading
        driver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30));

        // Maximum time for scripts
        driver.manage()
                .timeouts()
                .scriptTimeout(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        // Explicit wait
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        System.out.println("Opening DemoBlaze...");
        //open demoblaze
        driver.get(BASE_URL);

        System.out.println(
                "Page opened successfully"
        );

        System.out.println(
                "Page Title: " + driver.getTitle()
        );

        System.out.println(
                "Current URL: " + driver.getCurrentUrl()
        );

        System.out.println("Setup completed");
        System.out.println("--------------------------------");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        System.out.println("Cleaning up browser...");

        if (driver != null) {

            try {
                driver.quit();

            } catch (Exception e) {

                System.out.println(
                        "Browser cleanup error: "
                                + e.getMessage()
                );
            }
        }

        System.out.println("Browser closed");
        System.out.println("--------------------------------");
    }
}