package carcheck.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class carcheckBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public carcheckBase()
	{
		String path = System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fio;
		try {
			fio = new FileInputStream(path+"\\src\\main\\java\\carcheck\\configuration\\carcheck.properties");
			prop.load(fio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialiaztion()
	{
		//path+"\\src\\main\\java\\carcheck\\configuration\\
		//String Pa = prop.getProperty("cdriver")+"\\chromedriver.exe";
		String Pa = System.getProperty("user.dir") + "\\src\\main\\java\\carcheck\\configuration\\" + "chromedriver.exe" ;
		String Paurr = prop.getProperty("url");
		//System.setProperty("webdriver.chrome.driver",prop.getProperty("cdriver")+"\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",Pa);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver,30);
		driver.get(prop.getProperty("url"));
	}

}
