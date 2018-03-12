package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	
	@Test(priority=2,groups= {"login"})
	public void testInvalidLogin() throws InterruptedException 
	{
		int rc=Excel.getRowCount(XL_PATH, "InvalidLogin");
		for(int i=1;i<=rc;i++) 
		{
			String un=Excel.getValue(XL_PATH, "InvalidLogin", i, 0);
			String pw=Excel.getValue(XL_PATH, "InvalidLogin", i, 1);
			String expectedMsg=Excel.getValue(XL_PATH, "InvalidLogin", i, 2);
			LoginPage l=new LoginPage(driver);
			//Enter the invalid UN
			l.setUserName(un);
			//Enter the invalid PW
			l.setPassword(pw);
			//click login
			l.clickLogin();
			Thread.sleep(1000);
			//Verify err msg
			l.verifyerrMsg(expectedMsg);
			Thread.sleep(1000);
		}
	}
}
