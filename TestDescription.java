public class TestDescription {

    private String description;

    public TestDescription( String description ) {
        this.description = description;
    }

    public Assertion it(String expectation) {
        return new Assertion(this, expectation, false);
    }

    public Assertion xit(String expectation) {
        return new Assertion(this, expectation, true);
    }

    @Override
    public String toString() {
        return description;
    }
}
