package org.regularwrk;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	//1-launch chrome
	public static WebDriver browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	//2-load url
	public static void geturl(String url) {
		driver.get(url);
	}
	
	//3-window maximize
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	//4-sendkey
	public static void passTxt(WebElement element,String pass) {
		element.sendKeys(pass);
	}
	
	//5-get tittle
	private void printtittle() {
		System.out.println(driver.getTitle());
	}
	
	//6-get current url
	private void crturl() {
		System.out.println(driver.getCurrentUrl());
	}
	
	//7-click method
	public static void webclick(WebElement element) {
		element.click();
	}
	
	//8-close the tab
	private void close() {
		driver.close();
	}
	
	//9-close(quit) the entire chrome
	private void quitechrome() {
		driver.quit();
	}
	
	//actionclass:
	public static Actions a;
	//10-move to element:
	public static void elementMove(WebElement ele) {
		a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	//11-drag and drop in actions
	private void dragAndDrop(WebElement source, WebElement target) {
		a= new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	//12-key down in actions
	private void keyKickDown(WebElement target, CharSequence key) {
		a=new Actions(driver);
		a.keyDown(target, key).perform();;

	}
	
	//13-key up in actions
	private void keyKickUp(WebElement target, CharSequence key) {
		a=new Actions(driver);
		a.keyUp(target, key).perform();
	}
	
	//14-click actions
	private void actionsclick() {
		a=new Actions(driver);
		a.click().perform();
	}
	
	//15-sendkeys in actions
	private void actionsSendKey(WebElement target,CharSequence keys) {
		a= new Actions(driver);
		a.sendKeys(target, keys).perform();
	}
	
	//16-double click in actions
	public static void dclick(Actions dclick) {
		dclick.doubleClick().perform();
	}
	
	//17-context click in actions
	public static void conclick(Actions cclick) {
		cclick.contextClick().perform();
	}

	//alerts
	//18-alert simple alert accept
	public static void accept() { 
		Alert a1= driver.switchTo().alert();
		a1.accept();
	}
	
	//19-alert confirm alert dismiss 
	public static void dismiss() {
		Alert a1= driver.switchTo().alert();
		a1.dismiss();
	}
	
	//20-alert sendkey alert
	public static void sendkey(String txt) {
		Alert a1= driver.switchTo().alert();
		a1.sendKeys(txt);
	}
	
	//21-alert get text
	public static void gtxt() {
		Alert a1= driver.switchTo().alert();
		a1.getText();
	}
	
	//robot class
	public static Robot r;
	//22-enter key using robot class
	private void roboEnter() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	//23-up using robot class
	private void roboUp() throws AWTException{
		r=new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	//24-down using robot class
	private void roboDown() throws AWTException{
		r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	//25-copy by using robot class
	private void roboCopy() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	//26-paste by robot class
	private void roboPaste() throws AWTException{
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	//27-tab by robot class
	private void roboTab() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	//28-cut by robot class
	private void roboCut() throws AWTException{
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
			
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}
	
	//29-switch by FrameId
	private void goFrameId(String id) {
		driver.switchTo().frame(id);
	}
	//30-switch by FrameName
	private void goFrameName(String name) {
		driver.switchTo().frame(name);
	}
	//31-switch by FrameWebElement
	private void goFrameWebElement(WebElement ele) {
		driver.switchTo().frame(ele);
	}
	//32-switch by FrameIndexPositon
	private void goFrameIndex(int index) {
		driver.switchTo().frame(index);
	}
	//33-exit to previous Frame
	private void preFrame() {
		driver.switchTo().parentFrame();
	}
	//34-Exit Frame to html
	private void exitFrame() {
		driver.switchTo().defaultContent();
	}
	//Navigation
	//35-navigate to:
	public static void navito(String url) {
		driver.navigate().to(url);
	}
	//36-navigate backward:
	public static void naviback() {
		driver.navigate().back();
	}
	//37-navigate forward:
	public static void naviforward() {
		driver.navigate().forward();
	}
	//38-navigate refresh:
	public static void navirefresh() {
		driver.navigate().refresh();
	}
	//datadriven---------------------------------------------------------------------------------------
	//39-to read the data form the excel file
	public static String readDataFrmExcel(String name, int rowNum,int cellNum) throws IOException {
		File f=new File("C:\\TasksFrames\\Exel\\studentdetail.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);	
		Sheet oldSheet = w.getSheet(name);
		Row oldRow = oldSheet.getRow(rowNum);
		Cell oldCell = oldRow.getCell(cellNum);
		int cellType = oldCell.getCellType();
		
		String value="";
		if(cellType==1) {
			value=oldCell.getStringCellValue();
		}
		
		else if (DateUtil.isCellDateFormatted(oldCell)) {
			java.util.Date date=oldCell.getDateCellValue();
			SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
			value=sdf.format(date);
		}
		else {
			double d=oldCell.getNumericCellValue();
			long l=(long)d;
			value=String.valueOf(l);
		}
		return value;
	}
	
	//40-to create a new sheet,row, and cell..
	public static void createExcelFile(String name,int rowNum,int cellNum,String data) throws IOException {
		File f=new File("C:\\TngDailyWrks\\excel\\datadriven.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		
		Sheet newSheet = w.createSheet(name);
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		System.out.println("writen..");
	}
	
	//41-to create a new row and cell..
	private void createRowAndCellOnly(String name,int rowNum,int cellNum,String data) throws IOException {
		File f=new File("C:\\TngDailyWrks\\excel\\datadriven.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		
		Sheet oldSheet = w.getSheet(name);
		Row newRow = oldSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		System.out.println("writen..");
	}
	
	
	
	
	
	
	
	
//	public static WebDriver driver1;
//	public static WebDriver implicitlyWait() {
//		WebDriverManager.chromedriver().setup();
//		driver1=new ChromeDriver();
//		driver1.manage().window().maximize();
//		driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		return driver1;
//	}
	
	          
	
	
	
	
	
	

}
