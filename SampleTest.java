import com.adrianhelvik.testrunner.*;

class SampleTest extends TestCase {

    public static void main(String[] args) {
        describe("A suite")
            .it("contains a spec with an expectation")
            .expect(true).toBe(true);

        describe("toBe")
            .it("tests for equality with the == operator")
            .expect(10).toBe(10)
            .expect(new String("Hello")).not.toBe(new String("Helloh".substring( 0, "Helloh".length() - 1 )));

        describe("toEqual")
            .it("tests for equality with the .equals method and should work for object references")
            .expect(new String("Hello")).toEqual(new String("Hello"))
            .it("should also work for primitives")
            .expect(1337).toEqual(1337);

        describe("Timing a call is easy...")
            .it("just call time() before a test.")
            .time()
            .expect(true).toBe(true)
            .it("but maybe you don't want to test anything, just test the execution time of a function.")
            .time()
            .call("Hello world".matches("world"))
            .it("and calling the method without timinging it will just not display any time")
            .call("Hello world".matches("world"));

        describe("Comparing arrays")
            .it("should pass with toEqual if the arrays are equivalent")
            .expect( new int[] { 1, 2, 3 } ).toEqual( new int[] { 1, 2, 3 } );
    }
}
