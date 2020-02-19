package org.blitdz.study.automata;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

public class FARuleBookTest extends TestCase {
    private ArrayList<FARule> rules;
    private FARuleBook ruleBook;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FARuleBookTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FARuleBookTest.class );
    }

    @Override
    protected void setUp() throws Exception {
        ArrayList<FARule> rules = new ArrayList<>(3);
        rules.add(new FARule(1,'a',2));
        rules.add(new FARule(1,'b',1));
        this.rules = rules;
        FARuleBook ruleBook = new FARuleBook(rules);
        this.ruleBook = ruleBook;
    }

    @Override
    protected void tearDown() throws Exception {
        this.ruleBook = null;
        this.rules = rules;
    }

    public void testNextState(){

        assertTrue(ruleBook.nextState(1,'a') == 2);
        assertFalse(ruleBook.nextState(1,'b') == 2);
    }

    public void testRuleFor(){
        assertEquals(ruleBook.ruleFor(1,'a').get(),(rules.get(0)));
        assertEquals(ruleBook.ruleFor(1,'b').get(),(rules.get(1)));
        assertFalse(ruleBook.ruleFor(1,'c').isPresent());
    }
}
