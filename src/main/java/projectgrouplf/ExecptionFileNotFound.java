package projectgrouplf;

public class ExecptionFileNotFound extends Throwable {

    public ExecptionFileNotFound() {

    }

    public ExecptionFileNotFound(String message) {
        super(message);
    }

    public ExecptionFileNotFound(Throwable cause) {
        super(cause);
    }

    public ExecptionFileNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "File has invalid data";
    }
}
