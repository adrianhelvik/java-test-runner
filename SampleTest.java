import com.adrianhelvik.testrunner.*;

class SampleTest extends TestCase {

    public static void main(String[] args) {
        describe("A suite")
            .it("contains a spec with an expectation")
            .expect(true).toBe(true);

        describe("toBe")
            .it("tests for equality with the == operator")
            .expect(10).toBe(10)
            .it("should not work for object references")
            .expect(new String("Hello")).not.toBe(new String("Hello"));

        describe("toEqual")
            .it("tests for equality with the .equals method and should work for object references")
            .expect(new String("Hello")).toEqual(new String("Hello"))
            .it("should also work for primitives")
            .expect(1337).toEqual(1337);
    }
}
