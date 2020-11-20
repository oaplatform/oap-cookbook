package oap.cookbook;

import oap.application.testng.KernelFixture;
import oap.testng.Fixtures;
import org.testng.annotations.Test;

import static oap.cookbook.StackCalculator.Operation.MINUS;
import static oap.cookbook.StackCalculator.Operation.PLUS;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest extends Fixtures {

    private final KernelFixture kernel;

    {
        fixture( kernel = new KernelFixture( "/application.test.conf" ) );
    }

    @Test
    public void calculation() {
        Calculator calculator = kernel.service( Calculator.class );
        assertThat( calculator.peek() ).isNotPresent();
        calculator.push( 2 );
        calculator.push( 2 );
        calculator.apply( PLUS );
        assertThat( calculator.peek() ).get().isEqualTo( 4 );
        calculator.push( 1 );
        calculator.apply( MINUS );
        assertThat( calculator.peek() ).get().isEqualTo( 3 );

    }

}
