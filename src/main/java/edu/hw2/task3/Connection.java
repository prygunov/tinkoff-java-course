package edu.hw2.task3;

public sealed interface Connection extends AutoCloseable permits StableConnection, FaultyConnection {
    void execute(String command);
}
