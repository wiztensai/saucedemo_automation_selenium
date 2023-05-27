package cores;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Load test");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test");
        var threadId = Thread.currentThread().getId();
        System.out.println("Thread Id: "+threadId);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Test success: "+methodName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println("Test failed: "+methodName);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finish");
    }
}