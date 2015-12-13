# vim command for retrieving java files:
# :read !ls **/*.java

SOURCE_FILES := \
com/adrianhelvik/testrunner/Assertion.java \
com/adrianhelvik/testrunner/Expectation.java \
com/adrianhelvik/testrunner/TestCase.java \
com/adrianhelvik/testrunner/TerminalColor.java \
com/adrianhelvik/testrunner/TestDescription.java

TEST_FILES := SampleTest.java

all:
	mkdir -p build/
	javac -d build/ ${SOURCE_FILES} ${TEST_FILES}
	cd build && java SampleTest
	cd build && rm SampleTest.class
