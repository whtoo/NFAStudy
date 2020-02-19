package org.blitdz.study.automata;

public class FARule {
    private int state;
    private char character;
    private int next_state;

    public FARule(Integer state, char character, int next_state){
        this.state = state;
        this.character = character;
        this.next_state = next_state;
    }

    public boolean appliesTo(int state,char character){
        return this.state == state && this.character == character;
    }

    public int follow(){
        return next_state;
    }

}
