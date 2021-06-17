package zs.qeb.ty.POJOclasses;
/**
 * Pojo class for code compile output
 * @author rohit
 *
 */
public class CodeCompileOutput
{
    private String[] outputLines;

    private String start;

    private String exitCode;

    private String end;

    private String status;

    public String[] getOutputLines ()
    {
        return outputLines;
    }

    public void setOutputLines (String[] outputLines)
    {
        this.outputLines = outputLines;
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

    @Override
    public String toString()
    {
        return "ClassPojo [outputLines = "+outputLines+", start = "+start+", exitCode = "+exitCode+", end = "+end+", status = "+status+"]";
    }
}
