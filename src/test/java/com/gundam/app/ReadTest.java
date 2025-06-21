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

		page.waitForTimeout(5000);

		Locator landingTitle = page.getByText("Business Customer Onboarding");
		assertThat(landingTitle).isVisible();
		assertTrue(landingTitle.textContent().contains("Business Customer Onboarding"), "Incorrect text for My Business Locations");

		// Assertion with exact string match
		assertThat(page.locator("div:has-text('successfully registered your USPS Business Account.')").nth(3))
				.isVisible();

		Locator yourCompanyInfo = page.getByText("Your Company Information");
		assertThat(yourCompanyInfo).isVisible();
		assertTrue(yourCompanyInfo.textContent().contains("Your Company Information"));
		assertTrue(yourCompanyInfo.textContent().contains("Your Company Information"), "Incorrect text for Your Company Information");

		Locator addressCatMerchant = page.getByText("Address CAT Merchant Test Inc");
		assertThat(addressCatMerchant).isVisible();
		System.out.println("Actual text content: " + addressCatMerchant.textContent());
		assertTrue(addressCatMerchant.textContent().contains("CAT Merchant Test"), "Incorrect CAT Merchant Test");

		Locator nameCatMerchantPhone = page.getByText("Name CAT MerchantPhone Number");
		assertThat(nameCatMerchantPhone).isVisible();
		assertTrue(nameCatMerchantPhone.textContent().contains("Name CAT MerchantPhone Number"), "Incorrect CAT MerchantPhone Number");

		Locator email = page.getByText("Email");
		assertThat(email).isVisible();
		assertTrue(email.textContent().contains("Email"), "Incorrect Email Label");

		Locator businessAccountHas = page.getByText("Your business account has");
		assertThat(businessAccountHas).isVisible();
		assertTrue(businessAccountHas.textContent().contains("Your business account has"), "Incorrect Your business account Label");

		Locator cridLabel = page.getByText("Customer Registration ID (CRID):");
		assertThat(cridLabel).isVisible();
		assertTrue(cridLabel.textContent().contains("Customer Registration ID (CRID):"), "Incorrect Customer Registration ID Label");

		Locator outboundMidLabel = page.getByText("Outbound Mailer ID (MID):");
		assertThat(outboundMidLabel).isVisible();
		assertTrue(outboundMidLabel.textContent().contains("Outbound Mailer ID (MID):"), "Incorrect Outbound Mailer ID Label");

		Locator returnMidLabel = page.getByText("Return Mailer ID (MID):");
		assertThat(returnMidLabel).isVisible();
		assertTrue(returnMidLabel.textContent().contains("Return Mailer ID (MID):"), "Incorrect Return Mailer ID");

		Locator returnMidValue = page.getByText("Return Mailer ID (MID): 901117831");
		assertThat(returnMidValue).isVisible();
		assertTrue(returnMidValue.textContent().contains("901117831"), "Incorrect 901117831");

		Locator outboundMidValue = page.getByText("Outbound Mailer ID (MID): 901117829 (MASTER)");
		assertThat(outboundMidValue).isVisible();
		assertTrue(outboundMidValue.textContent().contains("Outbound Mailer ID (MID): 901117829 (MASTER)"), "Incorrect Outbound Mailer ID");

		Locator cridValue = page.getByText("Customer Registration ID (CRID): 95178918");
		assertThat(cridValue).isVisible();
		assertTrue(cridValue.textContent().contains("Customer Registration ID (CRID): 95178918"), "Incorrect Customer Registration ID");

		Locator businessLocationsFaqs = page.getByText("Business Locations FAQs");
		assertThat(businessLocationsFaqs).isVisible();
		assertTrue(businessLocationsFaqs.textContent().contains("Business Locations FAQs"), "Incorrect Business Locations FAQs");

		Locator whatIsCrid = page.getByText("What is a CRID?");
		assertThat(whatIsCrid).isVisible();
		assertTrue(whatIsCrid.textContent().contains("What is a CRID?"), "Incorrect What is a CRID");

		Locator cridDescription = page
				.getByText("The Customer Registration ID (CRID) is a number that identifies your physical");
		assertThat(cridDescription).isVisible();
		assertTrue(cridDescription.textContent()
				.contains("The Customer Registration ID (CRID) is a number that identifies your physical"), "Incorrect The Customer Registration ID");

		Locator whatIsMid = page.getByText("What is a MID?");
		assertThat(whatIsMid).isVisible();
		assertTrue(whatIsMid.textContent().contains("What is a MID?"), "Incorrect What is a MID");

		Locator midDescription = page.getByText("The Mailer Identification");
		assertThat(midDescription).isVisible();
		assertTrue(midDescription.textContent().contains("The Mailer Identification"), "Incorrect The Mailer Identification");

		Locator whatIsEps = page.getByText("What is an EPS Account Number?");
		assertThat(whatIsEps).isVisible();
		assertTrue(whatIsEps.textContent().contains("What is an EPS Account Number?"), "Incorrect What is an EPS Account Number");

		Locator epsDescription = page.getByText("The Enterprise Payment System");
		assertThat(epsDescription).isVisible();
		assertTrue(epsDescription.textContent().contains("The Enterprise Payment System"), "Incorrect The Enterprise Payment System");

		Locator youCanAdd = page.getByText("You can add additional");
		assertThat(youCanAdd).isVisible();
		assertTrue(youCanAdd.textContent().contains("You can add additional"), "Incorrect You can add additional");

		Locator epsAccountInfo = page.getByText("Enterprise Payment System (EPS) Account Information");
		assertThat(epsAccountInfo).isVisible();
		assertTrue(epsAccountInfo.textContent().contains("Enterprise Payment System (EPS) Account Information"), "Incorrect Enterprise Payment System (EPS) Account Information");

		Locator chooseExistingActive = page.getByText("Choose an existing, active");
		assertThat(chooseExistingActive).isVisible();
		assertTrue(chooseExistingActive.textContent().contains("Choose an existing, active"), "Incorrect Choose an existing active");

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
		page.navigate("https://cop-cat.usps.com/");
	}

}
