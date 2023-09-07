import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import java.time.Duration;

class PListTest {
    private PList<Integer> list;
    private final Class<IndexOutOfBoundsException> boundsC = IndexOutOfBoundsException.class;
    private final Class<NotFoundException> notFoundC = NotFoundException.class;

    @BeforeEach
    void setUp() {
        list = new EmptyPList<>();
    }

    PList<Integer> makeList(int... elements) {
        PList<Integer> list = new EmptyPList<>();
        for (int i = elements.length - 1; i >= 0; i--) {
            list = new NEmptyPList<>(elements[i], list);
        }
        return list;
    }

    @Test
    @DisplayName("empty: This test is included with the assignment.")
    void empty() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            assertTrue(list.isEmpty());
            assertEquals(0, list.size());
            list = makeList(10);
            assertFalse(list.isEmpty());
            assertEquals(1, list.size());
        });
    }

    @Test
    @DisplayName("contains: This test is included with the assignment.")
    void contains() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            assertFalse(list.contains(10));
            list = makeList(10);
            assertTrue(list.contains(10));
            assertFalse(list.contains(20));
            list = makeList(10, 20);
            assertTrue(list.contains(10));
            assertTrue(list.contains(20));
            assertFalse(list.contains(30));
        });
    }

    @Test
    @DisplayName("get: This test is included with the assignment.")
    void get() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            assertThrows(boundsC, () -> list.get(0));
            list = makeList(10);
            assertEquals(10, list.get(0));
            assertThrows(boundsC, () -> list.get(1));
            list = makeList(10, 20);
            assertEquals(10, list.get(0));
            assertEquals(20, list.get(1));
            assertThrows(boundsC, () -> list.get(2));
        });
    }

    @Test
    @DisplayName("indexOf: This test is included with the assignment.")
    void indexOf() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(10);
            assertEquals(0, list.indexOf(10));
            assertThrows(notFoundC, () -> list.indexOf(40));
            list = makeList(10, 20);
            assertEquals(0, list.indexOf(10));
            assertEquals(1, list.indexOf(20));
        });
    }

    @Test
    @DisplayName("lastIndexOf: This test is included with the assignment.")
    void lastIndexOf() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(10);
            assertEquals(0, list.lastIndexOf(10));
            assertThrows(notFoundC, () -> list.lastIndexOf(40));
            list = makeList(10, 10, 20, 20, 20, 20, 30);
            assertEquals(5, list.lastIndexOf(20));
        });
    }

    @Test
    @DisplayName("remove: This test is included with the assignment.")
    void remove() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            assertThrows(boundsC, () -> list.remove(0));
            list = makeList(10);
            assertEquals(new EmptyPList<>(), list.remove(0));
            assertThrows(boundsC, () -> list.remove(1));
            list = makeList(10, 20);
            assertEquals(makeList(20), list.remove(0));
            assertEquals(makeList(10), list.remove(1));
            assertThrows(boundsC, () -> list.remove(2));
            PList<Integer> list2 = makeList(10, 20, 30);
            PList<Integer> list3 = list2.remove(1);
            assertTrue(list2.contains(20));
            assertFalse(list3.contains(20));
        });
    }

    @Test
    @DisplayName("subList: This test is included with the assignment.")
    void subList() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            assertEquals(new EmptyPList<>(), list.subList(0, 0));
            list = makeList(10);
            assertEquals(new EmptyPList<>(), list.subList(0, 0));
            assertEquals(new EmptyPList<>(), list.subList(1, 1));
            assertThrows(boundsC, () -> list.subList(0, 2));
            list = makeList(10, 20);
            assertEquals(makeList(10), list.subList(0, 1));
            assertEquals(makeList(20), list.subList(1, 2));
            assertThrows(boundsC, () -> list.subList(0, 3));
        });
    }

    @Test
    @DisplayName("size: student tests")
    void size() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(1,2);
            assertEquals(2,list.size()); //size = 2

            list = makeList();
            assertEquals(0,list.size()); //size = 0 (edge case?)
        });
    }

    @Test
    @DisplayName("isEmpty: student tests")
    void isEmpty2() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList();
            assertTrue(list.isEmpty()); //empty list

            list = makeList(1,2,3,4,5);
            assertFalse(list.isEmpty()); //non-empty list
        });
    }

    @Test
    @DisplayName("contains: student tests")
    void contains2() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(1,2,3);
            assertFalse(list.contains(24)); //element not in list

            assertTrue(list.contains(1)); //element in list
        });
    }

    @Test
    @DisplayName("indexOf: student tests")
    void indexOf2() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(1,2,3,4,5);
            assertThrows(notFoundC, () -> list.indexOf(52)); //element not in list

            assertEquals(0, list.indexOf(1)); //element in list
        });
    }

    @Test
    @DisplayName("lastIndexOf: student tests")
    void lastIndexOf2() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(1,2,3,4,5);
            assertThrows(notFoundC, () -> list.lastIndexOf(25)); //element not found.

            list = makeList(1,2,3,2,2);
            assertEquals(4, list.lastIndexOf(2)); //ensure functionality (there are 3 2s -> indexes: 1, 3, 4)

        });
    }

    @Test
    @DisplayName("get: student tests")
    void get2() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(1,2,3,4,5,6,7,8,9,10);
            assertThrows(boundsC, () -> list.get(15)); //index out of bounds.

            assertEquals(3, list.get(2)); //index within bounds, return element.
        });
    }

    @Test
    @DisplayName("remove: student tests")
    void remove2() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(1,2,4,5);

            assertEquals(makeList(2,4,5),list.remove(0)); //remove 1st element

            assertThrows(boundsC, () -> list.remove(50)); //index out of bounds.
        });
    }


    @Test
    @DisplayName("sublist: student tests")
    void subList2() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            list = makeList(1,2,3,4,5);
            assertThrows(boundsC, () -> list.subList(3,1)); //backwards sublist

            assertThrows(boundsC, () -> list.subList(-3,3)); //out of bounds lower index

            assertThrows(boundsC, () -> list.subList(0,7)); //out of bounds upper index

            assertEquals(makeList(1,2),list.subList(0,2)); //ensure functionality
        });
    }
}
