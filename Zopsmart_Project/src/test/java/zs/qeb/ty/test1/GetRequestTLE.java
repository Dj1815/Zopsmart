package zs.qeb.ty.test1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import zs.qeb.ty.POJOclasses.CodeRunOutputList;
import zs.qeb.ty.POJOclasses.TLEPojo;
import zs.qeb.ty.genericutils.BaseURI;
import zs.qeb.ty.genericutils.EndPoints;

public class GetRequestTLE {

	@Test
	public void getRequestTimeLimitExceed() {

		SoftAssert softAssert = new SoftAssert();

		Response responeTLE = RestAssured.get(BaseURI.URI + EndPoints.timeLimitExceed);
		TLEPojo success = responeTLE.as(TLEPojo.class, ObjectMapperType.JACKSON_1);

		responeTLE.then().log().all();

		// to validate status code
		int actualStatusCode = responeTLE.getStatusCode();
		assertEquals(actualStatusCode, 200);

		// to validate content types
		String actualContentType = responeTLE.header("Content-Type");
		softAssert.assertEquals(actualContentType, "text/html; charset=utf-8");

		// to validate content encoding
		String contentEncoding = responeTLE.header("Content-Encoding");
		softAssert.assertEquals(contentEncoding, "gzip");

		// to validate main status
		String actualStatus = success.getStatus();
		softAssert.assertEquals(actualStatus, "FAILED");

		// to validate code compile output status
		String codeCompileStatus = success.getCodeCompileOutput().getStatus();
		softAssert.assertEquals(codeCompileStatus, "COMPILATION_PASSED");

		// to validate code compile output exit code
		String exitCodeComplieOutput = success.getCodeCompileOutput().getExitCode();
		softAssert.assertEquals(exitCodeComplieOutput, "0");

		CodeRunOutputList[] codeRunOutPut = success.getCodeRunOutputList();

		// to validate code run output list status
		for (CodeRunOutputList statusRun : codeRunOutPut) {
			// statusRun.getStatus();
			if (statusRun.getStatus().equals("PASSED")) {

				// to validate exit code of code run output List
				String exitCodeOutputList = statusRun.getExitCode();
				softAssert.assertEquals(exitCodeOutputList, "0");

				// to validate execution status
				String executionStatus = statusRun.getExecutionStatus();
				softAssert.assertEquals(executionStatus, "Completed");
			} else {
				// to validate exit code of code run output List
				String exitCodeOutputList = statusRun.getExitCode();
				softAssert.assertEquals(exitCodeOutputList, "1");

				// to validate execution status
				String executionStatus = statusRun.getExecutionStatus();
				if (executionStatus.equals("Pending") || executionStatus.equals("Completed")) {
					System.out.println(executionStatus);
				}

			}
		}

		softAssert.assertAll();
	}

}
