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

	/**
	 * Rigorous Test :-) Disabled - Save for references
	 */
	// @Test
	public void shouldAnswerWithTrue() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate(
					"https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AeZLP9_RPyHjc6ZxTkaASC7X66tYDsWiVzxG2xmnN_uXsdz0j_qfudK-G8B1Mly3HEz1JToxArmnpg&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S37105020%3A1734309634897359&ddm=1");
			page.getByLabel("Email or phone").fill("two.tester2@gmail.com");
			page.getByLabel("Email or phone").press("Enter");

			page.waitForTimeout(5000);
		}
	}

	@Test
	void test_catwoman00_2025_06_14() {
		page.navigate("https://cop-cat.usps.com/");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
		page.getByTestId("fr-field-callback_1").getByTestId("input-").click();
		page.getByTestId("fr-field-callback_1").getByTestId("input-").fill("catwoman00");
		page.getByTestId("fr-field-callback_1").getByTestId("input-").press("Tab");
		page.getByTestId("fr-field-callback_2").getByTestId("input-").fill("Cop@9075");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
		// page.locator("label").filter(new Locator.FilterOptions().setHasText("Not Now")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();

		page.waitForTimeout(5000);

		Locator landingTitle = page.getByText("Business Customer Onboarding");
		assertThat(landingTitle).isVisible();
		assertTrue(landingTitle.textContent().contains("Business Customer Onboarding"),"Incorrect text for My Business Locations");
		
		// Assertion with exact string match
		assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText("You've successfully registered your USPS Business Account.")).nth(3))
				.hasText("You've successfully registered your USPS Business Account.");

		Locator myBusinessLocations = page.getByText("My Business Locations (1)");

		assertThat(myBusinessLocations).isVisible();
		assertTrue(myBusinessLocations.textContent().contains("My Business Locations (1)"),
				"Incorrect text for My Business Locations");

				
		Locator myPaymentAccounts = page.getByText("My Payment Accounts (1)");
		assertThat(myPaymentAccounts).isVisible();
				
		assertTrue(myPaymentAccounts.textContent().contains("My Payment Accounts (1)"),
				"Incorrect text for My Payment Accounts");
				

		Locator manageLocationsBtn = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Manage Locations"));
		assertThat(manageLocationsBtn).isVisible();
		assertTrue(manageLocationsBtn.textContent().contains("Manage Locations"),
				"Incorrect text for Manage Locations button");

		Locator manageLocationsExact = page.getByText("Manage Locations", new Page.GetByTextOptions().setExact(true));
		assertThat(manageLocationsExact).isVisible();
		assertTrue(manageLocationsExact.textContent().contains("Manage Locations"),
				"Incorrect text for Manage Locations");

		Locator id95178918 = page.getByText("95178918");
		// 
		assertThat(id95178918).isVisible();
		assertTrue(id95178918.textContent().contains("95178918"), "Incorrect text for 95178918");

		// Locator addressAustin = page.getByText("3100 E 14TH ST AUSTIN TX 78702");
		// 
		// sertThat(addressAustin).isVisible();
		// assertTrue(addressAustin.textContent().contains("E 14TH ST AUSTIN TX 78702"),
		// "Incorrect text for address");

		// Locator homeLocationText = page.getByText("This Home location is not");
		// 
		// assertThat(homeLocationText).isVisible();
		// assertTrue(homeLocationText.textContent().contains("This Home location is
		// not"),
		// "Incorrect text for Home location");
		// 

		// Locator id901117829 = page.getByText("901117829");
		// assertThat(id901117829).isVisible();
		// assertTrue(id901117829.textContent().contains("901117829"), "Incorrect text
		// 
		// for 901117829");

		// Locator id901117830 = page.getByText("901117830");
		// assertThat(id901117830).isVisible();
		// 
		// assertTrue(id901117830.textContent().contains("901117830"), "Incorrect text
		// for 901117830");

		// Locator id901117831 = page.getByText("901117831");
		// 
		// assertThat(id901117831).isVisible();
		// assertTrue(id901117831.textContent().contains("901117831"), "Incorrect text
		// for 901117831");

		// 
		// Locator outboundFirst = page.getByText("OUTBOUND").first();
		// assertThat(outboundFirst).isVisible();
		// assertTrue(outboundFirst.textContent().contains("OUTBOUND"), "Incorrect text
		// for OUTBOUND (first)");
 
		// Locator outboundSecond = page.getByText("OUTBOUND").nth(1);
		// assertThat(outboundSecond).isVisible();
		// assertTrue(outboundSecond.textContent().contains("OUTBOUND"), "Incorrect text
		// for OUTBOUND (second)");
 
		// Locator returnsText = page.getByText("RETURNS");
		// assertThat(returnsText).isVisible();
		// assertTrue(returnsText.textContent().contains("RETURNS"), "Incorrect text for
		// RETURNS");
 
		// Locator catMerchant1 = page.getByText("CAT Merchant Test Inc").nth(1);
		// assertThat(catMerchant1).isVisible();
		// assertTrue(catMerchant1.textContent().contains("CAT Merchant Test Inc"),
		// "Incorrect text for CAT Merchant Test Inc (1)");

		// Locator catMerchant2 = page.getByText("CAT Merchant Test Inc").nth(2);
		// assertThat(catMerchant2).isVisible();
		// assertTrue(catMerchant2.textContent().contains("CAT Merchant Test Inc"),
		// "Incorrect text for CAT Merchant Test Inc (2)");

		// Locator catMerchant3 = page.getByText("CAT Merchant Test Inc").nth(3);
		// assertThat(catMerchant3).isVisible();
		// assertTrue(catMerchant3.textContent().contains("CAT Merchant Test Inc"),
		// "Incorrect text for CAT Merchant Test Inc (3)");

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
		page.navigate("https://cop-cat.usps.com/");
	}

}
