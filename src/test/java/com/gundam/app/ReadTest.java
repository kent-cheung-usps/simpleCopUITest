package com.gundam.app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

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
	void test_catwoman00() {
		page.navigate("https://cop-cat.usps.com/");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
		page.getByTestId("fr-field-callback_1").getByTestId("input-").click();
		page.getByTestId("fr-field-callback_1").getByTestId("input-").fill("catwoman00");
		page.getByTestId("fr-field-callback_1").getByTestId("input-").press("Tab");
		page.getByTestId("fr-field-callback_2").getByTestId("input-").fill("Cop@9075");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();

		page.waitForTimeout(5000);

		// page.getByText("Not Now").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manage Locations")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Account")).click();

		page.waitForTimeout(5000);

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
		// page.navigate("https://cop-cat.usps.com/");
	}

	@Test
	void testManageLocation() {
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

		page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("My Account")).getByRole(AriaRole.STRONG).click();

		Locator titleMsg = page.getByText("Welcome to your USPS Business Portal");
		assertThat(titleMsg).isVisible();
		assertTrue(titleMsg.textContent().contains("Welcome to your USPS Business Portal"), "Incorrect Messages");

		page.getByText("Quick Actions").click();
		page.locator("app-my-account").click();
		page.getByText("My Business Locations (1)").click();
		page.getByText("My Payment Accounts (1)").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manage Locations")).click();
		page.getByText("Manage Locations", new Page.GetByTextOptions().setExact(true)).click();
		page.getByText("You can manage you current").click();
		page.getByText("Mail Owner CRID").click();
		page.getByText("Business Location", new Page.GetByTextOptions().setExact(true)).click();
		page.getByText("95178918").click();
		page.getByText("E 14TH ST AUSTIN TX 78702").click();
		page.getByText("This Home location is not").click();
		page.getByText("901117829").click();
		page.getByText("901117830").click();
		page.getByText("901117831").click();
		page.getByText("OUTBOUND").first().click();
		page.getByText("OUTBOUND").nth(1).click();
		page.getByText("RETURNS").click();
		page.getByText("CAT Merchant Test Inc").nth(1).click();
		page.getByText("CAT Merchant Test Inc").nth(2).click();
		page.getByText("CAT Merchant Test Inc").nth(3).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
		page.navigate("https://cop-cat.usps.com/");
	}

}
