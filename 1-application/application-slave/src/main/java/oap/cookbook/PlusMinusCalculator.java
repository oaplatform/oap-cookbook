package oap.cookbook;

import java.util.Optional;

import static oap.cookbook.StackCalculator.Operation.MINUS;
import static oap.cookbook.StackCalculator.Operation.PLUS;

public class PlusMinusCalculator {
    private StackCalculator calculator;

    public PlusMinusCalculator( StackCalculator calculator ) {
        this.calculator = calculator;
    }

    public int plus( int a, int b ) {
        calculator.push( a );
        calculator.push( b );
        calculator.apply( PLUS );
        Optional<Integer> result = calculator.pick();
        calculator.clear();
        return result.orElseThrow();
    }

    public int minus( int a, int b ) {
        calculator.push( a );
        calculator.push( b );
        calculator.apply( MINUS );
        Optional<Integer> result = calculator.pick();
        calculator.clear();
        return result.orElseThrow();
    }
}
