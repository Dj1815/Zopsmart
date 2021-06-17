package zs.qeb.ty.test1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import zs.qeb.ty.POJOclasses.CodeRunOutputList;
import zs.qeb.ty.POJOclasses.FailurePojo;
import zs.qeb.ty.genericutils.BaseURI;
import zs.qeb.ty.genericutils.EndPoints;

public class GetRequestFailure {

	@Test
	public void getRequestFailure() {

		SoftAssert softAssert = new SoftAssert();

		Response responseFailure = RestAssured.get(BaseURI.URI + EndPoints.failure);

		FailurePojo failure = responseFailure.as(FailurePojo.class, ObjectMapperType.JACKSON_1);
		responseFailure.then().log().all();

		// to validate status code
		int actualStatusCode = responseFailure.getStatusCode();
		assertEquals(actualStatusCode, 200);

		// to validate content types
		String actualContentType = responseFailure.header("Content-Type");
		softAssert.assertEquals(actualContentType, "text/html; charset=utf-8");

		// to validate content encoding
		String contentEncoding = responseFailure.header("Content-Encoding");
		softAssert.assertEquals(contentEncoding, "gzip");

		// to validate main status
		String actualStatus = failure.getStatus();
		softAssert.assertEquals(actualStatus, "FAILED");

		// to validate code compile output status
		String codeCompileStatus = failure.getCodeCompileOutput().getStatus();
		softAssert.assertEquals(codeCompileStatus, "COMPILATION_PASSED");

		// to validate code compile output exit code
		String exitCodeComplieOutput = failure.getCodeCompileOutput().getExitCode();
		softAssert.assertEquals(exitCodeComplieOutput, "0");

		CodeRunOutputList[] codeRunOutPut = failure.getCodeRunOutputList();

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
				softAssert.assertEquals(exitCodeOutputList, "0");

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
