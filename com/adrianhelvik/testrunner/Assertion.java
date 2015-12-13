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

    public Expectation xexpect(Object value) {
        beSilent();
        Expectation result = new Expectation(this, this.description, value, silent);
        dontBeSilent();
        return result;
    }

    public void dontBeSilent() {
        this.silent = false;
    }

    public void beSilent() {
        this.silent = true;
    }

    public Assertion time() {
        description.time();
        return this;
    }

    @Override
    public String toString() {
        return expectation;
    }
}

