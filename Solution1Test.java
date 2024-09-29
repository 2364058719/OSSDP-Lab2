import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution1Test {

    private final Solution1 solution = new Solution1();

    @Test
    public void testFractionToDecimal1() {
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
    }

    @Test
    public void testFractionToDecimal2() {
        assertEquals("2", solution.fractionToDecimal(2, 1));
    }

    @Test
    public void testFractionToDecimal3() {
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333));
    }

    @Test
    public void testFractionToDecimal4() {
        assertEquals("-0.5", solution.fractionToDecimal(-1, 2));
    }

    @Test
    public void testFractionToDecimal5() {
        assertEquals("-2", solution.fractionToDecimal(-2, 1));
    }

    @Test
    public void testFractionToDecimal6() {
        assertEquals("-0.(012)", solution.fractionToDecimal(-4, 333));
    }

    @Test
    public void testFractionToDecimal7() {
        assertEquals("0", solution.fractionToDecimal(0, 1));
    }

//    @Test
//    public void testFractionToDecimal8() {
//        assertEquals("1.6666666666666667", solution.fractionToDecimal(5, 3));
//    }
}
