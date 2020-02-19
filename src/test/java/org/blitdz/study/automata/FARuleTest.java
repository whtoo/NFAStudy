package org.blitdz.study.automata;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FARuleTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FARuleTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FARuleTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFARuleAppliesTo()
    {
        FARule rule1 = new FARule(1,'a',2);
        boolean flag = rule1.appliesTo(1,'a');
        assertTrue( flag );
    }

    public void testFARuleFollow()
    {
        int nextState = 2;
        FARule rule1 = new FARule(1,'a',nextState);
        int next = rule1.follow();
        assertTrue( next ==  nextState);
    }
}
