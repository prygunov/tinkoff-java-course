package edu.hw2.task3;

public final class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
        throw new ConnectionException("Failed to execute command " + command);
    }

    @Override
    public void close() throws Exception {
        throw new ConnectionException("Failed to close connection");
    }
}
