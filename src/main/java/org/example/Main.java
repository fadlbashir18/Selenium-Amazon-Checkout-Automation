package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Main {
    /*
        This method is called when a new page or window is loaded after a button click
        (ie. after clicking the proceed to checkout button on Amazon, a new checkout page is displayed),
        therefore we need this method to switch the driver into the new window. It takes in a webdriver object and
        a Set of all windows in the current session, return a WebDriver object that is switched to the current window.
     */
    public static WebDriver switchPage(WebDriver driver, Set<String> windowHandles){
        for(String windowId : windowHandles){
            driver.switchTo().window((windowId));
        }
        return driver;
    }
    public static void main(String[] args) throws InterruptedException {
        //Create Chrome driver's instance
        WebDriver driver = new ChromeDriver();

        //Launch amazon login
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%3Fpd_rd_w%3DvFVFC%26content-id%3Damzn1.sym.80f55c46-3037-42ea-9b77-ed938babf4c3%3Aamzn1.sym.80f55c46-3037-42ea-9b77-ed938babf4c3%26pf_rd_p%3D80f55c46-3037-42ea-9b77-ed938babf4c3%26pf_rd_r%3DP467K32BMXK9X7RD20HD%26pd_rd_wg%3DkhtYp%26pd_rd_r%3D72c89a28-043d-4d5b-8f46-34082d574ad6%26qid%3D1708305097%26ref%3Dsxts_aspa_qna%26c_c%3D-312414675&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        Thread.sleep(15000);

        //Email login
        driver.findElement(By.id("ap_email")).sendKeys("");
        driver.findElement(By.id("continue")).click();

        //Creating the set and switching windows
        Set<String> windowHandles = driver.getWindowHandles();
        driver = switchPage(driver, windowHandles);

        //Password login on new window
        driver.findElement(By.id("ap_password")).sendKeys("");
        driver.findElement(By.id("signInSubmit")).click();

        //Page switch again after logging in
        driver = switchPage(driver, windowHandles);

        //Searching for the product we need to add to cart
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("");
        driver.findElement(By.id("nav-search-submit-button")).click();

        //Switching to new window after clicking search
        driver = switchPage(driver, windowHandles);

        //Locating product we need buy ID
        driver.findElement(By.id("a-autoid-5-announce")).click();
        Thread.sleep(5000);

        //Proceeding to cart and then checkout page
        driver.findElement(By.id("nav-cart")).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();

        Thread.sleep(10000);
        driver.close();
    }
}
