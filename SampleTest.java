import com.adrianhelvik.testrunner.*;

class SampleTest extends TestCase {

    public static void main(String[] args) {
        describe("A suite")
            .it("contains a spec with an expectation")
            .expect(true).toBe(true);

        describe("toBe")
            .it("tests for equality with the == operator")
            .expect(new String("Hello")).not.toBe(new String("Hello"));

        describe("toEqual")
            .it("tests for equality with the .equals method")
            .expect(new String("Hello")).toEqual(new String("Hello"));
    }
}
