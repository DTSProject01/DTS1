package com.test1.tests;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.test1.pages.LogInPage;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestSuccessfulNewUserCreation extends TestBase

{

  @Test (dataProvider = "dataProvider")
  public void testSuccessfulNewUserCreate(String username, String password, String nusername, String status,
		String role, String client, String telenumber, String email, String npassword, String confirmpw, String path,
		String imgname) 
				  throws InterruptedException, IOException, AWTException 
  {
	
	//The entry point LogInPage object below can now be removed because its added to TestBase can now inherit this
    //LogInPage logInPage = new LogInPage(driver);
	  
	boolean testResult = loginpage.loginAsAdmin(username, password)
								  .ClickManageUsersLink()
								  .AddUser()
								  .CreateNewUser(nusername, status, role, client, telenumber, email, npassword, confirmpw, path, imgname)
								  .clickManageUsersPagelink()
								  .isCreateUserSuccessful(nusername);
  
	 System.out.println(testResult);	
	 
	 Assert.assertTrue(testResult, "The account for " + nusername + " has not been successfully created." );
	 
  }
  


}
