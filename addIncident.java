package sysAid;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addIncident {

    private static WebDriver driver = null;
    static WebDriverWait wait = new WebDriverWait(driver, 10);
    static String loginPageAddress = "https://automationtest2.qa.sysaidit.com/";
    static String userNameFieldCSS = "input[name=\"userName\"]";
    static String passwordFieldCSS = "input[type=\"password\"]";
    static String username = "qatest";
    static String password = "qatest123";
    static String rememberMeChbxStateCSS = "input[name=\"rememberMe\"]";
    static String rememberMeChbxClass = "rememberMeCheckBox";
    static String loginButtonClass = "ButtonLabel";
    static String ChbxVal = "";
    static String userNameCSS = ".realname.truncate";
    static String realName = "";
    static String expectedURL = "https://automationtest2.qa.sysaidit.com/Dashboard.jsp";
    static String loginFailedNotificationXpath = "//label[@id='waiting_message'][contains(text(),'Failed to authenticate user due to a communication problem.')]";
    static String serviceDeskMenuXpath = "//a[contains(text(),'Service Desk')]";
    static String incidentsMenuItemXpath = "//span[@class='truncate'][contains(text(),'Incidents')]";
    static String addNewIncidentXpath = "//span[contains(text(),'Add New Incident')]";
    static String selectMainCategoryDropListButtonXpath = "//span[@class='defaultText'][contains(text(),'Please select a category')]";
    static String subCategoryDropListButtonXpath = "//span[@class='defaultText'][contains(text(),'Please select a sub-category')]";
    static String thirdLevelCategoryDropListButtonXpath = "//span[@class='defaultText'][contains(text(),'Select third level category')]";
    static String imageLocation = "c:\\Selenium\\Images";
    static String image = "hello.jpg";
    static String applyIncidentButtonId = "ApplyBtn";
    static String startDate = "27-08-2015";
    static String endDate = "27-08-2015";
    static String startTime = "18:00";
    static String endTime = "18:15";
    static String title = "My title";
    static String description = "This is my description";
    static String note = "Well, this is my note";
    static String actDescriptionText = "Activity description text";

    static int randomNumber;
    static int defaultDropItemSelection = 2;
    static int mainDroplistLength = 18;
    static int requestUserDropListLength = 16;
    static Random rand = new Random();


    public static void rightArrow(int num) throws AWTException
    {
        Robot robota = new Robot();
        for(int i=0; i < num; i++)
        {
            robota.keyPress(KeyEvent.VK_RIGHT);
            robota.delay(100);
            robota.keyRelease(KeyEvent.VK_RIGHT);
            robota.delay(100);
        }
    }

    public static void upArrow(int num) throws AWTException
    {
        Robot robota = new Robot();
        for(int i=0; i < num; i++)
        {
            robota.keyPress(KeyEvent.VK_UP);
            robota.delay(100);
            robota.keyRelease(KeyEvent.VK_UP);
            robota.delay(100);
        }
    }

    public static void doEnter() throws AWTException
    {
        Robot roboto = new Robot();
        roboto.keyPress(KeyEvent.VK_ENTER);
        roboto.delay(300);
        roboto.keyRelease(KeyEvent.VK_ENTER);
        roboto.delay(300);
    }

    public static void doTab() throws AWTException
    {
        Robot robotu = new Robot();
        robotu.keyPress(KeyEvent.VK_TAB);
        robotu.keyRelease(KeyEvent.VK_TAB);
        robotu.delay(300);
    }

    public static void doEnd() throws AWTException
    {
        Robot roboto = new Robot();
        roboto.keyPress(KeyEvent.VK_END);
        roboto.delay(300);
        roboto.keyRelease(KeyEvent.VK_END);
        roboto.delay(300);
    }

    public static void uploadImage(String location, String filename)
    {
        try
        {
            Robot robot = new Robot();
            Keyboard keyboard = new Keyboard();
            Thread.sleep(1000);
            keyboard.type(location);
            Thread.sleep(1000);
            doEnd();
            Thread.sleep(100);
            doEnter();
            robot.delay(300);
            keyboard.type(filename);
            Thread.sleep(1000);
            doEnter();
            Thread.sleep(100);
        }
        catch(Exception uploadIm)
        {
            uploadIm.printStackTrace();
        }
    }

    public static void selectRandomDropListItem(int num)
    {
        try
        {
            randomNumber = rand.nextInt(num) + 1;
            rightArrow(randomNumber);
            doEnter();
        }
        catch(AWTException srdli)
        {
            srdli.printStackTrace();
        }
    }

    public static void wrongCredentialsLogin()
    {
        wait = new WebDriverWait(driver, 300);
        driver.get(loginPageAddress); //Open the Login page
        driver.findElement(By.cssSelector(userNameFieldCSS)).sendKeys(username); //Insert the user name
        driver.findElement(By.cssSelector(passwordFieldCSS)).sendKeys(username); //Use a user-name as password (should cause an error)
        ChbxVal = driver.findElement(By.cssSelector(rememberMeChbxStateCSS)).getAttribute("value"); //Get "Remember me" check-box status
        if (false == ChbxVal.contentEquals("Y")) //Check-box found unchecked
        {
            driver.findElement(By.className(rememberMeChbxClass)).click();  // Check the "Remember me" check-box
        }
        driver.findElement(By.className(loginButtonClass)).click(); //Press Login button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginFailedNotificationXpath)));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES); //Wait until Login failed message is presented
//        driver.findElement(By.xpath(loginFailedNotificationXpath)).isDisplayed(); // Login failed notification is displayed
        System.out.println("Login with wrong credentials successfully failed");
    }

    public static void doLogin()
    {
        wait = new WebDriverWait(driver, 300);
        driver.get(loginPageAddress); //Open the Login page
        driver.findElement(By.cssSelector(userNameFieldCSS)).sendKeys(username); //Insert the user name
        driver.findElement(By.cssSelector(passwordFieldCSS)).sendKeys(password); //Insert the password
        ChbxVal = driver.findElement(By.cssSelector(rememberMeChbxStateCSS)).getAttribute("value"); //Get "Remember me" check-box status
        if (false == ChbxVal.contentEquals("Y")) //Check-box found unchecked
        {
            driver.findElement(By.className(rememberMeChbxClass)).click();  // Check the "Remember me" check-box
        }
        driver.findElement(By.className(loginButtonClass)).click(); //Press Login button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userNameCSS)));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES); //Wait until entering the system
        realName = driver.findElement(By.cssSelector(userNameCSS)).getText(); //Get the user name presented in the upper-right corned
        if (false == expectedURL.contentEquals(driver.getCurrentUrl()))
        {
            System.out.println("The page address found to be different from the expected.\n" +
                    "Expected address is " + expectedURL + "\nActual address is " + driver.getCurrentUrl());
        }
        if (realName.contentEquals(username)) // User name presented in the upper-right corned is the user-name we entered with into the system
        {
            System.out.println("User name appears in the upper-right corner as expected.");
        }
    }

    public static void openNewIncident() throws AWTException, InterruptedException
    {
        Robot robot = new Robot ();
        driver.findElement(By.xpath(serviceDeskMenuXpath)).click();
        driver.findElement(By.xpath(incidentsMenuItemXpath)).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Wait until the next listed element appears
        driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
        driver.findElement(By.xpath(addNewIncidentXpath)).click();
        driver.findElement(By.xpath(selectMainCategoryDropListButtonXpath)).click(); // Randomly select a Main category
        Thread.sleep(5000);
        selectRandomDropListItem(mainDroplistLength);
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); //Wait until the next listed element appears
        if (false == driver.findElements(By.xpath(subCategoryDropListButtonXpath)).isEmpty()) // Randomly select the subCategory if applicable
        {
            driver.findElement(By.xpath(subCategoryDropListButtonXpath)).click();
            Thread.sleep(3000);
            selectRandomDropListItem(defaultDropItemSelection);
            Thread.sleep(3000);
        }
        if ( false == driver.findElements(By.xpath(thirdLevelCategoryDropListButtonXpath)).isEmpty()) // Randomly select the third level category if applicable
        {
            driver.findElement(By.xpath(thirdLevelCategoryDropListButtonXpath)).click();
            Thread.sleep(3000);
            selectRandomDropListItem(defaultDropItemSelection);
            Thread.sleep(3000);
        }
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys(title);
        driver.findElement(By.id("desc")).clear();
        driver.findElement(By.id("desc")).sendKeys(description);
        robot.delay(800);
/*		try
		{
		driver.findElement(By.id(applyIncidentButtonId)).click();
		}
		catch (UnhandledAlertException f)
		{
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        System.out.println("Alert data: " + alertText);
		        alert.accept();
		    } catch (NoAlertPresentException e)
		    {
		        e.printStackTrace();
		    }
		}
		robot.delay(8000);
//		doEnter();
		robot.delay(800);*/
        driver.findElement(By.xpath("//div[contains(@class, 'requestUser_CustomSelect')]//span[@class='defaultText'][text()='none']")).click();
        robot.delay(400);
        selectRandomDropListItem(requestUserDropListLength); //Randomly select a request user
        robot.delay(1800);
        driver.findElement(By.xpath("//span[contains(text(),'Add a note')]")).click(); // Add a note
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Wait until the next listed element appears
        driver.switchTo().frame(driver.findElement(By.id("dhtml_popup1")));
        driver.findElement(By.id("textRow")).sendKeys(note);
        driver.findElement(By.xpath("//span[contains(text(),'Add')]")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[text()='Add']")).click(); //Add the attachment
        Thread.sleep(1000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        doTab();
        robot.delay(400);
        doEnter();
        uploadImage(imageLocation, image);
        robot.delay(400);
        driver.findElement(By.xpath("//span[text()='Attach Files']")).click();
        robot.delay(400);
        driver.switchTo().window(parentHandle); // switch back to the original window
        driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
        robot.delay(1400);
        driver.findElement(By.xpath("//li[contains(@class, 'tabs-nav')][text()='Activities']")).click(); //Go to Activities tab
        robot.delay(1400);
        driver.findElement(By.id("sract_fromTime")).clear();
        driver.findElement(By.id("sract_fromTime")).sendKeys(startDate); //Set Start date
        robot.delay(200);
        driver.findElement(By.name("sract_fromTime_time")).click(); //Set Start time
        robot.delay(400);
        String fromXpathExpr = "//option[text()='" + startTime + "']";
        driver.findElement(By.xpath(fromXpathExpr)).click();
        doEnter();
        robot.delay(400);
        driver.findElement(By.id("sract_toTime")).clear();
        driver.findElement(By.id("sract_toTime")).sendKeys(endDate); //Set End date
        robot.delay(200);
        driver.findElement(By.name("sract_toTime_time")).click(); //Set End time
        robot.delay(400);
//		String toXpathExpr = "//option[text()='" + endTime + "']";
//		driver.findElement(By.xpath(toXpathExpr)).click();
        upArrow(100);
        rightArrow(73); //Well, it works ugly, I need some more time to fix this
        doEnter();
        robot.delay(400);
        driver.findElement(By.id("sract_description")).sendKeys(actDescriptionText);
        robot.delay(400);
        driver.findElement(By.xpath("//span[text()='Add']")).click(); // Add the activity
        robot.delay(2400);
        driver.findElement(By.xpath("//li[contains(@class, 'tabs-nav')][text()='General Details']")).click(); // Go back to General Details tab
        robot.delay(1400);
        driver.findElement(By.xpath("//span[text()='Apply']")).click(); //Create the Incident
        robot.delay(1400);
        WebElement createdIncidentNumber = driver.findElement(By.xpath("//span[contains(text(),'Incident #')]")); // Get the created incident number
        String createdIncidentNumberSrt = createdIncidentNumber.getText();

        String substring ="";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(createdIncidentNumberSrt);
        while (m.find())
        {
            substring =m.group();
            System.out.println("The new Incident is successfully created. It was given a " + substring + " number.");
        }

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".drop.service-desk")).click(); //Go to Service Desk main menu
        robot.delay(600);
        driver.findElement(By.xpath(incidentsMenuItemXpath)).click(); //Select Incidents menu
        robot.delay(600);
        driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
        if (driver.findElement(By.xpath("//div[contains(@class, 'UI_GridCellInner ')][contains(text(),'" + substring + "')]")).isDisplayed()) // Verify the created Incident is displayed
        {
            System.out.println("The " + substring + " Incident is found appearing in incidents list as required");
        }
    }


    public static void main(String[] args)
    {
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
//        driver = new FirefoxDriver(dc);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Eliyahu\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
//		driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wrongCredentialsLogin();
        doLogin();
        try {
            openNewIncident();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.close();

        try
        {
            Thread.sleep(5000);
            driver.quit();
        }
        catch (Exception e)
        {
        }
    }

}
