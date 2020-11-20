package oap.cookbook;

import java.util.Optional;

public interface StackCalculator {
    void push( Integer i );

    Optional<Integer> pick();

    void apply( Operation operation );

    void clear();

    enum Operation {
        PLUS,
        MINUS
    }
}
