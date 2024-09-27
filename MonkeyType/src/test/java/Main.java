import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://monkeytype.com/");

        List<WebElement> wordsList =driver.findElements(By.xpath("//div[@class='word active']/letter"));
        WebElement input=driver.findElement(By.id("wordsInput"));

        List<String> words = wordsList.stream()
                .map(WebElement::getText)
                .toList();
        while (!words.isEmpty()){

          for (String word:words){
              input.sendKeys(word);
          }

          input.sendKeys(" ");
          wordsList =driver.findElements(By.xpath("//div[@class='word active']/letter"));
            words = wordsList.stream()
                    .map(WebElement::getText)
                    .toList();

        }

    }
}
