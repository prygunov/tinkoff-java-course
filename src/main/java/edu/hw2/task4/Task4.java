package edu.hw2.task4;

public class Task4 {

    private Task4() {
    }

    public static CallingInfo callingInfo() {
        Exception e = new Exception();
        StackTraceElement element = e.getStackTrace()[1];
        return new CallingInfo(element.getClassName(), element.getMethodName());
    }

}
