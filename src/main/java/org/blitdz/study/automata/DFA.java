package org.blitdz.study.automata;

public class DFA {
    private int currentState;
    private int[] acceptStates;
    private FARuleBook ruleBook;

    /**
     * 类的构造声明应该简洁,ruby的struct类型是个不错的参考.
     * @param currentState
     * @param acceptStates
     * @param ruleBook
     */
    public DFA(int currentState,int[] acceptStates,FARuleBook ruleBook){
        this.currentState = currentState;
        /// 所有的集合类型数据结构必须copy
        this.acceptStates = acceptStates.clone();
        this.ruleBook = ruleBook;
    }
    public boolean accepting(){
        for (int i = 0; i < acceptStates.length; i++) {
            if(acceptStates[i] == currentState) return true;
        }

        return  false;
    }

    public void  updateAcceptStates(int[] acceptStates){
        this.acceptStates = acceptStates.clone();
    }

    protected void readCharacter(char c) {
        this.ruleBook.ruleFor(currentState,c).ifPresent(rule -> currentState = rule.follow());
    }

    public void readCharSeq(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            readCharacter(c);
        }
    }
}
