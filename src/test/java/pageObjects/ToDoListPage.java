package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToDoListPage {
	
	public ToDoListPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//header/input[1]")
	public WebElement inputToDoList;

	
	@FindBy(xpath="(//ul[@class='todo-list']/li[@class='todo']//input[@type='checkbox'])[1]")
	public WebElement firstItemInList;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Active')]")
	public WebElement activeFilter;
	
	@FindBy(xpath="//ul[@class='todo-list']/li[@class='todo']")
	public List<WebElement> activeList;
	

	@FindBy(xpath="//a[contains(text(),'Completed')]")
	public WebElement completedFilter;
	
	@FindBy(xpath="//ul[@class='todo-list']/li[@class='todo completed']")
	public List<WebElement> completedList;
	
	@FindBy(xpath="//button[contains(text(),'Clear completed')]")
	public WebElement clearCompletedButton;
	
	@FindBy(xpath="//a[contains(text(),'All')]")
	public WebElement allFilter;
	
	@FindBy(xpath="//ul[@class='todo-list']/li[@class='todo']//button[@class='destroy']")
	public List<WebElement> deleteActiveList;
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
