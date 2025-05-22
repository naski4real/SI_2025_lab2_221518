Nazar Idrizi 221518


Control Flow Graph
![flowgraph](https://github.com/user-attachments/assets/a73ceaa1-9965-4268-903c-47672a46a77d)


Цикломатска комплексност
// Цикломатската комплексност на овој код е 9, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=8, па цикломатската комплексност изнесува 9.

Тест случаи според критериумот Every statement
Тест 1: Проверува дали методот фрла соодветна грешка кога листата на производи е null.
RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
assertEquals("allItems list can't be null!", ex1.getMessage());
Тест 2: Тестира валидација на името на производот – дали методот правилно детектира празно или null име.
List<Item> items2 = List.of(new Item(null, 1, 10, 0));
RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, "1234567890123456"));
assertEquals("Invalid item!", ex2.getMessage());
List<Item> items3 = List.of(new Item("", 1, 10, 0));
RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items3, "1234567890123456"));
assertEquals("Invalid item!", ex3.getMessage());
Тест 3: Тестира нормално извршување со валиден производ со попуст.
List<Item> items4 = List.of(new Item("apple", 2, 100, 0.1));
double sum4 = SILab2.checkCart(items4, "1234567890123456");
assertEquals(180.0, sum4);
Тест 4: Тест за производ со цена над 300 – дали се одзема 30 поени од сумата.
List<Item> items5 = List.of(new Item("banana", 1, 400, 0));
double sum5 = SILab2.checkCart(items5, "1234567890123456");
assertEquals(370.0, sum5);
Тест 5: Тест за производ со количина над 10 – дали се одзема 30 поени од сумата.
List<Item> items6 = List.of(new Item("milk", 11, 10, 0));
double sum6 = SILab2.checkCart(items6, "1234567890123456");
assertEquals(80.0, sum6);
Тест 6: Тест за картичка со невалидна должина.
List<Item> items7 = List.of(new Item("pear", 1, 10, 0));
RuntimeException ex4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items7, "123"));
assertEquals("Invalid card number!", ex4.getMessage());
Тест 7: Тест за картичка со невалиден карактер.
List<Item> items8 = List.of(new Item("pear", 1, 10, 0));
RuntimeException ex5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items8, "123456789012345A"));
assertEquals("Invalid character in card number!", ex5.getMessage());

Тест случаи според критериумот Every path
Тест 1: Листата на производи е null (path: null input)
RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
assertEquals("allItems list can't be null!", ex1.getMessage());
Тест 2: Производ со невалидно име (path: invalid name)
List<Item> items2 = List.of(new Item(null, 1, 10, 0));
RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, "1234567890123456"));
assertEquals("Invalid item!", ex2.getMessage());
Тест 3: Валиден производ, валидна картичка (path: normal execution)
List<Item> items4 = List.of(new Item("apple", 2, 100, 0.1));
double sum4 = SILab2.checkCart(items4, "1234567890123456");
assertEquals(180.0, sum4);
Тест 4: Производ со цена > 300 и валидна картичка (path: price triggers deduction)
List<Item> items5 = List.of(new Item("banana", 1, 400, 0));
double sum5 = SILab2.checkCart(items5, "1234567890123456");
assertEquals(370.0, sum5);
Тест 5: Производ со попуст и цена > 300 (path: both triggers, discount and deduction)
List<Item> items9 = List.of(new Item("discount", 1, 400, 0.2));
double sum9 = SILab2.checkCart(items9, "1234567890123456");
assertEquals(290.0, sum9);
Тест 6: Производ со количина > 10 (path: quantity triggers deduction)
List<Item> items6 = List.of(new Item("milk", 11, 10, 0));
double sum6 = SILab2.checkCart(items6, "1234567890123456");
assertEquals(80.0, sum6);
Тест 7: Производ со валидни вредности, но картичката е кратка (path: invalid card length)
List<Item> items7 = List.of(new Item("pear", 1, 10, 0));
RuntimeException ex4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items7, "123"));
assertEquals("Invalid card number!", ex4.getMessage());
Тест 8: Производ со валидни вредности, но картичката содржи невалиден карактер (path: invalid character in card)
List<Item> items8 = List.of(new Item("pear", 1, 10, 0));
RuntimeException ex5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items8, "123456789012345A"));
assertEquals("Invalid character in card number!", ex5.getMessage());

Објаснување на напишаните unit tests

За Every Statement критериумот, креирани се тестови кои покриваат секоја линија од кодот, вклучително и случаи кога листата е null, кога производот има невалидно име, кога има попуст, висока цена, голема количина, невалидна картичка и слично.
За Every Path критериумот, тестовите се така дефинирани што се покрива секој можен пат низ функцијата, односно сите комбинации на влезни податоци кои можат да доведат до различно извршување на кодот.
Секој тест е реализиран со JUnit5, користејќи assertThrows за очекувани исклучоци и assertEquals за проверка на пресметаната сума.
Тестовите се групирани по критериуми за полесна проверка на покриеноста.
