package java.pl.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    private final int stackSize = 3;
        private Stack<String> stringStack = new Stack<>(stackSize);

        @Test
        public void should_add_element_to_stack() {
            // arrange
            String element = "firstElement";
            // act
            stringStack.push(element);
            // assert
            assertEquals(true, stringStack.contains(element));
            assertEquals(1, stringStack.size());

        }

        @Test
        public void should_delete_element_from_stack(){
            // arrange
            String element = "first";
            stringStack.push(element);
            // act
            String deletedElement = stringStack.pop();

            // assert
            assertEquals(element, deletedElement);
            assertEquals(0, stringStack.size());
        }
}

