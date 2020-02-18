package org.blitdz.study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NFA {
    private Set<Integer> currentStates;
    private Set<Integer> acceptStates;
    private NFARuleBook ruleBook;
    public NFA(Set<Integer> currentStates, Set<Integer> accpetStates,NFARuleBook ruleBook){
        this.currentStates = new HashSet<>(currentStates);
        this.acceptStates = new HashSet<>(accpetStates);
        this.ruleBook = ruleBook;
    }

    public boolean accpeting() {
        boolean intersection = false;
        if((currentStates.size() != 0 && acceptStates.size() != 0) || (currentStates.size() == 0 && acceptStates.size() == 0) ){
            Set tmpStates = new HashSet(currentStates);
            tmpStates.retainAll(acceptStates);
            intersection = tmpStates.size() > 0;
        }

        return intersection;
    }

    protected NFA readCharacter(char c) {
        this.currentStates = this.ruleBook.nextStates(currentStates,c);
        return this;
    }

    public NFA readCharSeq(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            readCharacter(c);
        }
        return this;
    }
}
