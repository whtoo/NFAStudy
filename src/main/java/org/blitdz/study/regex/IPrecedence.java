package org.blitdz.study.regex;

public interface IPrecedence {
    default public Integer precedence() {
        return 4;
    }

    default public String bracket(Integer outerPrecedence) {
        var builder = new StringBuilder();
        if (this.precedence() < outerPrecedence) {
            builder.append("(");
            builder.append(this.toString());
            builder.append(")");
        } else {
            builder.append(this.toString());
        }

        return builder.toString();
    }
}
