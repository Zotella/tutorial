package CumplirRemesa;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.devtools.CdpVersionFinder;

public class Manifiesto {
	
private WebDriver driver;
	
	By usernameLocator =By.id("dnn_ctr580_FormLogIn_edUsername");
	By passwordLocator = By.id("dnn_ctr580_FormLogIn_edPassword"); 
	
	By ministerioLocator = By.xpath("//img[@src='/Portals/0/LogoMintransporte2014.jpg']");
	
	private readCsv dataRemesa;
	
    
	@Before
	public void setUp() {
			
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rndc.mintransporte.gov.co/MenuPrincipal/tabid/204/language/es-MX/Default.aspx?returnurl=%2fprogramasRNDC%2fcreardocumento%2ftabid%2f69%2fctl%2fCumplirRemesa%2fmid%2f396%2fprocesoid%2f5%2fdefault.aspx");
		dataRemesa = new readCsv();
	}
	


	@Test
	public void testAisPage () throws CsvValidationException, IOException, InterruptedException {
		
				
		if (driver.findElement(ministerioLocator).isDisplayed()) { 
	 	
			driver.findElement (usernameLocator).sendKeys("GERENTE@4279");
			driver.findElement (passwordLocator).sendKeys("Gerente4279");
			
			driver.findElement(By.id("dnn_ctr580_FormLogIn_btIngresar")).click();
			//cumplir
			driver.findElement(By.id("tddnn_dnnSOLPARTMENU_ctldnnSOLPARTMENU119")).click();
			
			//cumplir manifiesto
			driver.findElement(By.id("tddnn_dnnSOLPARTMENU_ctldnnSOLPARTMENU121")).click();
			
			CSVReader reader = new CSVReader (new FileReader("CSVdata\\Pendientes_Manifiesto.csv"));

			// reading the data of the CSV file

			StringBuffer buffer = new StringBuffer();
			String NroManifiesto[];

			while ((NroManifiesto = reader.readNext()) !=null) {

			    for(int i=0 ; i<NroManifiesto.length ; i++){
			         System.out.print(NroManifiesto[i] +" " ) ;
				}
			    
			    System.out.println("");

			    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
				//get current date time with Date()
				 Date date = new Date();
				 // Now format the date
				 String date1= dateFormat.format(date);
				 
				 
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_NUMMANIFIESTOCARGA")).sendKeys(NroManifiesto);
					
					
					Select drpTipoCumplidoM = new Select(driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_NOMTIPOCUMPLIDOMANIFIESTO")));
					drpTipoCumplidoM.selectByVisibleText("Cumplido Normal");
					drpTipoCumplidoM.selectByIndex(1);
					
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_NOMTIPOCUMPLIDOMANIFIESTO")).sendKeys(Keys.TAB);
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_VALORADICIONALHORASCARGUE")).sendKeys(Keys.TAB);
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_VALORADICIONALHORASDESCARGUE")).sendKeys(Keys.TAB);
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_VALORADICIONALFLETE")).sendKeys(Keys.TAB);
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_VALORDESCUENTOFLETE")).sendKeys(Keys.TAB);
					
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_FECHAENTREGADOCUMENTOS")).sendKeys(date1);
					
					driver.findElement(By.id("dnn_ctr396_CumplirManifiesto_btGuardar")).click();
									
										
					driver.findElement(By.id("dnn_ctr396_CumplirManifiestoNew_btNuevo")).click();
					
				
					
				}
					
				}
			
			}
		}

