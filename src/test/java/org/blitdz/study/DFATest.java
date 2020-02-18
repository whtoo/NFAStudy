package org.blitdz.study;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

public class DFATest extends TestCase {
    private ArrayList<FARule> rules;
    private FARuleBook ruleBook;
    private DFA dfa;

    public DFATest(String name) {
        super(name);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DFATest.class );
    }

    @Override
    protected void setUp() throws Exception {
        ArrayList<FARule> rules = new ArrayList<>(3);
        rules.add(new FARule(1,'a',2));
        rules.add(new FARule(1,'b',1));
        rules.add(new FARule(2,'a',2));
        rules.add(new FARule(2,'b',3));
        rules.add(new FARule(3,'b',3));
        this.rules = rules;
        FARuleBook ruleBook = new FARuleBook(rules);
        this.ruleBook = ruleBook;
        int[] states = new int[2];
        states[0] = 3;
        this.dfa = new DFA(1,states,ruleBook);
    }

    @Override
    protected void tearDown() throws Exception {
        this.ruleBook = null;
        this.rules = null;
    }

    public void testAccepting() {
        int[] states = new int[2];
        states[1] = 3;
        states[0] = 2;
        dfa.updateAcceptStates(states);
        assertFalse(dfa.accepting());
    }

    public void testReadCharacter() {
        this.dfa.readCharacter('b');
        assertFalse(dfa.accepting());
        for (int i = 0; i < 3; i++) {
            dfa.readCharacter('a');
        }
        assertFalse(dfa.accepting());

        dfa.readCharacter('b');
        assertTrue(dfa.accepting());
    }

    public void testReadCharSeq() {
        String seq = "baaab";
        dfa.readCharSeq(seq);
        assertTrue(dfa.accepting());
    }
}
