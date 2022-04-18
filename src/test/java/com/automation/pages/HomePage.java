	package com.automation.pages;

	import lombok.Getter;
	import lombok.Setter;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	@Getter
	@Setter
	public class HomePage extends BasePage {



	@FindBy(xpath="//*[@id='aab-cookie-consent-decline']")
	private WebElement cookieOption;

	@FindBy(xpath="//span[contains(text(),'Private')]")
	private WebElement accountType;

	@FindBy(xpath="//span[text()='For myself']")
	private WebElement accountFor;

	@FindBy(xpath="//span[contains(text(),'yes')]")
	private WebElement isInNL;

	@FindBy(xpath = "//*[@id='P391-C2-C1-C0-C0-C2-C0-C3-C0-C0-F0']")
	private WebElement postalCode;

	@FindBy(xpath = "//*[@id='P391-C2-C1-C0-C0-C2-C0-C3-C0-C1-F0']")
	private WebElement houseNumber;

	@FindBy(xpath="//p[text()='Gustav Mahlerlaan']")
	private WebElement filledStreet;

	@FindBy(xpath="//p[text()='Amsterdam']")
	private WebElement filledTown;

	@FindBy(xpath = "//span[contains(text(),'Tell us who')]")
	private WebElement submitButton;

	}
