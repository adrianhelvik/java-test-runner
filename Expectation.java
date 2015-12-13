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

        this.passed = this.value == value;

        return evaluate();
    }

    public TestDescription toEqual(Object value) {

        if (silent)
            return this.description;

        this.passed = this.value.equals(value);

        return evaluate();
    }

    TestDescription evaluate() {

        if (negated) negate();

        System.out.println( this.message() );

        return this.description;
    }

    String message() {
        if (passed) {
            return "Test passed: " + description + " " + assertion;
        }

        return "FAILURE --- Expected: " + description + " " + assertion + ", but " + this.value + (negated ? " = " : " ≠ ") + value;
    }

    void negate() {
            this.passed = ! this.passed;
    }
}
