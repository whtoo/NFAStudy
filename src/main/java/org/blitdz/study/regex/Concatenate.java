package org.blitdz.study.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Concatenate implements IPrecedence {
    private IPrecedence first;
    private IPrecedence second;

    public Concatenate(IPrecedence first, IPrecedence second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Integer precedence() {
        return 1;
    }

    @Override
    public String toString() {
        List<IPrecedence> members = Arrays.asList(first, second);
        return members.stream().map(val -> val.bracket(precedence())).collect(Collectors.joining()).toString();
    }
}
