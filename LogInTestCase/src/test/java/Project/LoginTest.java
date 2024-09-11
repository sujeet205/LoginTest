package Project;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
//import org.testng.annotations.Test;

//import io.cucumber.messages.types.Duration;

public class LoginTest {

	    WebDriver driver;
	    String baseUrl = "https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F"; // URL of the login page

	    @BeforeClass
	    public void setup() {
	        // Set up WebDriver and open the browser
	        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(baseUrl);
	    }

	    @Test(priority = 1)
	    public void successfulLoginTest() {
	        // Enter valid credentials
	        driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("Sujit@456");
	        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/button")).click();

	        // Validate that the user is redirected to the correct landing page
	        String expectedUrl = "https://app.germanyiscalling.com/cv/upload/";
	       // Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the correct landing page after successful login.");
	        assertEquals(driver.getCurrentUrl(), expectedUrl);
	        System.out.println("Successfully logedin.");
	        driver.findElement(By.xpath("//*[@id=\"dropdownUser1\"]/span")).click();
	        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/ul/li[3]/a/span")).click();

	    }
	   
	    @Test(priority = 2)
	    public void unsuccessfulLoginTest_IncorrectPassword() {
	        // Enter valid username but incorrect password
	    	driver.findElement(By.id("username")).clear();
	    	driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
	    	driver.findElement(By.id("password")).clear();
	    	driver.findElement(By.id("password")).sendKeys("abc123");
	        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/button")).click();
	      //  driver.findElement(By.id("loginBtn")).click();
	       // String expectedUrl = "https://app.germanyiscalling.com/cv/upload/";
	      //  assertEquals(driver.getCurrentUrl(), expectedUrl);

	        // Validate that an error message is displayed
	        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/ul/li"));
	        assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid credentials.");
	        assertEquals(errorMessage.getText(), "Please enter a correct username and password.", "Incorrect error message.");
	    }

	    @Test(priority = 3)
	    public void emptyFieldsTest() {
	        // Leave both fields empty and try to log in
	    	driver.findElement(By.id("username")).clear();
	    	driver.findElement(By.id("username")).sendKeys("");
	    	driver.findElement(By.id("password")).clear();
	    	driver.findElement(By.id("password")).sendKeys("");
	        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[4]/button")).click();
	      //  driver.findElement(By.id("loginBtn")).click();
	       // String expectedUrl = "https://app.germanyiscalling.com/cv/upload/";
	      //  assertEquals(driver.getCurrentUrl(), expectedUrl);

	        // Validate that appropriate error message is displayed
	        WebElement errorMessage1 = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/ul/li[1]"));
	        assertTrue(errorMessage1.isDisplayed(), "Error message not displayed for empty fields.");
	        assertEquals(errorMessage1.getText(), "Email: This field is required.", "Incorrect error message for empty email.");
	        WebElement errorMessage2 = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/ul/li[2]"));
	        assertTrue(errorMessage2.isDisplayed(), "Error message not displayed for empty fields.");
	        assertEquals(errorMessage2.getText(), "Email: This field is required.", "Incorrect error message for empty password.");
	    }

	    @Test(priority = 4)
	    public void specialCharactersTest() {
	        // Enter special characters in the username and password fields          
	        driver.findElement(By.id("username")).clear();
	    	driver.findElement(By.id("username")).sendKeys("!@#$%^&*()");
	    	driver.findElement(By.id("password")).clear();
	    	driver.findElement(By.id("password")).sendKeys("!@#$%^&*()");
	        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[4]/button")).click();
	      //  driver.findElement(By.id("loginBtn")).click();
	        // Validate that appropriate error message is displayed
	        // Validate that an error message is displayed
	        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/ul/li"));
	        assertTrue(errorMessage.isDisplayed(), "Error message not displayed for special character credentials.");
	        assertEquals(errorMessage.getText(), "Please enter a correct username and password.", "Incorrect error message.");
	        
	    }

		private void assertTrue(boolean displayed, String string) {
			// TODO Auto-generated method stub
			
		}

		private void assertEquals(@Nullable String currentUrl, String expectedUrl) {
			// TODO Auto-generated method stub
			
		}

		private void assertEquals(@Nullable String currentUrl, String expectedUrl, String expectedUrl2) {
			// TODO Auto-generated method stub
			
		}
		 @AfterClass
		    public void tearDown() {
		        // Close the browser
		        driver.quit();
		    }

	}


