package lesson4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void correctTest() throws ExceptionSquare {
        Triangle triangle = new Triangle(3, 4, 5);
        Assertions.assertEquals(6,triangle.calculateSquare());
    }

    @Test
    void incorrectTest1() throws ExceptionSquare {
        Triangle triangle = new Triangle(-3, 4, 5);
        Assertions.assertThrows(ExceptionSquare.class, triangle::calculateSquare);
    }

    @Test
    void incorrectTest2() throws ExceptionSquare {
        Triangle triangle = new Triangle(3, 0, 5);
        Assertions.assertThrows(ExceptionSquare.class, triangle::calculateSquare);
    }

    @Test
    void incorrectTest3() throws ExceptionSquare {
        Triangle triangle = new Triangle(100, 4, 5);
        Assertions.assertThrows(ExceptionSquare.class, triangle::calculateSquare);
    }

}
