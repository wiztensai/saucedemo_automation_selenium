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
        int priority = result.getMethod().getPriority();
        System.out.println("Starting test "+priority);
//        var threadId = Thread.currentThread().getId();
//        System.out.println("Thread Id: "+threadId);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String description = result.getMethod().getDescription();
        System.out.println("Test success: "+description);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String description = result.getMethod().getDescription();
        System.out.println("Test failed: "+description);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finish");
    }
}