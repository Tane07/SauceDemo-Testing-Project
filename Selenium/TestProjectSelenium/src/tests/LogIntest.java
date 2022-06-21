package tests;

import org.junit.Test;


import pages.HomePage;
import pages.LoginPage;

public class LogIntest extends BaseTest {
    public LoginPage loginPage;
    public HomePage homePage;
    String homePageTitle = "PRODUCTS";
    String lockedUsername = "locked_out_user";
    String invalidUser = "invalid username";
    String invalidPass = "invalid password";

    String error_messagelockedUsername = "Epic sadface: Sorry, this user has been locked out.";
    String error_messageinvalidUser = "Epic sadface: Username and password do not match any user in this service";
    String error_messageinvalidPass = "Epic sadface: Username and password do not match any user in this service";
    String error_messageemptyUsername = "Epic sadface: Username is required";
    String error_messageemptyPassword = "Epic sadface: Password is required";
@Test
public void verifyValidUserLogin () {
    loginPage = new LoginPage(driver);
    homePage = new HomePage (driver);
    
    loginPage.basePage ();
    loginPage.login(validUsername, validPassword);
    homePage.verifyLogin(homePageTitle);
}

@Test
public void verifyLockedUserLogin () {
    loginPage = new LoginPage(driver);
    
    
    loginPage.basePage ();
    loginPage.login(lockedUsername, validPassword);
    loginPage.verifyUnsuccessfulLogin(error_messagelockedUsername);
 
}

@Test
public void invalidUser () {
    loginPage = new LoginPage(driver);
    
    
    loginPage.basePage ();
    loginPage.login(invalidUser, validPassword);
    loginPage.verifyUnsuccessfulLogin(error_messageinvalidUser);
 
}

@Test
public void verifyInvalidPassword () {
    loginPage = new LoginPage(driver);
    
    
    loginPage.basePage ();
    loginPage.login(validUsername, invalidPass);
    loginPage.verifyUnsuccessfulLogin(error_messageinvalidPass);
}

@Test
public void verifyblankUsername () {
    loginPage = new LoginPage(driver);
    
    
    loginPage.basePage ();
    loginPage.login("", validPassword);
    loginPage.verifyUnsuccessfulLogin(error_messageemptyUsername);
}


@Test
public void verifyblankPassword () {
    loginPage = new LoginPage(driver);
    
    
    loginPage.basePage ();
    loginPage.login(validUsername, "");
    loginPage.verifyUnsuccessfulLogin(error_messageemptyPassword);
}
}