import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.util.converter.NumberStringConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.SystemClock;

import java.nio.charset.IllegalCharsetNameException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class StepDefinition {
    String dropdownName = "Cell Phones & Accessories";
    String dropdownPrice = "Price: highest first";
    String whatCountry = "From Germany";

    WebDriver driver = null;

    @Given("^I want to go to ebay page$")
    public void OpenEbayPage() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\medinao\\Desktop\\SeleniumCCTests\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/");
    }

    @When("^I click on All Categories dropdown ,select product and I want to search for it$")
    public void SearchForProductInAllCategoriesDropdown() throws Throwable {
        Select DropdownSearch = new Select(driver.findElement(By.name("_sacat")));
        DropdownSearch.selectByVisibleText(dropdownName);
        driver.findElement(By.id("gh-btn")).click();
    }

    @When("^we validate that we are on a rigt page and click on link for Cell phone and smartphone$")
    public void titleValidationAndSelectingCellphone() throws Throwable {
        if (!driver.getTitle().equalsIgnoreCase("Cell Phones - Smartphones & Mobile Accessories - New & Used | eBay")) {
            throw new IllegalCharsetNameException("You are not on right page");
        }

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/ul/div/li[1]/ul/li[4]/a")).click();

    }

    @When("^we select brand apple$")
    public void SelectingBrand() throws Throwable {

        driver.findElement(By.id("e1-32")).click();

    }

    @Then("^validate that we are on right tab$")
    public void validateRightTab() throws Throwable {

        if (!driver.getTitle().equalsIgnoreCase("Apple Smartphones | eBay")) {
            throw new IllegalCharsetNameException("You are not on right page");
        }

    }

    @When("^we are on apple page select by sorting higest price from first page$")
    public void SelectHighestPrice() throws Throwable {

        driver.findElement(By.cssSelector("div#DashSortByContainer ul.sel > li > a")).click();
        driver.findElement(By.cssSelector("ul#SortMenu li:nth-child(5) > a")).click();

    }

    @When("^find lowest price from Canada$")
    public void find_lowest_price_from_Canada() throws Throwable {

        List<WebElement> ttN = driver.findElements(By.xpath("//*[@id=\"ListViewInner\"]"));
        WebElement element = null;
        //WebElement count = null;
        for (WebElement div : ttN)

        {
            NumberFormat format = NumberFormat.getCurrencyInstance();
            List<WebElement> elements = div.findElements(By.cssSelector("li.sresult.lvresult.clearfix.li"));

            String priceSelector = "ul.lvprices.left.space-zero > li.lvprice.prc";
            String countryclass = "ul.lvdetails.left.space-zero.full-width";

            for (WebElement pr : elements) {
                List<WebElement> cntr = pr.findElements(By.cssSelector(countryclass));
                for (WebElement cn : cntr) {
                    String country = String.valueOf(cn.getText());
                    Number number = format.parse(String.valueOf(pr.findElement(By.cssSelector(priceSelector)).getText()));
                    int price = number.intValue();
                    if (element == null) {
                        element = pr;
                    }
                    int newNumber = format.parse(String.valueOf(element.findElement(By.cssSelector(priceSelector)).getText())).intValue();
                    try {
                        if (price < newNumber && country.contains(whatCountry)) {

                            element = pr;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        try {
            driver.findElement(By.cssSelector("#" + element.getAttribute("id") + " > h3 > a")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^validate that we are on right page$")
    public void WeAreOnRightPage() throws Throwable {
        WebElement title = driver.findElement(By.cssSelector("#itemTitle"));
        String ttl = String.valueOf(title.getText());


        if (driver.getTitle().contains(ttl)) {
            System.out.println(ttl);
        } else {
            throw new IllegalCharsetNameException("You are not on right page");
        }


    }

}

