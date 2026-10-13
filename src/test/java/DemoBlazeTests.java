import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DemoBlazeTests extends BaseTest {

    // =========================================================
    // TC01 - HOME PAGE SMOKE TEST
    // =========================================================

    @Test
    public void TC01_HomePageSmokeTest() {

        System.out.println("\nTC01 - Home Page Smoke Test");

        // Get page title
        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        // Verify title is not empty
        Assert.assertFalse(
                title == null || title.trim().isEmpty(),
                "Page title should not be empty"
        );

        // Verify PRODUCT STORE heading
        WebElement productStore = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(normalize-space(),'PRODUCT STORE')]")
                )
        );

        Assert.assertTrue(
                productStore.isDisplayed(),
                "PRODUCT STORE heading should be displayed"
        );

        System.out.println("PRODUCT STORE is displayed");

        // Verify Phones category
        WebElement phones = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        );

        Assert.assertTrue(
                phones.isDisplayed(),
                "Phones category should be displayed"
        );

        System.out.println("Phones category is displayed");

        System.out.println("TC01 PASSED");
    }


    // =========================================================
    // TC02 - PRODUCT SELECTION
    // =========================================================

    @Test
    public void TC02_ProductSelection() {

        System.out.println("\nTC02 - Product Selection");

        // Click Phones category
        WebElement phones = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        );

        phones.click();

        // Wait for Samsung Galaxy S6
        WebElement samsung = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        );

        Assert.assertTrue(
                samsung.isDisplayed(),
                "Samsung galaxy s6 should be displayed"
        );

        // Click Samsung
        samsung.click();

        // Verify product heading
        WebElement productHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//h2[normalize-space()='Samsung galaxy s6']"
                        )
                )
        );

        String productName = productHeading.getText();

        System.out.println(
                "Product Name: " + productName
        );

        Assert.assertEquals(
                productName,
                SAMSUNG,
                "Wrong product name"
        );

        // Get product price
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[@class='price-container']")
                )
        );

        String priceText = price.getText();

        System.out.println(
                "Samsung Galaxy S6 Price: " + priceText
        );

        Assert.assertFalse(
                priceText.trim().isEmpty(),
                "Product price should not be empty"
        );

        System.out.println("TC02 PASSED");
    }


    // =========================================================
    // TC03 - ADD TO CART AND ALERT
    // =========================================================

    @Test
    public void TC03_AddToCartAndAlert() {

        System.out.println("\nTC03 - Add To Cart");

        // Open Phones
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        // Select Samsung
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        ).click();

        // Wait for Add to Cart
        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        );

        // Click Add to Cart
        addToCart.click();

        // Wait for JavaScript alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        // Get alert
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        System.out.println(
                "JavaScript Alert: " + alertText
        );

        // Verify alert message
        Assert.assertFalse(
                alertText.trim().isEmpty(),
                "Alert message should not be empty"
        );

        // Accept alert
        alert.accept();

        System.out.println(
                "Alert accepted successfully"
        );

        System.out.println("TC03 PASSED");
    }


    // =========================================================
    // TC04 - CART MANAGEMENT
    // =========================================================

    @Test
    public void TC04_CartManagement() {

        System.out.println("\nTC04 - Cart Management");


        // =====================================================
        // ADD SAMSUNG GALAXY S6
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        ).click();

        // Accept Samsung alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        driver.switchTo().alert().accept();

        System.out.println(
                "Samsung galaxy s6 added to cart"
        );


        // =====================================================
        // RETURN TO HOME PAGE
        // =====================================================

        driver.get(BASE_URL);


        // =====================================================
        // ADD NOKIA LUMIA 1520
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Nokia lumia 1520']"
                        )
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        ).click();

        // Accept Nokia alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        driver.switchTo().alert().accept();

        System.out.println(
                "Nokia lumia 1520 added to cart"
        );


        // =====================================================
        // OPEN CART
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("cartur")
                )
        ).click();


        // =====================================================
        // WAIT FOR CART ROWS
        // =====================================================

        By cartRowsLocator =
                By.xpath("//tbody[@id='tbodyid']/tr");

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        cartRowsLocator,
                        1
                )
        );


        // =====================================================
        // FIND ALL CART ROWS
        // =====================================================

        List<WebElement> cartRows =
                driver.findElements(cartRowsLocator);

        System.out.println(
                "Cart Row Count: " + cartRows.size()
        );


        // Verify two products
        Assert.assertEquals(
                cartRows.size(),
                2,
                "Cart should contain two products"
        );


        // =====================================================
        // PRINT PRODUCT NAMES AND PRICES USING LOOP
        // =====================================================

        for (WebElement row : cartRows) {

            String rowText = row.getText();

            System.out.println(
                    "Cart Row: " + rowText
            );

            List<WebElement> columns =
                    row.findElements(By.tagName("td"));

            if (columns.size() >= 3) {

                String productName =
                        columns.get(1).getText();

                String productPrice =
                        columns.get(2).getText();

                System.out.println(
                        "Product: " + productName
                );

                System.out.println(
                        "Price: " + productPrice
                );
            }
        }


        // =====================================================
        // VERIFY SAMSUNG EXISTS
        // =====================================================

        WebElement samsungInCart =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//tbody[@id='tbodyid']/tr[td[normalize-space()='Samsung galaxy s6']]"
                                )
                        )
                );

        Assert.assertTrue(
                samsungInCart.isDisplayed(),
                "Samsung should exist in cart"
        );

        System.out.println(
                "Samsung galaxy s6 exists in cart"
        );


        // =====================================================
        // FIND NOKIA ROW
        // =====================================================

        WebElement nokiaRow =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//tbody[@id='tbodyid']/tr[td[normalize-space()='Nokia lumia 1520']]"
                                )
                        )
                );


        // =====================================================
        // DELETE NOKIA
        // =====================================================

        WebElement deleteNokia =
                nokiaRow.findElement(
                        By.xpath("./td[4]/a")
                );

        deleteNokia.click();

        System.out.println(
                "Nokia delete button clicked"
        );


        // =====================================================
        // IMPORTANT FIX
        // WAIT UNTIL ONLY ONE CART ROW REMAINS
        // =====================================================

        wait.until(
                ExpectedConditions.numberOfElementsToBe(
                        cartRowsLocator,
                        1
                )
        );


        // =====================================================
        // GET REMAINING CART ROWS
        // =====================================================

        List<WebElement> remainingRows =
                driver.findElements(cartRowsLocator);

        System.out.println(
                "Remaining Cart Rows: "
                        + remainingRows.size()
        );


        // =====================================================
        // VERIFY ONLY ONE PRODUCT REMAINS
        // =====================================================

        Assert.assertEquals(
                remainingRows.size(),
                1,
                "Only one product should remain"
        );


        // =====================================================
        // VERIFY SAMSUNG REMAINS
        // =====================================================

        WebElement remainingSamsung =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//tbody[@id='tbodyid']/tr[td[normalize-space()='Samsung galaxy s6']]"
                                )
                        )
                );

        Assert.assertTrue(
                remainingSamsung.isDisplayed(),
                "Samsung Galaxy S6 should remain"
        );

        System.out.println(
                "Samsung galaxy s6 remains in cart"
        );


        // =====================================================
        // GET CART TOTAL
        // =====================================================

        WebElement total =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.id("totalp")
                        )
                );

        String totalText =
                total.getText();

        System.out.println(
                "Cart Total: " + totalText
        );


        // Verify total is not empty
        Assert.assertFalse(
                totalText.trim().isEmpty(),
                "Cart total should not be empty"
        );


        // =====================================================
        // VERIFY TOTAL IS 360
        // =====================================================

        Assert.assertEquals(
                totalText,
                "360",
                "Cart total should be 360"
        );

        System.out.println(
                "Cart total verified: 360"
        );

        System.out.println("TC04 PASSED");
    }


    // =========================================================
    // TC05 - CHECKOUT VALIDATION
    // =========================================================

    @Test
    public void TC05_CheckoutValidation() {

        System.out.println("\nTC05 - Checkout Validation");


        // =====================================================
        // ADD SAMSUNG
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        ).click();


        // Accept alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        driver.switchTo().alert().accept();

        System.out.println(
                "Samsung galaxy s6 added to cart"
        );


        // =====================================================
        // OPEN CART
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("cartur")
                )
        ).click();


        // Wait for cart row
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//tbody[@id='tbodyid']/tr"
                        )
                )
        );


        // =====================================================
        // CLICK PLACE ORDER
        // =====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Place Order']"
                        )
                )
        ).click();


        // =====================================================
        // WAIT FOR ORDER MODAL
        // =====================================================

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("orderModal")
                )
        );


        System.out.println(
                "Place Order modal opened"
        );


        // =====================================================
        // INVALID CHECKOUT
        // =====================================================

        WebElement purchaseButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//button[normalize-space()='Purchase']"
                                )
                        )
                );


        // Click Purchase without entering mandatory data
        purchaseButton.click();


        // DemoBlaze uses JavaScript validation alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );


        Alert validationAlert =
                driver.switchTo().alert();


        String validationMessage =
                validationAlert.getText();


        System.out.println(
                "Invalid Validation Message: "
                        + validationMessage
        );


        // Verify validation message
        Assert.assertFalse(
                validationMessage.trim().isEmpty(),
                "Validation alert should contain a message"
        );


        // Accept validation alert
        validationAlert.accept();


        // =====================================================
        // ENTER VALID TEST DATA
        // =====================================================

        WebElement name =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.id("name")
                        )
                );

        name.clear();
        name.sendKeys("Test Student");


        WebElement country =
                driver.findElement(
                        By.id("country")
                );

        country.clear();
        country.sendKeys("Sri Lanka");


        WebElement city =
                driver.findElement(
                        By.id("city")
                );

        city.clear();
        city.sendKeys("Colombo");


        WebElement card =
                driver.findElement(
                        By.id("card")
                );

        card.clear();
        card.sendKeys("4111111111111111");


        WebElement month =
                driver.findElement(
                        By.id("month")
                );

        month.clear();
        month.sendKeys("12");


        WebElement year =
                driver.findElement(
                        By.id("year")
                );

        year.clear();
        year.sendKeys("2027");


        // =====================================================
        // VERIFY ENTERED DATA
        // =====================================================

        Assert.assertEquals(
                name.getAttribute("value"),
                "Test Student",
                "Name value is incorrect"
        );

        Assert.assertEquals(
                country.getAttribute("value"),
                "Sri Lanka",
                "Country value is incorrect"
        );

        Assert.assertEquals(
                city.getAttribute("value"),
                "Colombo",
                "City value is incorrect"
        );


        // =====================================================
        // CLICK PURCHASE
        // =====================================================

        purchaseButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//button[normalize-space()='Purchase']"
                                )
                        )
                );

        purchaseButton.click();


        // =====================================================
        // VERIFY SUCCESS MESSAGE
        // =====================================================

        WebElement successMessage =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//h2[normalize-space()='Thank you for your purchase!']"
                                )
                        )
                );


        Assert.assertTrue(
                successMessage.isDisplayed(),
                "Purchase success message should be displayed"
        );


        System.out.println(
                "Success Message: "
                        + successMessage.getText()
        );


        // =====================================================
        // PRINT PURCHASE CONFIRMATION
        // =====================================================

        WebElement confirmation =
                driver.findElement(
                        By.xpath(
                                "//div[contains(@class,'sweet-alert')]"
                        )
                );


        System.out.println(
                "Purchase Confirmation:"
        );

        System.out.println(
                confirmation.getText()
        );


        System.out.println("TC05 PASSED");
    }
}