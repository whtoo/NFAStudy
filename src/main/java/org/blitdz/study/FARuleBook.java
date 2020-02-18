package org.blitdz.study;

import java.util.ArrayList;
import java.util.Optional;

public class FARuleBook {
    private ArrayList<FARule> rules;

    public  FARuleBook(ArrayList<FARule> rules){
        this.rules  =rules;
    }
    public Optional<FARule> ruleFor(Integer state, char character){
        for (FARule rule:rules) {
            if(rule.appliesTo(state,character)){
                return Optional.of(rule);
            }
        }

        return Optional.ofNullable(null);
    }

    public int nextState(int state, char character){
        return ruleFor(state, character).get().follow();
    }
}
