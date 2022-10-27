package stepDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.ToDoListPage;

public class ToDoList {

	public static WebDriver driver;
	ToDoListPage todoPageObject;
	ConfigFileReader configFileReader;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
	}

	@Given("I am in todo mvc webpage")
	public void i_am_in_todo_mvc_webpage() {
		configFileReader= new ConfigFileReader();
		driver.get(configFileReader.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@When("I enter the details in the textbox")
	public void i_enter_the_details_in_the_textbox(List<String> dataTable) {
		todoPageObject = new ToDoListPage(driver);
		Iterator<String> it = dataTable.iterator();	
		while (it.hasNext()) {
			todoPageObject.inputToDoList.sendKeys(it.next());
			todoPageObject.inputToDoList.sendKeys(Keys.RETURN);

			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		}
		Assert.assertEquals(4, todoPageObject.activeList.size());

	}

	@When("I mark item as complete and verify filter count is correct")
	public void i_mark_item_as_complete_and_verify_filter_count_is_correct() {
		todoPageObject = new ToDoListPage(driver);
		todoPageObject.firstItemInList.click();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		// Verify Active filter has 3 items
		todoPageObject.activeFilter.click();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);		
		Assert.assertEquals(3, todoPageObject.activeList.size());

		// Verify completed filter has 1 item
		todoPageObject.completedFilter.click();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		Assert.assertEquals(1, todoPageObject.completedList.size());

	}

	@Then("clear the completed items")
	public void clear_the_completed_items() {
		todoPageObject = new ToDoListPage(driver);
		todoPageObject.clearCompletedButton.click();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);

// Verify completed list is empty now

		todoPageObject.completedFilter.click();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		Assert.assertEquals(0, todoPageObject.completedList.size());

		todoPageObject.allFilter.click();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@Then("delete remaining items in the list")
	public void delete_remaining_items_in_the_list() {
		todoPageObject = new ToDoListPage(driver);		
		for (WebElement delete : todoPageObject.deleteActiveList) {
			delete.click();
		}
	}
	

	@After
	public void tearDown() {
		driver.quit();

	}

}
