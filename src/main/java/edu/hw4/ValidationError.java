package edu.hw4;

public enum ValidationError {
    NAME_IS_NULL(Constants.NAME, "Name can not be null"),
    NAME_IS_EMPTY(Constants.NAME, "Name can not be empty"),
    TYPE_IS_NULL("type", "Type can not be null"),
    SEX_IS_NULL("sex", "Sex can not be null"),
    NEGATIVE_AGE("age", "Age must be more than 0"),
    NEGATIVE_HEIGHT("height", "Height must be more than 0"),
    NEGATIVE_WEIGHT("weight", "Weight must be more than 0"),
    SPIDER_DOESNT_BITE("bites", "Spiders do no bite");

    private final String fieldName;
    private final String message;

    ValidationError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

    private static class Constants {
        public static final String NAME = "name";
    }
}
