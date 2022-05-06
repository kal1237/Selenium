package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PracticeAutomationDemoSite {
	WebDriver driver;
	@BeforeSuite(groups="mandatory")

	public void beforeTest() {
		System.out.println("--@beforeTest, set the browser, maximise the window");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.automationtesting.in/Register.html");
		System.out.println("Url is Successfully opened");
		//System.out.println(driver.getTitle());
		//String expectedTitle="Register";
		//String actualTitle=driver.getTitle();
		//Assert.assertEquals(expectedTitle, actualTitle);
		Assert.assertEquals("Register", driver.getTitle());
		System.out.println("The title is checked");
		Assert.assertEquals("Register", driver.findElement(By.xpath("//*[@id=\"section\"]/div/h2")).getText());
		System.out.println("The heading of page is checked");


	}

	@AfterSuite(groups="mandatory")
	public void afterTest() {
		System.out.println("--@afterTest, closing the browser window");
		driver.close();
	}

	//Testing the fullname text and entering the details
	@Test(groups="mandatory",priority=1)
	public void enterFirstName()
	{
		Assert.assertEquals("Full Name*", driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/label")).getText());
		Assert.assertEquals("First Name",driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).getAttribute("placeholder"));
		Assert.assertEquals("Last Name",driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).getAttribute("placeholder"));
		System.out.println("The text for Full Name,First Name,Last Name checked");
		WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("Test");
		WebElement lastName=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.sendKeys("Practice");
		System.out.println("Full Name is entered");

	}

	//Testing the address text and entering the details
	@Test(priority=2,groups="notMandatory")
	public void enterAddress()
	{
		WebElement addressText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/label"));
		Assert.assertEquals("Address",addressText.getText());
		System.out.println(addressText.getCssValue("font-family"));
		System.out.println("Address Text checked");
		WebElement address=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"));
		address.sendKeys("11 Gandhi Street,Delhi");
		System.out.println("Address entered");
	}

	//Testing the emailtext and entering the emailaddress
	@Test(groups="mandatory",priority=3)
	public void enterEmail()
	{
		WebElement emailText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[3]/label"));
		Assert.assertEquals("Email address*",emailText.getText());
		System.out.println("EmailAddress text checked");
		WebElement emailID=driver.findElement(By.xpath("//*[@id=\"eid\"]/input"));
		emailID.sendKeys("abc@gmail.com");
		System.out.println("emailid entered");
	}

	//testing the phhone text and entering the phone
	@Test(groups="mandatory",priority=4)
	public void enterPhone()
	{

		WebElement phoneText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/label"));
		Assert.assertEquals("Phone*",phoneText.getText());
		System.out.println("phone text checked");
		WebElement phone=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input"));
		phone.sendKeys("1111111");
		System.out.println("phone number entered");
	}

	//testing the gender text and clicking on female radio
	@Test(groups="mandatory",priority=5)
	public void radioGender()
	{
		WebElement genderText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/label"));
		Assert.assertEquals("Gender*",genderText.getText());
		System.out.println("gender text checked");
		WebElement gender=driver.findElement(By.xpath("//input[@value='FeMale']"));
		gender.click();
		System.out.println("gender is clicked");

	}

	//testing the hobbies and click on cricket,movies

	@Test(priority=6)
	public void checkHobbies()
	{
		WebElement hobbiesText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[6]/label"));
		Assert.assertEquals("Hobbies",hobbiesText.getText());
		System.out.println("Hobbies text checked");
		Assert.assertEquals("Cricket",driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[6]/div/div[1]/label")).getText());
		Assert.assertEquals("Movies",driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[6]/div/div[2]/label")).getText());
		Assert.assertEquals("Hockey",driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[6]/div/div[3]/label")).getText());
		System.out.println("All checkbox text checked");
		WebElement cricket=driver.findElement(By.id("checkbox1"));
		WebElement movies=driver.findElement(By.id("checkbox2"));
		WebElement Hockey=driver.findElement(By.id("checkbox3"));
		cricket.click();
		movies.click();
		System.out.println("two boxes checked");

	}
	
	//languages drop down multiple inputs div instead of Select 
	@Test(priority=7,groups="notMandatory")
	public void languages()
	{
		
		WebElement languageText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/label"));
		Assert.assertEquals("Languages", languageText.getText());
		//using this below steps since the html didnt have select 
		Actions action=new Actions(driver);
		WebElement optionsList=driver.findElement(By.xpath("//*[@id=\"msdd\"]"));
		action.moveToElement(optionsList);
		optionsList.click();
		
		List<WebElement> options=driver.findElements(By.className("ui-corner-all"));
		//selecting two languages
		for(WebElement option:options) {
			
			if(option.getText().equals("Catalan")|| option.getText().equals("Arabic")) {
				System.out.println(option.getText());
				option.click();
			}
					
		}
		
		System.out.println("language selected");
		languageText.click();
		//for coming back to page
		
	}
	//skills drop down
	@Test(groups="notMandatory",priority=8)
	public void skills()
	{
		WebElement skillsText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[8]/label"));
		Assert.assertEquals( "Skills",skillsText.getText());
		System.out.println("the skills text is checked");
		//selecting the dropdown
		Select skills=new Select(driver.findElement(By.id("Skills")));
		skills.selectByVisibleText("CSS");
		System.out.println("the skill is selected");
		
			
		
	}
	
	//countries selectin
	@Test(priority=9,groups="notMandatory")
	public void country()
	{
		WebElement countryText=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/label"));
		Assert.assertEquals( "Select Country :",countryText.getText());
		System.out.println("the country text is checked");
		//selecting the dropdown
		WebElement dropdown=driver.findElement(By.id("countries"));
				Select country=new Select(dropdown);
				dropdown.sendKeys("India");
				System.out.println("country picked");
				
	}
	
	//selecting DOB
	@Test(priority=10,groups="notMandatory")
	public void datOfBirth()
	{
		WebElement dobtext=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/label"));
		Assert.assertEquals( "Date Of Birth",dobtext.getText());
		System.out.println("the dob text is checked");
		//selcting the year
		Select year=new Select(driver.findElement(By.id("yearbox")));
		year.selectByVisibleText("1924");
		//selecting the month
		Select month=new Select(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")));
		month.selectByVisibleText("June");
		//selecting day
		Select day=new Select(driver.findElement(By.id("daybox")));
		day.selectByVisibleText("20");
		System.out.println("Date of Birth entered");
	}
	
	
		//enter first password
		
		@Test(priority=10,groups="notMandatory")
		public void password()
		{
			WebElement password=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[12]/label"));
			Assert.assertEquals( "Password",password.getText());
			System.out.println("the passwrd text is checked");
			//enter passwd
			driver.findElement(By.id("firstpassword")).sendKeys("Hello123");
			System.out.println("first password entered");
					
		}
		
		
		//enter second password
		
				@Test(priority=11,groups="notMandatory")
				public void password1()
				{
					WebElement password1=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[13]/label"));
					Assert.assertEquals( "Confirm Password",password1.getText());
					System.out.println("the confirm passwrd text is checked");
					//enter passwd
					driver.findElement(By.id("secondpassword")).sendKeys("Hello123");
					System.out.println("second password entered");
							
				}
		
		
		
		
	/*@Test(groups="mandatory")
	public void ExtentReports()
	{
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\kalya\\Desktop\\Reports\\Report.html"); 
		 ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        ExtentTest logger = extent.createTest("Result");
	        logger.log(Status.INFO, "This step shows usage of login test");
	        logger.log(Status.PASS, "TESTING PASSED");
	        extent.flush();
	}*/

}
