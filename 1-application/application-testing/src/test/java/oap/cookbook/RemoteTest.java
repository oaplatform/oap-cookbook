package oap.cookbook;

import oap.application.testng.KernelFixture;
import oap.io.Resources;
import oap.testng.Fixtures;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoteTest extends Fixtures {
    private final KernelFixture kernel;

    {
        fixture( kernel = new KernelFixture( Resources.filePath( getClass(), "/application.test.conf" ).get() ) );
    }

    @Test
    public void calculation() {
        PlusMinusCalculator calculator = kernel.service( PlusMinusCalculator.class );
        assertThat( calculator.plus( 2, 2 ) ).isEqualTo( 4 );
    }
}
