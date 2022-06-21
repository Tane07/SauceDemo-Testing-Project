package pages;

import javax.management.openmbean.OpenMBeanInfoSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By headerTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By numberOfItemsBy = By.xpath("//*[@class='inventory_item']");
    By menuIconBy = By.id("react-burger-menu-btn");

    public HomePage verifyLogin (String expectedText){
        String pageTitle = readText (headerTitleBy);
        assertStringEquals(pageTitle, expectedText);
        return this;
    }

    public HomePage validateNumberOfProducts(int expectedNumberOfProducts){
        int actuallNumberofProducts = locateElements(numberOfItemsBy).size();
        assertIntegerEquals(expectedNumberOfProducts, actuallNumberofProducts);
        return this;

    }

    public HomePage openMenuBy(){
        click(menuIconBy);
    }





    
}
