package zs.qeb.ty.POJOclasses;
/**
 * Pojo class for code run output
 * @author rohit
 *
 */
public class CodeRunOutputList
{
    private String duration;

    private String memoryConsumed;

    private String[] outputLines;

    private String reasonForFailure;

    private String executionStatus;

    private String start;

    private String exitCode;

    private String end;

    private String status;

    private String testCaseId;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getMemoryConsumed ()
    {
        return memoryConsumed;
    }

    public void setMemoryConsumed (String memoryConsumed)
    {
        this.memoryConsumed = memoryConsumed;
    }

    public String[] getOutputLines ()
    {
        return outputLines;
    }

    public void setOutputLines (String[] outputLines)
    {
        this.outputLines = outputLines;
    }

    public String getReasonForFailure ()
    {
        return reasonForFailure;
    }

    public void setReasonForFailure (String reasonForFailure)
    {
        this.reasonForFailure = reasonForFailure;
    }

    public String getExecutionStatus ()
    {
        return executionStatus;
    }

    public void setExecutionStatus (String executionStatus)
    {
        this.executionStatus = executionStatus;
    }

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    public String getExitCode ()
    {
        return exitCode;
    }

    public void setExitCode (String exitCode)
    {
        this.exitCode = exitCode;
    }

    public String getEnd ()
    {
        return end;
    }

    public void setEnd (String end)
    {
        this.end = end;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getTestCaseId ()
    {
        return testCaseId;
    }

    public void setTestCaseId (String testCaseId)
    {
        this.testCaseId = testCaseId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", memoryConsumed = "+memoryConsumed+", outputLines = "+outputLines+", reasonForFailure = "+reasonForFailure+", executionStatus = "+executionStatus+", start = "+start+", exitCode = "+exitCode+", end = "+end+", status = "+status+", testCaseId = "+testCaseId+"]";
    }
}
