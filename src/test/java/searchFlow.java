import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class searchFlow {

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
        for (WebElement option : options) {
            if (option.getText().equals("Plazuela Buin - 00:15")) {
                option.click();
                break;
            }
        }

        List<WebElement> optionsnew = dropdown.findElements(By.xpath("//div[@class='index_coach_table__zXLYy coach-table light-text']//ul/li"));

        System.out.println("Total options: " + optionsnew.size());

        // Find already selected element (if any)
        WebElement selectedElement = null;
        for (WebElement option : optionsnew) {
            if (option.getAttribute("class").contains("selected")) { // Adjust based on actual class name
                selectedElement = option;
                break;
            }
        }

        // Find an unselected element
        for (WebElement option : optionsnew) {
            if (selectedElement == null || !option.equals(selectedElement)) {
                System.out.println("Clicking on: " + option.getText());
                option.click();
                break;
            }
        }

        driver.findElement(By.xpath("(//*[@class='kupos-button_kupos_button__MM3z5 kupos-button'])[2]")).click();


    }
}
