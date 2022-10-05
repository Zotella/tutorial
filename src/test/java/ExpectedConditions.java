import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import com.google.common.base.Predicate;


import ru.stqa.selenium.wait.ExpectedElementConditions;

public class ExpectedConditions {

	 public static void main(String[] args) throws InterruptedException  {
         
         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("http://omayo.blogspot.com/");
         
         WebDriverWait wait = new WebDriverWait(driver,25);
  
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("deletesuccess")));
         
          driver.findElement(By.id("alert2")).click();
         
  }

	private static Function<? super WebDriver, Object> invisibilityOfElementLocated(By id) {
		// TODO Auto-generated method stub
		return null;
	}

}

