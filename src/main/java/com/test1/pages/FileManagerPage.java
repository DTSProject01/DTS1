package com.test1.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileManagerPage extends PageBase{
	
	public FileManagerPage (WebDriver driver)
	{
		super(driver);
	}

	public boolean isLogInSuccessful () throws InterruptedException
	{
		String expectedstr = "File Manager";
		
		System.out.println("The page title includes " + driver.getTitle());
		
		Thread.sleep(1000);
		
		boolean testresults;
		
		testresults = driver.getTitle().contains(expectedstr);
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
		
		Thread.sleep(1000);
		
		return testresults;
	}
	
	public FileManagerPage SearchClient(String client) throws InterruptedException, AWTException
	{
				
		//find the client Search field and enter client name
		driver.findElement(By.xpath("//div[@class='row form-content-head']/search-box/div/input")).sendKeys(client);
		Thread.sleep(3000);
		
		//click on the drop down item
		driver.findElement(By.xpath("//div[@class='search-box']/ul/li/a")).click();	
		Thread.sleep(2000);
		
		return new FileManagerPage(driver);
	}
	
	public FileEditPage clickMapParcelLink(String mp) throws InterruptedException
	{
		
		//find the Action button and click
		driver.findElement(By.linkText(mp)).click();
		
		return new FileEditPage(driver);
	}
	
	public ManageUsersPage ClickManageUsersLink() throws InterruptedException, AWTException
	{
				
		//find the Manage Users Link and click // css=[ui-sref-opts='{inherit: false}'][ui-sref='user-manager']
		driver.findElement(By.cssSelector("[ui-sref='user-manager']")).click();
		Thread.sleep(3000);
			
		return new ManageUsersPage(driver);
	}
	
	
	public ManageClientsPage ClickManageClientsLink() throws InterruptedException, AWTException
	{
				
		//find the Manage Clients Link and click // css=[ui-sref='client-manager']
		driver.findElement(By.cssSelector("[ui-sref='client-manager']")).click();
		Thread.sleep(3000);
			
		return new ManageClientsPage(driver);
	}
	
	
	public BatchFileImportPage ClickImportFilesLink() throws InterruptedException, AWTException
	{
				
		//find the Import Files Link and click
		driver.findElement(By.cssSelector("[ui-sref='file-import']")).click();
		Thread.sleep(3000);
			
		return new BatchFileImportPage(driver);
	}
	
	public SettingsPage clickSettingsLink() throws InterruptedException
	{
		
		//find the Action button and click
		driver.findElement(By.cssSelector("[ui-sref='settings-view']")).click();
		
		return new SettingsPage(driver);
	}
	
	
}
