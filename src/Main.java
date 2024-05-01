import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C://Users//lohan//IdeaProjects//chromedriver.exe");
        WebDriver driver =new ChromeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        driver.manage().window().maximize();

        //login validation
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(2000);

        //select dropdown validation
        Select drpdown= new Select(driver.findElement(By.name("facility")));
        drpdown.selectByValue("Seoul CURA Healthcare Center");

        driver.findElement(By.id("chk_hospotal_readmission")).click();

        //validating the radio button
        driver.findElement(By.id("radio_program_medicaid")).click();

        //validation of date picker
        driver.findElement(By.id("txt_visit_date")).click();
        String currentDate = driver.findElement(By.className("datepicker-switch")).getText();

        while (!(currentDate.equals("July 2024"))) {
            driver.findElement(By.xpath("//th[@class='next']")).click();
            currentDate = driver.findElement(By.className("datepicker-switch")).getText();
        }
        driver.findElement(By.xpath("//td[@class='day'][text()='24']")).click();

        driver.findElement(By.id("txt_comment")).click();

        //for comment part
        driver.findElement(By.id("txt_comment")).sendKeys("Thank you for the amazing experience!!");

        //button click
        driver.findElement(By.id("btn-book-appointment")).click();
        //closing the browser after 5 secs
        // driver.close();

    }
}