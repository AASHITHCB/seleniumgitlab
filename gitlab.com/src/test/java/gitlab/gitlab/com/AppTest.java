package gitlab.gitlab.com;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AppTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ASHITH\\New folder\\gitlab.com\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
      driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGitlab() throws Exception {
    driver.get("https://gitlab.com/users/sign_in?__cf_chl_jschl_tk__=b69f7227516eaff7c5ad8ef256b42729fdd6154e-1608801582-0-AfDcvmyZWG0zQ-fKWuEGXe8IKzkiytHD0_-AhGGGrVfCNHK1GcjZwI_FQkutu7L2uFnJ4lLx7qVOpMd4W0y1Z0ztLRcnMvFB7-fOfA-0NS0MySu8ww5GM8bafKAF5fVEF4siCKsV9vA3poyql-mdQPu-xAgVriIbxdcN4gM7CJxGf0yUFHnueWP6K0RqIrMu7nH77CmsAMekrRkvQ-oFf9-Q7jo7PUshnLURK5XEgnnRGqCBvEQlLw5gsq7z03TIMMpDXsePSAH7dhfpganScMdcC5NxzFIySv5E9GPu_AuS7qclqAzm5ie0oKVHrKwHD74dhimeByZm2mkYLByxPU57eHpWMEz2l_oE9LXpQgGXKXYpWqFvd0U2r1oHpMNdqg");
    driver.findElement(By.id("user_login")).clear();
    driver.findElement(By.id("user_login")).sendKeys("aashith");
    driver.findElement(By.id("user_password")).click();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("********");
    driver.findElement(By.id("user_remember_me")).click();
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.xpath("//div[@id='content-body']/div[3]/div/div/div/div[2]/a/div[2]/h3")).click();
    driver.findElement(By.xpath("//div[@id='content-body']/div[2]/div[2]/div[2]/a/div[2]/h3")).click();
    driver.findElement(By.id("project_path")).click();
    driver.findElement(By.id("project_path")).clear();
    driver.findElement(By.id("project_path")).sendKeys("my test");
    driver.findElement(By.id("project_visibility_level_20")).click();
    driver.findElement(By.id("project_initialize_with_readme")).click();
    driver.findElement(By.name("commit")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
