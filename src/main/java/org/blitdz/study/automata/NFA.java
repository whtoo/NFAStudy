package org.blitdz.study.automata;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class NFA {
    private Set<Integer> currentStates;
    private Set<Integer> acceptStates;
    private NFARuleBook ruleBook;

    public NFA(Set<Integer> currentStates, Set<Integer> accpetStates, NFARuleBook ruleBook) {
        this.currentStates = new HashSet<>(currentStates);
        this.acceptStates = new HashSet<>(accpetStates);
        this.ruleBook = ruleBook;
    }

    public boolean accpeting() {
        boolean intersection = false;
        Set tmpStates = new HashSet(getCurrentStates());
        if ((tmpStates.size() != 0 && acceptStates.size() != 0) || (tmpStates.size() == 0 && acceptStates.size() == 0)) {
            tmpStates.retainAll(acceptStates);
            intersection = tmpStates.size() > 0;
        }

        return intersection;
    }

    protected NFA readCharacter(char c) {
        this.currentStates = this.ruleBook.nextStates(this.getCurrentStates(), c);
        return this;
    }

    public NFA readCharSeq(String s) {
        for (var c : s.toCharArray()) {
            readCharacter(c);
        }
        return this;
    }

    public Set<Integer> getCurrentStates() {
        return ruleBook.followFreeMoves(this.currentStates);
    }

    public boolean isAcceptWith(String seq) {
        readCharSeq(seq);
        return accpeting();
    }
}
