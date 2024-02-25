package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void CheckAddLastandFirst() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(0);
        ad1.addFirst(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addFirst(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);
        ad1.addLast(9);
        ad1.addFirst(10);
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        assertEquals(ad1.size(), 0);
    }

    @Test
    public void TestPrint() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(1);
        ad1.addFirst(2);
        ad1.addFirst(3);
        System.out.print(ad1);
    }

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        assertTrue(ad1.isEmpty());
        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addLast(3);
        assertFalse(ad1.isEmpty());
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(1);
        ad1.removeFirst();
        assertTrue(ad1.isEmpty());
    }

    @Test
    public void removeEmptyTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> copy = ad1;
        ad1.removeFirst();
        assertEquals(ad1, copy);
    }

    @Test
    public void multipleParamsTest() {
        ArrayDeque<Character> charL = new ArrayDeque<>();
        assertTrue(charL.isEmpty());
        charL.addFirst('A');
        charL.addLast('P');
        charL.addLast('P');
        assertFalse(charL.isEmpty());
        assertEquals(3, charL.size());
        char c = charL.get(0);
        assertEquals('A', c);
    }

    @Test
    public void emptyNulLReturn() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        assertNull(ad1.removeFirst());
    }

    @Test
    public void emptyTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(5);
        ad1.addFirst(3);
        ad1.removeLast();
        ad1.removeFirst();
        assertTrue(ad1.isEmpty());
    }

    @Test
    public void BigADTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i <= 50; i++) {
            ad1.addLast(i);
        }
    }

    @Test
    public void addRemove1() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(8);
        ad1.addFirst(1);
        ad1.addFirst(2);
        int x= ad1.removeLast();
        assertEquals(x, 8);
    }

    @Test
    public void addRemove2() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(8);
        ad1.addFirst(1);
        ad1.addFirst(2);
        int x= ad1.removeLast();
        assertEquals(x, 8);
    }

    @Test
    public void addRemove3() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);
        ad1.addLast(7);
        ad1.addLast(6);
        ad1.addLast(5);
        int x = ad1.removeFirst();
        assertEquals(x, 3);
    }

    @Test
    public void addRemove4() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(4);
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        assertEquals(ad1.size(), 0);
    }

    @Test
    public void addRemove5() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(0);
        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.addLast(3);
        ad1.addFirst(4);
        ad1.addFirst(5);
        ad1.addFirst(6);
        ad1.addFirst(7);
        ad1.addLast(8);
        ad1.addLast(9);
        ad1.addFirst(10);
        int x = ad1.get(5);
        assertEquals(x, 2);
    }

    @Test
    public void GetTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);
        ad1.addLast(9);
        int x = ad1.get(0);
        assertEquals(x, 5);
    }

    @Test
    public void BasicGet() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(0);
        ad1.addFirst(1);
        ad1.get(0);
        ad1.removeFirst();
        ad1.addFirst(4);
        ad1.removeLast();
        ad1.addLast(6);
        ad1.removeLast();
        ad1.get(0);
        int x = ad1.removeLast();
        assertEquals(x, 4);
    }

    @Test
    public void testget(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(0);
        ad1.removeFirst();
        ad1.addLast(2);
        ad1.removeLast();
        ad1.addFirst(4);
        ad1.addFirst(5);
        ad1.addFirst(6);
        int y = ad1.get(2);
        assertEquals(y, 4);
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.addLast(10);
        ad1.removeLast();
        int x = ad1.removeLast();
        assertEquals(x, 4);
    }

    @Test
    public void testAgain(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(0);
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);
        ad1.addLast(9);
        ad1.addLast(10);
        int x = ad1.removeFirst();
        assertEquals(x, 0);
    }

    @Test
    public void TestLast(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(0);
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.removeFirst();
        ad1.addLast(6);
        ad1.addLast(7);
        int z = ad1.removeFirst();
        assertEquals(z, 1);
    }

    @Test
    public void getAgain(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(0);
        ad1.removeFirst();
        ad1.addLast(2);
        ad1.removeFirst();
        ad1.addFirst(4);
        ad1.addFirst(5);
        ad1.removeLast();
        ad1.removeFirst();
        ad1.addFirst(8);
        ad1.removeLast();
        ad1.addFirst(10);
        ad1.addFirst(11);
        ad1.addLast(12);
        ad1.removeFirst();
        int x = ad1.get(1);
        assertEquals(x, 12);
    }

    @Test
    public void madBasicGet() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addLast(0);
        ad1.addLast(1);
        ad1.removeLast();
        ad1.addFirst(4);
        ad1.removeFirst();
        ad1.get(0);
        ad1.addFirst(7);
        ad1.removeLast();
        ad1.get(0);
        ad1.addFirst(10);
        ad1.addFirst(11);
        ad1.addLast(12);
        ad1.addFirst(13);
        ad1.addFirst(14);
        ad1.removeLast();
        ad1.get(2);
        ad1.addFirst(17);
        ad1.removeLast();
        ad1.removeLast();
        int x = ad1.removeLast();
        assertEquals(x, 11);
    }
}


