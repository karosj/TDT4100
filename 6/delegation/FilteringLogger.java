package delegation;

import java.util.HashSet;
import java.util.Set;

public class FilteringLogger implements ILogger {
    private ILogger logger;
    private Set<String> severities;

    public FilteringLogger(ILogger logger, String... severities) {
        this.logger = logger;
        this.severities = new HashSet<>();
        for (String severity : severities) {
            this.severities.add(severity);
        }
    }

    public boolean isLogging(String severity) {
        return severities.contains(severity);
    }

    public void setIsLogging(String severity, boolean value) {
        if (value) {
            severities.add(severity);
        } else {
            severities.remove(severity);
        }
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        if (isLogging(severity)) {
            logger.log(severity, message, exception);
        }
    }
}