package com.adrianhelvik.testrunner;

public class Assertion {

    private TestDescription description;
    private String expectation;
    private boolean silent;

    public Assertion(TestDescription description, String expectation, boolean silent) {
        this.description = description;
        this.expectation = expectation;
        this.silent = silent;
    }

    public Expectation expect(Object value) {
        return new Expectation(this, this.description, value, silent);
    }

    @Override
    public String toString() {
        return expectation;
    }
}

