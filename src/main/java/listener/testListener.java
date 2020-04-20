package listener;

import org.influxdb.dto.Point;
import org.testng.*;

import java.util.concurrent.TimeUnit;


public class testListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    @Override
    public void onStart(ISuite arg0){
        Reporter.log("Test start executing " + arg0.getName(), true);
    }

    @Override
    public void onFinish(ISuite arg0){
        Reporter.log("Test finish executing ");
    }

    public void onStart(ITestContext arg0){
        Reporter.log("Test start executing " + arg0.getName(), true);
    }

    public void onFinish(ITestContext arg0){
        Reporter.log("Test finish executing " + arg0.getName(), true);
    }

    public void onTestSuccess(ITestResult arg0){
        this.printResult(arg0, "PASS");
    }

    public void onTestFailure(ITestResult arg0){
        this.printResult(arg0, "FAILURE");
    }

    public void onTestStart(ITestResult arg0){
        this.printResult(arg0, "START");
    }

    public void onTestSkipped(ITestResult arg0){
        this.printResult(arg0, "SKIPPED");
    }

    private void printResult(ITestResult result, String status){
       Point point = Point.measurement("testmethod")
               .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
               .tag("testclass", result.getTestClass().getName())
               .tag("name", result.getName())
               .tag("description", result.getMethod().getDescription())
               .tag("result", status)
               .addField("duration", (result.getEndMillis() - result.getStartMillis()))
               .build();
//       InfSend.send(point);
    }

}
