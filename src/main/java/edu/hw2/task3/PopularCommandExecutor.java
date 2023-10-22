package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {

    private final static Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                LOGGER.error("Failed to execute command, attempt {} of {}: {}", attempt, maxAttempts, e.getMessage());
                if (attempt == maxAttempts) {
                    throw new ConnectionException("Failed to execute command after maximum attempts", e);
                }
            } catch (Exception e) {
                throw new ConnectionException(e);
            }
        }
    }
}
