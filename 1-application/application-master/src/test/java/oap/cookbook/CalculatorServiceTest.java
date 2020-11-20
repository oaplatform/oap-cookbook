package oap.cookbook;

import oap.application.testng.KernelFixture;
import oap.io.Resources;
import oap.testng.Fixtures;
import org.testng.annotations.Test;

import static oap.cookbook.StackCalculator.Operation.MINUS;
import static oap.cookbook.StackCalculator.Operation.PLUS;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest extends Fixtures {

    private final KernelFixture kernel;

    {
        fixture( kernel = new KernelFixture( Resources.filePath( getClass(), "/application.test.conf" ).get() ) );
    }

    @Test
    public void calculation() {
        Calculator calculator = kernel.service( Calculator.class );
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
