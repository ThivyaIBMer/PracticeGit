package testng.tests;


import org.testng.*;

public class Listeners implements ITestListener{
	@Override		
    public void onFinish(ITestContext arg0) {					
		   System.out.println("OnFinish");				
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        System.out.println("OnStart");				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult arg0) {					
    	   System.out.println("FAiled");				
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		
}	

