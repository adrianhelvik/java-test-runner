class SampleTest extends TestCase {

    public static void main(String[] args) {
        describe("A suite")
            .it("contains a spec with an expectation").expect(true).toBe(true);
    }
}
