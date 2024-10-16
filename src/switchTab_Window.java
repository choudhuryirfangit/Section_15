import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchTab_Window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> w=driver.getWindowHandles();
		Iterator<String> it=w.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(parentWindow);
		driver.get("https://rahulshettyacademy.com/");
		List<WebElement> link=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
		String name=link.get(1).getText();
		driver.switchTo().window(childWindow);
		driver.findElement(By.cssSelector(".name")).sendKeys(name);
		

	}

}
