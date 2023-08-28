package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HeadphoneSalesAssistantPage;
import pages.LoginPage;
import pages.MainPage;
import pages.PaymentformPage;
import pages.PersonalCoachingSubscriptionPage;
import pages.PremiumNewsletterPage;
import pages.ShoppingOrderPage;

public class PaymntformTest extends BaseTest{
	@Test
	public void tc01_OnlineClassRegistration() {
		LoginPage lp = new LoginPage(driver);
		lp.login("roic0123@gmail.com","0123456789Rc");		
		MainPage mp = new MainPage(driver);
		mp.templates();	
		mp.Categories("Payment form");
		mp.Categories("Online Class Registration");
		mp.close();
		mp.scratchfild("Online Class Registration");		
		mp.preview();		
		PaymentformPage	ocr = new PaymentformPage(driver);
		mp.close();
		ocr.signin();
		ocr.firstname("roi");
		ocr.lastname("cohen");
		ocr.email("roic0123@gmail.com");
		mp.next();
		ocr.classroom();
		ocr.studiedwithRen();
		String expected = "You can book the course below {{ roi }}";
		String actual = ocr.idealMsg();
		assertEquals(actual, expected);
		mp.toclose();
		
	}
	@Test
	public void tc02_shopping() {
		MainPage mp = new MainPage(driver);
		mp.close();
		mp.templates();	
		ShoppingOrderPage so = new ShoppingOrderPage(driver);
		mp.close();
		so.Categories("Payment form");
		so.Categories("Shopping Order Form");
		mp.scratchfild("Shopping Order Form");
		mp.preview();
		mp.close();
		so.shopnow();
		so.Categories("Business casual($135)");
		so.look();
		so.selectsize();
		so.sizeL();
		so.sizemenu("vs1__option-3");
		so.nextto();
		so.yourname("Roi");
		so.Continue();
		so.yourlastname("Cohen");
		so.youremali("roic0123@gmail.com");
		so.Continue();
		so.shipping();
		so.shippformstreet("Ha Sira");
		so.shippformpostal("85216");
		so.shippformcity("Yavne");
		so.shippformstate("israel");
		so.arrow();
		so.israel();
		so.Continue();
		String expected = "{{ Roi }}, where should we ship your attire?";
		String actual = so.orderMsg();
		assertEquals(actual, expected);
		mp.toclose();
	}
	@Test
	public void tc03_premiumNewsletter() {			
		MainPage mp = new MainPage(driver);
		mp.templates();	
		mp.Categories("Payment form");
		mp.Categories("Premium Newsletter Subscription");
		mp.close();
		mp.scratchfild("Premium Newsletter Subscription");		
		mp.preview();
		PremiumNewsletterPage pn = new PremiumNewsletterPage(driver);
		mp.next();
		pn.fillform("Roi", "Cohen", "roic0123@gmail.com");
		pn.country();
		pn.israel();
		pn.Iagree();
		mp.next();
		pn.membershipcosts();
		mp.next();
		mp.toclose();
		
	}
	@Test
	public void tc04_HeadphoneSalesAssistant() {		
		MainPage mp = new MainPage(driver);		
		mp.templates();	
		mp.Categories("Payment form");
		mp.Categories("Headphone Sales Assistant");
		mp.close();
		mp.scratchfild("Headphone Sales Assistant");		
		mp.preview();
		HeadphoneSalesAssistantPage hs = new HeadphoneSalesAssistantPage(driver);
		hs.headphones();
		mp.close();
		hs.absollutelynot();
		hs.recommendation();
		mp.next();
		String expected = "Thank you for choosing";
		String actual = hs.thankyouMsg();
		assertEquals(actual, expected);
		mp.toclose();
	}
	@Test
	public void tc05_PersonalCoachingSubscription() {				
		MainPage mp = new MainPage(driver);
		mp.templates();	
		mp.Categories("Payment form");
		mp.Categories("Personal Coaching Subscription");
		mp.close();
		mp.scratchfild("Personal Coaching Subscription");		
		mp.preview();
		PersonalCoachingSubscriptionPage pc = new PersonalCoachingSubscriptionPage (driver);
		mp.next();
		pc.fillform("Roi", "Cohen", "roic0123@gmail.com");
		pc.subscribe();
		mp.next();
		String expected = "Reach The Height\r\n"
				+ "Of Your Potential";
		String actual = pc.reachtheheightMsg();
		assertEquals(actual, expected);
	}

}
