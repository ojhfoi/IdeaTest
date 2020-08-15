package listener;

import com.codeborne.selenide.impl.ScreenShotLaboratory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.influxdb.dto.Point;
import org.testng.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class testListener implements ITestListener, ISuiteListener, IInvokedMethodListener, StepLifecycleListener {

    @Override
    public void onStart(ISuite arg0){
        Reporter.log("Test start executing " + arg0.getName(), true);
    }

    @Override
    public void onFinish(ISuite arg0){
        Reporter.log("Test finish executing ");
    }

    @Override
    public void beforeStepStop(final StepResult result){
//        if (result.equals("FAILURE")||result.equals("SKIPPED")){
            String screenshotName = Objects.requireNonNull(ScreenShotLaboratory.getInstance().getLastScreenshot()).getAbsolutePath();
            ScreenAttach(screenshotName);
//        }
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

    @Attachment()
    public static void ScreenAttach(String screenshotName){
        Path content = Paths.get(screenshotName);
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(screenshotName, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
