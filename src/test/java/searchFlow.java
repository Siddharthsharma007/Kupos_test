import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class searchFlow {

    @SneakyThrows
    public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://newstg3-ssrdweb.kupos.cl/en");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            driver.findElement(By.xpath("//*[@id=\"react-select-:r1:-input\"]")).sendKeys("buen"+ Keys.ENTER+"pue"+ Keys.ENTER);
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div[2]/div[2]/div/div/div[3]/div/div[5]/button")).click();
            driver.findElement(By.xpath("(//*[@class='kupos-button_kupos_button__MM3z5 kupos-button'])[1]")).click();
            driver.findElement(By.xpath("//*[@class='kupos-button2']")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='common-kupos-select-box-outer'])[3]")));
            dropdown.click();

            List<WebElement> options = dropdown.findElements(By.xpath("//div[@class='auto-suggestions font10 scroll-style ']//a"));
            options.get(1).click();

            List<WebElement> optionsnew = dropdown.findElements(By.xpath("//div[@class='index_coach_table__zXLYy coach-table light-text']//ul/li"));
            System.out.println("Total options: " + optionsnew.size());
            ((JavascriptExecutor)driver).executeScript("window.scrollTo({ down: 300, behavior: 'smooth' })");
            Thread.sleep(10);
            optionsnew.get(19).click();
            WebDriverWait waitn = new WebDriverWait(driver, Duration.ofSeconds(10));
            By buttonLocator = By.xpath("(//*[@class='kupos-button_kupos_button__MM3z5 kupos-button'])[2]");
            WebElement button = waitn.until(ExpectedConditions.elementToBeClickable(buttonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);


    }
}
