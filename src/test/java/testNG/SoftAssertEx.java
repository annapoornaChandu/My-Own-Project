package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}
	
	@Test
	public void m2()
	{
		String exp = "Anu";
		String act = "Anu";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(act, exp);
		soft.assertAll();
		
		
	}
	
	
	
	

}
