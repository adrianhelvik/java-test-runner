package com.adrianhelvik.testrunner;

public class Expectation {

    private boolean negated;
    private Object value;
    private boolean passed;
    private TestDescription description;
    private Assertion assertion;
    private boolean silent;

    public Expectation not;

    public Expectation(Assertion assertion, TestDescription description, Object value, boolean silent) {
        this.assertion = assertion;
        this.description = description;
        this.value = value;
        this.negated = false;
        this.silent = silent;

        this.not = new Expectation(this, true);
    }

    private Expectation(Expectation other, boolean negated) {
        this.assertion = other.assertion;
        this.description = other.description;
        this.value = other.value;
        this.silent = other.silent;
        this.negated = negated;
    }

    public TestDescription toBe(Object value) {

        if (silent)
            return this.description;

        try {
            this.passed = this.value == value;
        } catch (Exception e) {
            this.passed = false;
        }

        return evaluate(value);
    }

    public TestDescription toEqual(Object value) {

        if (silent)
            return this.description;

        try {
            this.passed = this.value.equals(value);
        } catch (Exception e) {
            this.passed = false;
        }

        return evaluate(value);
    }

    TestDescription evaluate(Object value) {

        if (negated) negate();

        System.out.println( this.message(value) );

        return this.description;
    }

    String message(Object value) {
        String time = "";

        if (description.startTime != -1) {
            time = TerminalColor.blue(" in " + (System.nanoTime() - description.startTime) + " nano seconds.");
            description.startTime = -1;
        }

        if (passed) {
            return TerminalColor.green("Test passed: " + description + " " + assertion + time);
        }

        String message = "FAILURE --- Expected: " + description + " " + assertion + ". ";

        if (negated)
            message += this.value + " was " + value;
        else
            message += this.value + " was not " + value;

        return TerminalColor.red( message );
    }

    void negate() {
            this.passed = ! this.passed;
    }
}
