package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    private static final float DEFAULT_FAIL_PERCENTAGE = 0.1f;
    private final float failPercentage;
    private final Random random;

    public DefaultConnectionManager() {
        random = new Random();
        failPercentage = DEFAULT_FAIL_PERCENTAGE;
    }

    public DefaultConnectionManager(float failPercentage) {
        random = new Random();
        this.failPercentage = failPercentage;
    }

    @Override
    public Connection getConnection() {
        float randomPercentage = random.nextFloat();
        if (randomPercentage < failPercentage) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
