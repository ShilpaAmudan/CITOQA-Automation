package digs_Smoke_Test_Cases;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Login_To_DiGS {
	{
		
	}
	Wrapper wp = new Wrapper();
		
        @Test(dataProvider = "Credential")

		public void  login(String username,String url) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		//Launch the browser and enter the URL
        wp.launchBrowser("chrome", url);
		Thread.sleep(6000);
		
		//To enter the user name
		wp.enterTextByID("userName", username);
		wp.clickById("loginButton");
		Thread.sleep(3000);
		System.out.println("Started Test case : Login with valid credentials and Log out");
	    //To verify whether application launched successfully
	    wp.getTextAndCompareUsingId("searchProduct", "Search");
	    wp.clickById("searchMyProfile");
	    //To log out of the application
		wp.clickById("logoutLink");
		wp.closeBrowser();
		
		
	}
@DataProvider(name = "Credential")
public  Object[][] loginData() throws IOException {
	
	Object[][] arrayObject =Wrapper.getXlsData("VerifyLogin_MultipleUser");
	return arrayObject;
}
	}
	
		
