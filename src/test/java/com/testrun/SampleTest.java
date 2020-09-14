package com.testrun;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.ObjectMapper;
import framwork.*;
import groovy.transform.stc.ClosureParams;
public class SampleTest {
	
	
public static restClientWrapper restW = new restClientWrapper();
public static requestCreateUser request;
public responseCreateUser responseObj;
public static restClientResponse response;
public static ObjectMapper mapper = new ObjectMapper();
public Logger log = null;
public ExtentHtmlReporter reporter = null;
public ExtentReports report = null;
public ExtentTest test = null;

@BeforeMethod
public void Set() {
	String path = System.getProperty("user.dir")+"\\test-output\\log4j.properties";
	PropertyConfigurator.configure(path);
	log = Logger.getLogger(SampleTest.class);
	
	reporter = new ExtentHtmlReporter("./TestResult.html");
	report = new ExtentReports();
	report.attachReporter(reporter);
	reporter.config().setDocumentTitle("Test Report");
	reporter.config().setTheme(Theme.DARK);
	reporter.config().setReportName("Test Report");
	
}
@Test
public void testRun() throws IOException {
	
	test = report.createTest("RunTest");
	log.info("Reading file");
	File file = new File("D:\\RestFrameWork\\Restapi\\src\\test\\resources\\SampleTest.csv");
	List<String[]> output = new ArrayList<String[]>();
	output = ReadCSV.readCSV(file);
	for(int i=1;i<output.size();i++) {
	request = new requestCreateUser(output.get(i)[1].toString(), output.get(i)[2].toString());
	String str = mapper.writeValueAsString(request);
	log.info("Creating User");
	response = restW.post(Constant.createUser, str);
	responseObj = mapper.readValue(response.getBody(), responseCreateUser.class);
	System.out.println(responseObj.getId());
	Assert.assertTrue(true);

	}
}
	@AfterMethod
	public void getResult(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
			log.info("Report is failed");
		}
		else
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Pass", ExtentColor.GREEN));
			log.info("Report is passed");
		}
	}
	
	@AfterSuite
	public void end() {
	report.flush();
	log.info("Extent report Generated");
	}
	}
	
  

