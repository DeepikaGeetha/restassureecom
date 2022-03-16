package RestTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;
public class TestNG {

@BeforeSuite
public void BS() {
	System.out.println("This is going to execute first");
}

@BeforeTest
public void BT() {
	System.out.println("This is going to execute After BeforeSuite");
}

@BeforeClass
public void BC() {
	System.out.println("This is going to execute before the whole class gets executed");
}

@BeforeMethod
public void BM() {
	System.out.println("This is going to execute before every method");
}

@Test
public void TestCase1() {
	System.out.println("This is the first test method");
}

@Test
public void TestCase2() {
	System.out.println("This is the Second test method");
}

@AfterMethod
public void AM()
{
	System.out.println("After executing each test method");
}

@AfterClass
public void AC()
{
	System.out.println("This will excute after the class");
}

@AfterTest
public void AT()
{
	System.out.println("This will excute after all the test is executed");
}

@AfterSuite
public void AS()
{
	System.out.println("This will execute after evertything at the end");
}
}