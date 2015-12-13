package com.adrianhelvik.testrunner;

public class TestDescription {

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
        return currentAssertion.expect(value);
    }

    @Override
    public String toString() {
        return description;
    }
}
