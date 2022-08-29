import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class GoogleTest {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='W0wltc']/div")).click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Google"));
        driver.findElement(By.name("q")).sendKeys("dogs");

        WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        el.click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='rso']//span/em"));
        for (WebElement i : elements) {
            if(i.getText()!=null)
            {
                Assert.assertTrue((i.getText().toUpperCase()).contains("DOG"));}
        }
        driver.quit();}
}
