package org.blitdz.study.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Choose implements IPrecedence {
    private IPrecedence first;
    private IPrecedence second;

    public Choose(IPrecedence first, IPrecedence second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Integer precedence() {
        return 0;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        List<IPrecedence> members = new ArrayList();
        members.add(first);
        members.add(second);
        return members.stream().map(val -> val.bracket(precedence())).collect(Collectors.joining("|")).toString();
    }
}
