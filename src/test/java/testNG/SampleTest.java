package testNG;

import org.testng.annotations.Test;

public class SampleTest {
	//priority
	//enables
	//invocationCount


/*	@Test(priority = 1)
	public void createProduct()
	{
		System.out.println("product created");
	}
	@Test(priority = -1)
	public void modifyProduct()
	{
		System.out.println("product modified");
	} 
	
	@Test(enabled = false)
	public void modifyProduct()
	{
		System.out.println("product modified");
	
	
	
	@Test(priority = 2)
	public void deleteProduct()
	{
		System.out.println("product deleted");
	} */
	
	
	
	@Test(invocationCount = 3)
	public void createProduct()
	{
		System.out.println("product created");
	}
	
	
	@Test
	public void modifyProduct()
	{
		System.out.println("product modified");
	}
	
	
	
	@Test
	public void deleteProduct()
	{
		System.out.println("product deleted");
	}

}
