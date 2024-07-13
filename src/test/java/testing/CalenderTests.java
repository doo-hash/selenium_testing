package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class CalenderTests {

	
	@Test
	void calendertest1() throws Exception {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

		int day = 01;
		
		//First Calendar
//		driver.findElement(By.id("first_date_picker")).click();
//		executor.executeScript("window.scrollBy(0, 150);");
		
		//descendent xpath relation
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+ day + "]")).click();

//		Thread.sleep(1000);
		
		//First Calendar
//		driver.findElement(By.id("second_date_picker")).click();		
//		executor.executeScript("window.scrollBy(0, 150);");
		
		//descendent xpath relation
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]//a[text()=" + day + "]")).click();

//		Thread.sleep(1000);
		
		String targetPrevDate = "26/Feb/2021";
		String targetnextDate = "26/Feb/2025";

		executor.executeScript("window.scrollBy(0, 150);");
		driver.findElement(By.id("first_date_picker")).click();
		selectDate(driver, targetnextDate);
		Thread.sleep(1000);
		
		driver.findElement(By.id("second_date_picker")).click();		
		selectDate(driver, targetPrevDate);
		Thread.sleep(1000);

		driver.quit();
	}

	public static Calendar setTargetCalendar(String date, Calendar calendar) throws Exception {
		try {
			//to validate date
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			dateFormat.setLenient(false);
			Date formattedTargetDate = dateFormat.parse(date);
			calendar.setTime(formattedTargetDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the date");
		}
		
		return calendar;
	}
	
	public static Calendar setCurrentCalendar(WebDriver driver, Calendar calendar) throws Exception {
		try {
			//to validate date
			String currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the date");
		}
		
		return calendar;
	}
	
	public static void selectDate(WebDriver driver, String targetDate) throws Exception {
		Calendar calendar = Calendar.getInstance();
			
			Calendar targetCalendar = setTargetCalendar(targetDate, calendar);
			int targetMonth = targetCalendar.get(Calendar.MONTH);
			int targetYear = targetCalendar.get(Calendar.YEAR);
			int targetDay = targetCalendar.get(Calendar.DAY_OF_MONTH);			

			Calendar currentCalendar = setCurrentCalendar(driver, calendar);
			int currentMonth = currentCalendar.get(Calendar.MONTH);
			int currentYear = currentCalendar.get(Calendar.YEAR);

			while(currentMonth < targetMonth || currentYear < targetYear) {
				driver.findElement(By.className("ui-datepicker-next")).click();
				Calendar newCalendar = setCurrentCalendar(driver, calendar);
				currentMonth = newCalendar.get(Calendar.MONTH);
				currentYear = newCalendar.get(Calendar.YEAR);

			}

			while(currentMonth > targetMonth || currentYear > targetYear) {
				driver.findElement(By.className("ui-datepicker-prev")).click();
				Calendar newCalendar = setCurrentCalendar(driver, calendar);
				currentMonth = newCalendar.get(Calendar.MONTH);
				currentYear = newCalendar.get(Calendar.YEAR);

			}

			if(currentMonth == targetMonth || currentYear == targetYear)
				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]//a[text()=" + targetDay + "]")).click();
			else
				throw new Exception("Unable to select the date, current and target dates mismatch!");
		
	}
	
}
