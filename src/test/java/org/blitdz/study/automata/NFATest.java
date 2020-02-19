package org.blitdz.study.automata;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NFATest extends TestCase {
    NFARuleBook nfaRuleBook;
    Set<Integer> currentStates;
    Set<Integer> acceptStates;
    NFA nfa;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NFATest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( NFATest.class );
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
        this.currentStates = new HashSet<>(2);
        currentStates.add(1);
        this.acceptStates = new HashSet<>(2);
        acceptStates.add(4);

        this.nfaRuleBook = new NFARuleBook(rules);

        this.nfa = new NFA(currentStates,acceptStates,nfaRuleBook);

    }

    @Override
    protected void tearDown() throws Exception {
        this.nfaRuleBook = null;
        this.acceptStates = null;
        this.currentStates = null;
        this.nfa = null;
    }

    public void testAccepting(){
        assertFalse(nfa.accpeting());
        acceptStates.add(1);
        currentStates.add(3);
        nfa = new NFA(currentStates,acceptStates,null);
        assertTrue(nfa.accpeting());
    }

    public void testReadChar() {
        assertFalse(nfa.accpeting());
        nfa.readCharacter('b');
        assertFalse(nfa.accpeting());
        nfa.readCharacter('a');
        assertFalse(nfa.accpeting());
        nfa.readCharacter('b');
        assertTrue(nfa.accpeting());
    }

    public void testReadSeq() {
        assertFalse(nfa.accpeting());
        assertTrue(nfa.readCharSeq("babbb").accpeting());
    }
}
