package org.blitdz.study;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NFARuleBook  {
    private ArrayList<FARule> rules;

    public NFARuleBook(ArrayList<FARule> rules){
        this.rules = new ArrayList<>(rules);
    }

    public Set<Integer> nextStates(Set<Integer> states, char character) {
        Iterator<Integer> iterator = states.iterator();
        ArrayList<Integer> nextStates = new ArrayList<>(3);
        while(iterator.hasNext()){
            Integer state = iterator.next();
            nextStates.addAll(followRulesFor(state,character));
        }
        return new HashSet<>(nextStates);
    }

    public ArrayList<Integer> followRulesFor(Integer state, char character){
        Stream<Integer> ret = rulesFor(state,character).stream().map(FARule::follow);
        return new ArrayList<Integer>(ret.collect(Collectors.toList()));
    }

    public ArrayList<FARule> rulesFor(Integer state, char character) {
        Stream<FARule> s =  rules.stream().filter(rule -> rule.appliesTo(state,character));
        return new ArrayList<>(s.collect(Collectors.toList()));
    }


}
