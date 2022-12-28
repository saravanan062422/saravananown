package orj.testdata;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassOwn {
	public static WebDriver driver;
	public static WebDriver browerLaunch(String browername) {
		if(browername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		}
		
		else if(browername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver= new EdgeDriver();
		}
		
		if(browername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
		}
		return driver;
        
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void ImplicitlyWait(long time) {
    driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
			}
	public static String getAttribute(WebElement g) {
          String attribute = g.getAttribute("value");
		  return attribute;
	}
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void close() {
		driver.close();
	}
	
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	
	public static void click(WebElement c) {
		c.click();
	}
	
	public static String getText(WebElement t) {
		String text = t.getText();
		return text;

	}
	
	public static void moveToElement(WebElement m) {
		Actions s=new Actions(driver);
		s.moveToElement(m).perform();
	}
	
	public static void dragAndDrops(WebElement f,WebElement t) {
		Actions s=new Actions(driver);
		s.dragAndDrop(f, t).perform();
	}
	
	public static void doubleClick(WebElement d) {
		Actions s=new Actions(driver);
		s.doubleClick(d).perform();
	}
	
	public static void contextClick(WebElement c) {
		Actions s=new Actions(driver);
        s.contextClick(c).perform();;
	}
	
	public static void selectByIndex(WebElement ele,int a) {
    Select s=new Select(ele);
    s.deselectByIndex(a);
	}
	
	public static void deselectByValue(WebElement de,String value) {
	    Select s=new Select(de);
	    s.deselectByValue(value);
	}
	
	public static WebElement findElement(String locatorname,String locatorvlaue) {
		
		WebElement value = null;
		if(locatorname.equals("id")) {
		 value = driver.findElement(By.id(locatorvlaue));

	}
		
		else if(locatorname.equals("name")) {
			 value = driver.findElement(By.name(locatorvlaue));
		}
	
		else if(locatorname.equals("xpath")) {
			 value = driver.findElement(By.xpath(locatorvlaue));
		}
		return value;
		
	}
	
	public static void buttonClick(WebElement click) {
		click.click();
	}
	
	public static void copyText() throws AWTException {
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}
		
		public static void navigateBack() {
			driver.navigate().back();

		}
		
		public static void pastText() throws AWTException {
			Robot v=new Robot();
			v.keyPress(KeyEvent.VK_CONTROL);
			v.keyPress(KeyEvent.VK_V);
			v.keyRelease(KeyEvent.VK_CONTROL);
			v.keyRelease(KeyEvent.VK_V);

		}
		
		
		public static void downArrow() throws AWTException {
			Robot v=new Robot();
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_ENTER);
		}
		
		public static void downArrownew() throws AWTException {
			Robot v=new Robot();
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_DOWN);
			v.keyRelease(KeyEvent.VK_DOWN);
			v.keyPress(KeyEvent.VK_ENTER);
		}
		
		public static String excelData(String name,String sheetname,int rowname,int cellname ) throws IOException {
			File f=new File("C:\\Users\\SARAVANAN R\\Mavenn\\src\\test\\resources\\"+name+".xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook wk=new XSSFWorkbook(fi);
			Sheet sheet = wk.getSheet(sheetname);
			Row row = sheet.getRow(rowname);
			Cell cell = row.getCell(cellname);
			int cellType = cell.getCellType();
			String value=null;
			if(cellType==1) {
				 value = cell.getStringCellValue();
			}
				else{
					if(DateUtil.isCellDateFormatted(cell)) {
						 value = new SimpleDateFormat("dd-MM-YYYY").format(cell.getDateCellValue());
					}
						else {
							 value = String.valueOf((long)cell.getNumericCellValue());
						}
					
					
					}
			return value;
			}
			
			

		
		
}
		
		
		
		
		
		
		
		
		
		
	
	
	

