package com.gundam.app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;
import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@UsePlaywright
public class ReadTest {
	
	public static final int WAIT_SEC = 1000;

	static Playwright playwright;
	static Browser browser;
	BrowserContext context;
	Page page;

	@BeforeAll
	static void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	}

	@AfterAll
	static void tearDown() {
		browser.close();
		playwright.close();
	}

	@BeforeEach
	void createContextAndPage() {
		context = browser.newContext();
		page = context.newPage();
	}

	@AfterEach
	void closeContext() {
		context.close();
	}

	public static void highlightElement(Locator locator) {
		locator.evaluate("element => element.style.border = '5px solid magenta'");
	}

	@Test
	void test_catwoman00_2025_06_14() {
		page.navigate("https://cop-cat.usps.com/");
		page.waitForTimeout(WAIT_SEC);

		Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In"));
		highlightElement(loginButton);
		loginButton.click();
		page.waitForTimeout(WAIT_SEC);

		Locator usernameField = page.getByTestId("fr-field-callback_1").getByTestId("input-");
		highlightElement(usernameField);
		// usernameField.click();
		page.waitForTimeout(WAIT_SEC);
		usernameField.fill("catwoman00");
		// usernameField.press("Tab");

		Locator passwordField = page.getByTestId("fr-field-callback_2").getByTestId("input-");
		highlightElement(passwordField);
		page.waitForTimeout(WAIT_SEC);
		passwordField.fill("Cop@9075");

		Locator signInButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In"));
		highlightElement(signInButton);
		page.waitForTimeout(WAIT_SEC);
		signInButton.click();

		page.waitForTimeout(5000);

		Locator landingTitle = page.getByText("Business Customer Onboarding");
		highlightElement(landingTitle);
		page.waitForTimeout(WAIT_SEC);

		// page.evaluate("element => element.style.border = '3px solid red'", landingTitle);
		assertThat(landingTitle).isVisible();
		assertTrue(landingTitle.textContent().contains("Business Customer Onboarding"),
				"Incorrect text for My Business Locations");

		// Assertion with exact string match
		assertThat(page.locator("div:has-text('successfully registered your USPS Business Account.')").nth(3))
				.isVisible();

		Locator yourCompanyInfo = page.getByText("Your Company Information");
		highlightElement(yourCompanyInfo);
		page.waitForTimeout(WAIT_SEC);
		assertThat(yourCompanyInfo).isVisible();
		assertTrue(yourCompanyInfo.textContent().contains("Your Company Information"));
		assertTrue(yourCompanyInfo.textContent().contains("Your Company Information"),
				"Incorrect text for Your Company Information");

		Locator addressCatMerchant = page.getByText("Address CAT Merchant Test Inc");
		highlightElement(addressCatMerchant);
		page.waitForTimeout(WAIT_SEC);
		assertThat(addressCatMerchant).isVisible();
		System.out.println("Actual text content: " + addressCatMerchant.textContent());
		assertTrue(addressCatMerchant.textContent().contains("CAT Merchant Test"), "Incorrect CAT Merchant Test");

		Locator nameCatMerchantPhone = page.getByText("Name CAT MerchantPhone Number");
		highlightElement(nameCatMerchantPhone);
		page.waitForTimeout(WAIT_SEC);

		assertThat(nameCatMerchantPhone).isVisible();
		assertTrue(nameCatMerchantPhone.textContent().contains("Name CAT MerchantPhone Number"),
				"Incorrect CAT MerchantPhone Number");

		Locator email = page.getByText("Email");
		highlightElement(email);
		page.waitForTimeout(WAIT_SEC);

		assertThat(email).isVisible();
		assertTrue(email.textContent().contains("Email"), "Incorrect Email Label");

		Locator businessAccountHas = page.getByText("Your business account has");
		highlightElement(businessAccountHas);
		page.waitForTimeout(WAIT_SEC);

		assertThat(businessAccountHas).isVisible();
		assertTrue(businessAccountHas.textContent().contains("Your business account has"),
				"Incorrect Your business account Label");

		Locator cridLabel = page.getByText("Customer Registration ID (CRID):");
		highlightElement(cridLabel);
		page.waitForTimeout(WAIT_SEC);

		assertThat(cridLabel).isVisible();
		assertTrue(cridLabel.textContent().contains("Customer Registration ID (CRID):"),
				"Incorrect Customer Registration ID Label");

		Locator outboundMidLabel = page.getByText("Outbound Mailer ID (MID):");
		highlightElement(outboundMidLabel);
		page.waitForTimeout(WAIT_SEC);

		assertThat(outboundMidLabel).isVisible();
		assertTrue(outboundMidLabel.textContent().contains("Outbound Mailer ID (MID):"),
				"Incorrect Outbound Mailer ID Label");

		Locator returnMidLabel = page.getByText("Return Mailer ID (MID):");
		highlightElement(returnMidLabel);
		page.waitForTimeout(WAIT_SEC);

		assertThat(returnMidLabel).isVisible();
		assertTrue(returnMidLabel.textContent().contains("Return Mailer ID (MID):"), "Incorrect Return Mailer ID");

		Locator returnMidValue = page.getByText("Return Mailer ID (MID): 901117831");
		highlightElement(returnMidValue);
		page.waitForTimeout(WAIT_SEC);

		assertThat(returnMidValue).isVisible();
		assertTrue(returnMidValue.textContent().contains("901117831"), "Incorrect 901117831");

		Locator outboundMidValue = page.getByText("Outbound Mailer ID (MID): 901117829 (MASTER)");
		highlightElement(outboundMidValue);
		page.waitForTimeout(WAIT_SEC);

		assertThat(outboundMidValue).isVisible();
		assertTrue(outboundMidValue.textContent().contains("Outbound Mailer ID (MID): 901117829 (MASTER)"),
				"Incorrect Outbound Mailer ID");

		Locator cridValue = page.getByText("Customer Registration ID (CRID): 95178918");
		highlightElement(cridValue);
		page.waitForTimeout(WAIT_SEC);

		assertThat(cridValue).isVisible();
		assertTrue(cridValue.textContent().contains("Customer Registration ID (CRID): 95178918"),
				"Incorrect Customer Registration ID");

		Locator businessLocationsFaqs = page.getByText("Business Locations FAQs");
		highlightElement(businessLocationsFaqs);
		page.waitForTimeout(WAIT_SEC);

		assertThat(businessLocationsFaqs).isVisible();
		assertTrue(businessLocationsFaqs.textContent().contains("Business Locations FAQs"),
				"Incorrect Business Locations FAQs");

		Locator whatIsCrid = page.getByText("What is a CRID?");
		highlightElement(whatIsCrid);
		page.waitForTimeout(WAIT_SEC);

		assertThat(whatIsCrid).isVisible();
		assertTrue(whatIsCrid.textContent().contains("What is a CRID?"), "Incorrect What is a CRID");

		Locator cridDescription = page
				.getByText("The Customer Registration ID (CRID) is a number that identifies your physical");
		highlightElement(cridDescription);
		page.waitForTimeout(WAIT_SEC);

		assertThat(cridDescription).isVisible();
		assertTrue(cridDescription.textContent()
				.contains("The Customer Registration ID (CRID) is a number that identifies your physical"),
				"Incorrect The Customer Registration ID");

		Locator whatIsMid = page.getByText("What is a MID?");
		highlightElement(whatIsMid);
		page.waitForTimeout(WAIT_SEC);

		assertThat(whatIsMid).isVisible();
		assertTrue(whatIsMid.textContent().contains("What is a MID?"), "Incorrect What is a MID");

		Locator midDescription = page.getByText("The Mailer Identification");
		highlightElement(midDescription);
		page.waitForTimeout(WAIT_SEC);

		assertThat(midDescription).isVisible();
		assertTrue(midDescription.textContent().contains("The Mailer Identification"),
				"Incorrect The Mailer Identification");

		Locator whatIsEps = page.getByText("What is an EPS Account Number?");
		highlightElement(whatIsEps);
		page.waitForTimeout(WAIT_SEC);

		assertThat(whatIsEps).isVisible();
		assertTrue(whatIsEps.textContent().contains("What is an EPS Account Number?"),
				"Incorrect What is an EPS Account Number");

		Locator epsDescription = page.getByText("The Enterprise Payment System");
		highlightElement(epsDescription);
		page.waitForTimeout(WAIT_SEC);

		assertThat(epsDescription).isVisible();
		assertTrue(epsDescription.textContent().contains("The Enterprise Payment System"),
				"Incorrect The Enterprise Payment System");

		Locator youCanAdd = page.getByText("You can add additional");
		youCanAdd.scrollIntoViewIfNeeded();
		highlightElement(youCanAdd);
		page.waitForTimeout(WAIT_SEC);

		assertThat(youCanAdd).isVisible();
		assertTrue(youCanAdd.textContent().contains("You can add additional"), "Incorrect You can add additional");

		Locator epsAccountInfo = page.getByText("Enterprise Payment System (EPS) Account Information");		
		highlightElement(epsAccountInfo);
		page.waitForTimeout(WAIT_SEC);

		assertThat(epsAccountInfo).isVisible();
		assertTrue(epsAccountInfo.textContent().contains("Enterprise Payment System (EPS) Account Information"),
				"Incorrect Enterprise Payment System (EPS) Account Information");

		Locator chooseExistingActive = page.getByText("Choose an existing, active");
		highlightElement(chooseExistingActive);
		page.waitForTimeout(WAIT_SEC);

		assertThat(chooseExistingActive).isVisible();
		assertTrue(chooseExistingActive.textContent().contains("Choose an existing, active"),
				"Incorrect Choose an existing active");

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
		// page.navigate("https://cop-cat.usps.com/");
	}

}
