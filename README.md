README
Selenium Amazon Checkout Automation

This Java program utilizes Selenium WebDriver to automate the checkout process on Amazon. It simulates the steps a user might take to log in, search for a product, add it to the cart, and proceed to the checkout page.
Code Overview

    The program launches a Chrome WebDriver instance and navigates to the Amazon login page.
    It waits for the user to manually input their email and password for authentication.
    After successful login, it searches for a specific product ("Tozo T10") and adds it to the cart.
    Finally, it proceeds to the checkout page before closing the browser.

Method Explanation

    switchPage(WebDriver driver, Set<String> windowHandles): This method switches the WebDriver to a newly opened window or tab after a button click event (e.g., clicking "proceed to checkout"). It takes in the current WebDriver instance and a Set of window handles and returns the WebDriver switched to the new window.

Usage

    Ensure you have the necessary WebDriver executable (e.g., ChromeDriver) set up in your environment.
    Modify the code to include your Amazon login credentials.
    Run the program and observe the automation of the checkout process.
