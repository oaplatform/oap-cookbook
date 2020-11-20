package oap.cookbook;

import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import static oap.cookbook.StackCalculator.Operation.MINUS;
import static oap.cookbook.StackCalculator.Operation.PLUS;


public class LocalCalculator implements StackCalculator {
    private final Stack<Integer> stack = new Stack<>();
    private final Map<Operation, Runnable> operations = Map.of(
        PLUS, () -> stack.push( stack.pop() + stack.pop() ),
        MINUS, () -> stack.push( -stack.pop() + stack.pop() )
    );

    public void push( Integer i ) {
        stack.push( i );
    }

    public Optional<Integer> peek() {
        return stack.isEmpty() ? Optional.empty() : stack.peek().describeConstable();
    }

    public void apply( Operation operation ) {
        operations.get( operation ).run();
    }

    public void clear() {
        stack.clear();
    }
}
