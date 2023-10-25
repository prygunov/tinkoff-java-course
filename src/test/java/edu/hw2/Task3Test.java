package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    public void testTryExecuteSuccess() {
        int maxAttempts = 3;
        ConnectionManager manager = new DefaultConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, maxAttempts);

        Assertions.assertDoesNotThrow(executor::updatePackages);
    }


    @Test
    public void testTryExecuteFailureDefaultManager() {
        int maxAttempts = 3;
        ConnectionManager manager = new DefaultConnectionManager(1);
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, maxAttempts);

        Assertions.assertThrows(ConnectionException.class, executor::updatePackages);
    }

    @Test
    public void testTryExecuteFailureFaultyManager() {
        int maxAttempts = 3;
        ConnectionManager manager = new FaultyConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, maxAttempts);

        Assertions.assertThrows(ConnectionException.class, executor::updatePackages);
    }
}
