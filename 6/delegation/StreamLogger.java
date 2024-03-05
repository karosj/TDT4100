package delegation;

import java.io.OutputStream;

public class StreamLogger implements ILogger {
    private OutputStream stream;
    private String format = "%s: %s (%s)";

    public StreamLogger(OutputStream stream) {
        super();
        this.stream = stream;
    }

    public void setFormatString(String formatString) {
        this.format = formatString;
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        message = String.format(format, severity, message, exception);

        try {
            stream.write(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
