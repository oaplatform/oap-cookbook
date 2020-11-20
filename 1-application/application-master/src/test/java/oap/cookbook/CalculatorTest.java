package oap.cookbook;


import org.testng.annotations.Test;

import static oap.cookbook.StackCalculator.Operation.MINUS;
import static oap.cookbook.StackCalculator.Operation.PLUS;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void calculation() {
        Calculator calculator = new Calculator();
        assertThat( calculator.pick() ).isNotPresent();
        calculator.push( 2 );
        calculator.push( 2 );
        calculator.apply( PLUS );
        assertThat( calculator.pick() ).get().isEqualTo( 4 );
        calculator.push( 1 );
        calculator.apply( MINUS );
        assertThat( calculator.pick() ).get().isEqualTo( 3 );
    }
}