package testng.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DependencyTest {

	@Test(dependsOnGroups= {"smoke1"},enabled=false)
	public void dependMethod() {
		System.out.println("Iam inside dependMEthod");
	}
	@Test(groups= {"smoke1"},enabled=false)
	public void add() {
		System.out.println("I am in method 'g1'");
		
	}
	@Test(groups= {"smoke1"},enabled=false)
	public void update() {
		System.out.println("I am in method 'g2'");
		
	}
	
	@Test(dataProvider="testdata")
	public void addDP(String name,String Id,String mobNum,String percentage) {
		System.out.println(name+" "+"\n");
		System.out.println(Id+" "+"\n");
		System.out.println(mobNum+" "+"\n");
		System.out.println(percentage+" "+"\n");
	}
	@DataProvider(name="testdata")
	public Object[][] addData() {
		Object[][] data=new Object[3][4];
		data[0][0]="harini";
		data[0][1]="1";
		data[0][2]="9856475622";
		data[0][3]="70%";
		
		data[1][0]="Ram";
		data[1][1]="2";
		data[1][2]="8856475622";
		data[1][3]="80%";
		
		data[2][0]="Princy";
		data[2][1]="3";
		data[2][2]="7856475622";
		data[2][3]="50%";
		return data;
	}
}
