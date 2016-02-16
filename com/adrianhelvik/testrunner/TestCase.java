package com.adrianhelvik.testrunner;
import com.adrianhelvik.testrunner.*;

public class TestCase {

    public static TestDescription currentDescription = null;
    public static Assertion currentAssertion = null;

    //
    // Testing boilerplate
    //

    public static void describe( String description ) {
        currentDescription = new TestDescription(description);
    }

    public static void it( String shouldDo ) {
        currentAssertion = currentDescription.it( shouldDo );
    }

    public static void xit( String shouldDo ) {
        currentAssertion = currentDescription.xit( shouldDo );
    }

    public static Expectation expect( Object value ) {
        return currentAssertion.expect( value );
    }

    public static Expectation xexpect( Object value ) {
        return currentAssertion.expect( value );
    }
}
