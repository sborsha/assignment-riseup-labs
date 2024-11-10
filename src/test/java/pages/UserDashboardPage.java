package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class UserDashboardPage {

    WebDriver driver;

    @FindBy( xpath = "//span[normalize-space()='Total Rows: 5']")
    public WebElement rowCount;

    @FindBy(tagName = "tbody")
    public WebElement table;

    @FindBy(className = "add-cost-button")
    public WebElement btnAddCost;

    @FindBy( xpath = "//div[@class='summary']/span")
    public List<WebElement> txtCost;

    @FindBy( className = "search-input")
    public WebElement txtSearch;

    @FindBy( tagName = "tbody")
    public WebElement tableBody;

    public UserDashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void assertTotalCost(int totalSum) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(table));

       // Thread.sleep(1000);
        String str = txtCost.get(1).getAttribute("innerText");
        System.out.println(str);
        System.out.println(totalSum);
        str = str.replaceAll("[^\\d]", "");
        int actualPrice = Integer.parseInt(str);
        Assert.assertEquals(actualPrice,totalSum);

    }

    public void searchItem() throws InterruptedException {
       txtSearch.sendKeys("Rice");
       // Thread.sleep(2000);
        WebElement dataRow = tableBody.findElements(By.tagName("tr")).get(0);
        String expectedTotalPrice = dataRow.findElements(By.tagName("td")).get(2).getText();
        System.out.println(expectedTotalPrice);
        //Thread.sleep(2000);
        String str = txtCost.get(1).getAttribute("innerText");
        //System.out.println(str);
        String actualTotalPrice = str.replaceAll("[^\\d]", "");
        //int actualPrice = Integer.parseInt(str);
        Assert.assertEquals(actualTotalPrice,expectedTotalPrice);


    }


}
