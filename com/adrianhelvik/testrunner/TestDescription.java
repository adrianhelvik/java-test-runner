package com.adrianhelvik.testrunner;

public class TestDescription {

    long startTime = -1;

    private String description;
    private Assertion currentAssertion;

    public TestDescription( String description ) {
        this.description = description;
    }

    public Assertion it(String expectation) {
        this.currentAssertion = new Assertion(this, expectation, false);

        return currentAssertion;
    }

    public Assertion xit(String expectation) {
        this.currentAssertion = new Assertion(this, expectation, true);

        return currentAssertion;
    }

    public Expectation expect(Object value) {
        Expectation toExpect = currentAssertion.expect(value);

        return toExpect;
    }

    public Expectation xexpect(Object value) {
        return currentAssertion.xexpect(value);
    }

    public TestDescription time() {
        this.startTime = System.nanoTime();
        return this;
    }

    @Override
    public String toString() {
        return description;
    }
}
