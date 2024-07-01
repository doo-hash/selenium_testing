package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class webFormTesting {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeEach
	void setUp() throws Exception {
//		driver = new EdgeDriver();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void sampleWebFormTesting() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        Thread.sleep(3000);
        //Convenient way
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://www.selenium.dev/selenium/web/web-form.html");

        Thread.sleep(3000);
        //get elements
        WebElement textBox = driver.findElement(By.id("my-text-id"));
        WebElement password = driver.findElement(By.name("my-password"));
        WebElement textArea = driver.findElement(By.tagName("textarea"));
        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        WebElement readOnlyInput = driver.findElement(By.name("my-readonly"));
        WebElement aLink = driver.findElement(By.linkText("Return to index"));
        WebElement dropdownSelect = driver.findElement(By.name("my-select"));
        WebElement dropdownDataList = driver.findElement(By.name("my-datalist"));
        WebElement checkBoxone = driver.findElement(By.id("my-check-1"));
        WebElement checkBoxtwo = driver.findElement(By.id("my-check-2"));
        WebElement radioButtonone = driver.findElement(By.id("my-radio-1"));
        WebElement radioButtontwo = driver.findElement(By.id("my-radio-2"));
        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        WebElement datePicker = driver.findElement(By.name("my-date"));
        WebElement exampleRange = driver.findElement(By.name("my-range"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        //textbox input
        textBox.sendKeys("Selenium test");
        assertEquals("Selenium test", textBox.getDomProperty("value"));
        assertEquals("text", textBox.getDomAttribute("type"));

        Thread.sleep(3000);
        
        //Password input
        password.sendKeys("password");
        assertEquals("password", password.getDomProperty("value"));
        assertEquals("password", password.getDomAttribute("type"));
        
        Thread.sleep(3000);
        //textarea input
        textArea.sendKeys("my text area");
        assertEquals("my text area", textArea.getAttribute("value"));
        assertEquals("3", textArea.getDomAttribute("rows"));
        
        Thread.sleep(3000);
        //disabledInput
        assertEquals("text", disabledInput.getDomAttribute("type"));
        assertEquals("Disabled input", disabledInput.getDomAttribute("placeholder"));
        assertEquals(false, disabledInput.isEnabled());
        assertEquals("true", disabledInput.getDomAttribute("disabled"));
        
        Thread.sleep(3000);
        //readonly input
        assertEquals("text", readOnlyInput.getDomAttribute("type"));
        assertEquals("Readonly input", readOnlyInput.getDomProperty("value"));
        
        Thread.sleep(3000);
        //link tag
        assertEquals("./index.html", aLink.getDomAttribute("href"));

        Thread.sleep(3000);
        Select dropdownField = new Select(dropdownSelect);
        assertFalse(dropdownField.isMultiple());
        List<WebElement> alloptions = dropdownField.getOptions();
        System.out.println(alloptions);
        dropdownField.selectByValue("2");
        Thread.sleep(1000);
        dropdownField.selectByVisibleText("Three");
        List<WebElement> selectedoptions = dropdownField.getOptions();
        System.out.println(selectedoptions);
        List<WebElement> firstselectedoption = dropdownField.getOptions();
        System.out.println(firstselectedoption);
        
        Thread.sleep(1000);
        //check box
        checkBoxone.click();
        checkBoxtwo.click();
        assertTrue(checkBoxtwo.isSelected());
        assertFalse(checkBoxone.isSelected());
        
        Thread.sleep(1000);
        //radio button
        assertTrue(radioButtonone.isSelected());
        radioButtontwo.click();
        assertFalse(radioButtonone.isSelected());
        
        Thread.sleep(1000);
        //range
        Rectangle  res = exampleRange.getRect();
        assertEquals(res.getX(), 690);
        
        Thread.sleep(1000);
        //file upload
        File uploadFIle = new File("src/test/resources/Screenshot 2024-05-08 230854.png");
        WebElement fileInput = driver.findElement(By.name("my-file"));
        fileInput.sendKeys(uploadFIle.getAbsolutePath());
        assertEquals("C:\\fakepath\\Screenshot 2024-05-08 230854.png", fileInput.getDomProperty("value"));
        
        Thread.sleep(1000);
        //date picker
        datePicker.sendKeys("06/10/2024");
        assertEquals("06/10/2024", datePicker.getDomProperty("value"));
        
        Thread.sleep(1000);
//        datePicker.clear();
//        datePicker.click();
//        Thread.sleep(3000);
//        WebElement datedropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("datepicker")));
//        Thread.sleep(1000);
//        assertTrue(datedropdown.isDisplayed());
//        assertEquals("June 2024", driver.findElement(By.className("datepicker-switch")).getText());
//        driver.findElement(By.className("datepicker-switch")).click();
//        Thread.sleep(3000);
//        wait.until(ExpectedConditions.elementToBeClickable(By.className("datepicker-months")));
//        Thread.sleep(1000);
//        assertTrue(driver.findElement(By.className("datepicker")).isDisplayed());
//        assertTrue(driver.findElement(By.className("datepicker-months")).isDisplayed());
//        assertTrue(driver.findElement(By.className("datepicker-switch")).isDisplayed());
//        Thread.sleep(3000);
//        assertEquals("2024", driver.findElement(By.className("datepicker-switch")).getText());
//        driver.findElement(By.className("datepicker-switch")).click();
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.elementToBeClickable(By.className("datepicker")));
//        Thread.sleep(1000);
//        assertEquals("2024", driver.findElement(By.className("datepicker-switch")).getText());
//        driver.findElement(By.className("datepicker-switch")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.className("datepicker-switch")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.className("next")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.className("prev")).click();
//        Thread.sleep(1000);
//        List<WebElement> century = driver.findElements(By.className("century"));
//        assertEquals("2100", century.get(2).getText()); 
//        century.get(2).click();
//        Thread.sleep(1000);
//        assertEquals("2100-2190", driver.findElement(By.className("datepicker-switch")));
//        List<WebElement> decade = driver.findElements(By.className("decade"));
//        assertEquals("2130", decade.get(4).getText()); 
//        decade.get(4).click();
//        Thread.sleep(1000);
//        assertEquals("2130-2139", driver.findElement(By.className("datepicker-switch")));
//        List<WebElement> year = driver.findElements(By.className("year"));
//        assertEquals("2134", year.get(5).getText()); 
//        year.get(5).click();
//        Thread.sleep(1000);
//        assertEquals("2134", driver.findElement(By.className("datepicker-switch")));
//        List<WebElement> month = driver.findElements(By.className("month"));
//        assertEquals("Oct", month.get(9).getText()); 
//        month.get(9).click();
//        Thread.sleep(1000);
//        assertEquals("October 2134", driver.findElement(By.className("datepicker-switch")));
//        List<WebElement> day = driver.findElements(By.className("day"));
//        assertEquals("16", day.get(20).getText()); 
//        day.get(20).click();
//        Thread.sleep(1000);
//        assertEquals("10/16/2134", datePicker.getDomProperty("value"));
//        
        Thread.sleep(1000);
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);
        
	}
	
 
	@Test
	void sampleWebFormBrowserNavigateTesting() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);
        Thread.sleep(3000);
        
        //Convenient way
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://www.selenium.dev/selenium/web/web-form.html");

        Thread.sleep(3000);
        //Longer way
//        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium test");

        Thread.sleep(3000);
        submitButton.click();

        String returnUrl = driver.getCurrentUrl();
        assertEquals(returnUrl, "https://www.selenium.dev/selenium/web/submitted-form.html?my-text=Selenium+test&my-password=&my-textarea=&my-readonly=Readonly+input&my-select=Open+this+select+menu&my-datalist=&my-file=&my-check=on&my-radio=on&my-colors=%23563d7c&my-date=&my-range=5&my-hidden=");

        Thread.sleep(3000);
        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);
        
        Thread.sleep(3000);
        //browser back button
        driver.navigate().back();
        String backUrl = driver.getCurrentUrl();
        assertEquals(backUrl, "https://www.selenium.dev/selenium/web/web-form.html");
        
        Thread.sleep(3000);
        //browser forward button
        driver.navigate().forward();
        String forwardUrl = driver.getCurrentUrl();
        assertEquals(forwardUrl, "https://www.selenium.dev/selenium/web/submitted-form.html?my-text=Selenium+test&my-password=&my-textarea=&my-readonly=Readonly+input&my-select=Open+this+select+menu&my-datalist=&my-file=&my-check=on&my-radio=on&my-colors=%23563d7c&my-date=&my-range=5&my-hidden=");
        
        Thread.sleep(3000);
        //Refresh
        driver.navigate().refresh();
        title = driver.getTitle();
        assertEquals("Web form - target page", title);
	}
	
	@Test
	void sampleExplicitWait() throws InterruptedException {
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement element = driver.findElement(By.id("revealed"));
		driver.findElement(By.id("reveal")).click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> element.isDisplayed());
		
        Thread.sleep(3000);
		element.sendKeys("Sleepy");
		assertEquals("Sleepy", element.getDomProperty("value"));
	}

	@Test
	void sampleImplicitWait() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement redbox = driver.findElement(By.id("adder"));
		redbox.click();
		
        Thread.sleep(3000);
		WebElement addedElement = driver.findElement(By.id("box0"));
		assertEquals("redbox", addedElement.getDomAttribute("class"));
        Thread.sleep(3000);
	}
	
	
	  @Test void sampleFailsWithoutImplicit() throws InterruptedException,
	  NoSuchElementException {
	  driver.get("https://www.selenium.dev/selenium/web/dynamic.html"); 
	  WebElement redbox = driver.findElement(By.id("adder")); redbox.click();
	  
	  // WebElement addedElement = driver.findElement(By.id("box0")); it throws NoSuchElementException
	  
	  assertThrows(NoSuchElementException.class, () -> {
	  driver.findElement(By.id("box0")); }); 
	  Thread.sleep(3000); 
	  }
	 
	
	
	  @Test void sampleSleep() throws InterruptedException {
	  driver.get("https://www.selenium.dev/selenium/web/dynamic.html"); 
	  WebElement redbox = driver.findElement(By.id("adder")); 
	  redbox.click();
	  
	  Thread.sleep(1000);
	  
	  WebElement added = driver.findElement(By.id("box0")); 
	  assertEquals("redbox", added.getDomAttribute("class")); 
	  Thread.sleep(3000); 
	  }
	 
	
	
	  @Test void samplewindowExample() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); driver.get(
	  "https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html"
	  );
	  
	  Thread.sleep(3000); //fetch handle of this 
	  String currentHandle = driver.getWindowHandle(); assertNotNull(currentHandle);
	  
	  Thread.sleep(3000); //click on the link to open a new window
	  driver.findElement(By.linkText("Open new window")).click();
	  
	  Thread.sleep(3000); //fetch handles of all windows, there will be 2, [0] for default,[1] for new window 
	  Object[] windowHandles = driver.getWindowHandles().toArray(); driver.switchTo().window((String)
	  windowHandles[1]);
	  
	  Thread.sleep(3000); //assert title of new window 
	  String title = driver.getTitle(); assertEquals("Simple Page", title);
	  
	  //closing current window 
	  driver.close();
	  
	  Thread.sleep(3000); //switch back to old tab or window
	  driver.switchTo().window((String) windowHandles[0]);
	  
	  Thread.sleep(3000); //opens a new tab and switch to it
	  driver.switchTo().newWindow(WindowType.TAB); assertEquals("",
	  driver.getTitle());
	  
	  Thread.sleep(3000); //opens a new window and switch to it
	  driver.switchTo().newWindow(WindowType.WINDOW); assertEquals("",
	  driver.getTitle()); }
	 
}
