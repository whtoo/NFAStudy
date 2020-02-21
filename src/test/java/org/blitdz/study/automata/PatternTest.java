package org.blitdz.study.automata;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.blitdz.study.regex.*;

public class PatternTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PatternTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PatternTest.class);
    }

    public void testPattern() {
        IPrecedence pattern = new Repeat(new Choose(
                new Concatenate(new Literal("a"), new Literal("b")),
                new Literal("a")
        ));

        assertEquals(pattern.toString(), "(ab|a)*");
    }

}
