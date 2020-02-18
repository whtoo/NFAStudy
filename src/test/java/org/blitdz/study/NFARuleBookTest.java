package org.blitdz.study;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.extensions.TestDecorator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NFARuleBookTest extends TestCase {
    NFARuleBook nfaRuleBook;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NFARuleBookTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( NFARuleBookTest.class );
    }

    @Override
    protected void setUp() throws Exception {
        ArrayList<FARule> rules = new ArrayList<>(3);

        rules.add(new FARule(1,'a',1));
        rules.add(new FARule(1,'b',1));
        rules.add(new FARule(1,'b',2));
        rules.add(new FARule(2,'a',3));
        rules.add(new FARule(2,'b',3));
        rules.add(new FARule(3,'a',4));
        rules.add(new FARule(3,'b',4));
        this.nfaRuleBook = new NFARuleBook(rules);
    }

    @Override
    protected void tearDown() throws Exception {
        this.nfaRuleBook = null;
    }

    public void testNextStates(){
        Set<Integer> s1 = new HashSet();
        s1.add(1);
        Set<Integer> ns1 = nfaRuleBook.nextStates(s1,'b');
        ArrayList<Integer> ls1 = new ArrayList<>(2);
        ls1.add(1);
        ls1.add(2);
        assertTrue(ns1.containsAll(ls1));
        Set<Integer> s2 = new HashSet<>(2);
        s2.add(1);
        s2.add(2);
        ns1 = nfaRuleBook.nextStates(s2,'a');
        s2.clear();
        s2.add(1);
        s2.add(3);
        assertTrue(ns1.size() == 2);
        assertTrue(ns1.contains(1));
        assertTrue(ns1.contains(3));
        ns1 = nfaRuleBook.nextStates(s2,'b');
        assertTrue(ns1.size() == 3);
        assertTrue(ns1.contains(1));
        assertTrue(ns1.contains(2));
        assertTrue(ns1.contains(4));
    }

}
