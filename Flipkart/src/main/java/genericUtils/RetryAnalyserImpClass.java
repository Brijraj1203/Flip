package genericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImpClass implements IRetryAnalyzer{
	int lower=0;
	int upper=2;

	@Override
	public boolean retry(ITestResult result) {
		if(lower<upper)
		{
			lower++;
			return true;
		}
		
		return false;
	}
	

}
