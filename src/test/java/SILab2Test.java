import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testStatementCoverage() {
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        List<Item> items2 = List.of(new Item(null, 1, 10, 0));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, "1234567890123456"));
        assertEquals("Invalid item!", ex2.getMessage());

        List<Item> items3 = List.of(new Item("", 1, 10, 0));
        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items3, "1234567890123456"));
        assertEquals("Invalid item!", ex3.getMessage());

        List<Item> items4 = List.of(new Item("apple", 2, 100, 0.1));
        double sum4 = SILab2.checkCart(items4, "1234567890123456");
        assertEquals(150.0, sum4);

        List<Item> items5 = List.of(new Item("banana", 1, 400, 0));
        double sum5 = SILab2.checkCart(items5, "1234567890123456");
        assertEquals(370.0, sum5);

        List<Item> items6 = List.of(new Item("milk", 11, 10, 0));
        double sum6 = SILab2.checkCart(items6, "1234567890123456");
        assertEquals(80.0, sum6);

        List<Item> items7 = List.of(new Item("pear", 1, 10, 0));
        RuntimeException ex4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items7, "123"));
        assertEquals("Invalid card number!", ex4.getMessage());

        List<Item> items8 = List.of(new Item("pear", 1, 10, 0));
        RuntimeException ex5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items8, "123456789012345A"));
        assertEquals("Invalid character in card number!", ex5.getMessage());
    }

    @Test
    void testMultipleConditionCoverage() {
        String validCard = "1234567890123456";

        // All conditions false: (100, 0, 1)
        Item item1 = new Item("case1", 1, 100, 0);
        double result1 = SILab2.checkCart(List.of(item1), validCard);
        assertEquals(100.0, result1);

        // Only price > 300 true: (400, 0, 1)
        Item item2 = new Item("case2", 1, 400, 0);
        double result2 = SILab2.checkCart(List.of(item2), validCard);
        assertEquals(370.0, result2);

        // Only discount > 0 true: (100, 0.1, 1)
        Item item3 = new Item("case3", 1, 100, 0.1);
        double result3 = SILab2.checkCart(List.of(item3), validCard);
        assertEquals(60.0, result3);

        // Only quantity > 10 true: (100, 0, 11)
        Item item4 = new Item("case4", 11, 100, 0);
        double result4 = SILab2.checkCart(List.of(item4), validCard);
        assertEquals(1070.0, result4);
        // Explanation: sum -=30; sum += 11*100 => (11*100) - 30 = 1100-30 = 1070.0
    }
}
