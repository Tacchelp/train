import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class SetTest{

    @Test
    public void containsTest(){
        Set a = new TabSet(64); //BitSet(64);
        a.add(new Integer(2));
        assertTrue(a.contains(new Integer(2)));
        assertFalse(a.contains(new Integer(5)));
    }
    @Test
    public void cardinalTest(){
        Set a = new TabSet(64); //BitSet(64);
        a.add(new Integer(2));
        a.add(new Integer(8));
        assertEquals(2, a.cardinal());
    }

    @Test
    public void addTest(){
        Set a = new TabSet(64); //BitSet(64);
        assertFalse(a.contains(new Integer(4)));
        assertTrue(a.add(new Integer(4)));
        assertTrue(a.contains(new Integer(4)));
    }

    @Test
    public void removeTest(){
        Set a = new TabSet(64); //BitSet(64);
        a.add(new Integer(42));
        assertTrue(a.contains(new Integer(42)));
        assertTrue(a.remove(new Integer(42)));
        assertFalse(a.contains(new Integer(42)));
        assertFalse(a.remove(new Integer(42)));
    }

    @Test
    public void cloneTest(){
        Set a = new TabSet(64); //BitSet(64);
        a.add(new Integer(2));
        a.add(new Integer(8));
        Set b = a.clone();
        assertEquals(a.cardinal(), b.cardinal());
        assertTrue(b.contains(new Integer(8)));
    }

    @Test
    public void equalsTest(){
        Set a = new TabSet(64); //BitSet(70);
        a.add(new Integer(42));
        a.add(new Integer(67));
        Set b = a.clone();
        assertTrue(a.equals(b));
        b.add(new Integer(5));
        assertFalse(b.equals(a));
        assertFalse(a.equals(b));
    }


    @Test
    public void unionTest(){
        Set a = new TabSet(64); //BitSet(64);
        a.add(new Integer(3));
        a.add(new Integer(5));
        a.add(new Integer(8));
        Set b = new BitSet(64);
        b.add(new Integer(5));
        b.add(new Integer(8));
        b.add(new Integer(42));
        Set f = new BitSet(64);
        f.add(5);
        f.add(3);
        f.add(42);
        f.add(8);
        assertTrue(f.equals(a.union(b)));
    }

    @Test
    public void intersectionTest(){
        Set a = new TabSet(64); //BitSet(64);
        a.add(new Integer(3));
        a.add(new Integer(5));
        a.add(new Integer(8));
        Set b = new BitSet(64);
        b.add(new Integer(5));
        b.add(new Integer(8));
        b.add(new Integer(42));
        Set f = new BitSet(64);
        f.add(5);
        f.add(8);
        assertTrue(f.equals(a.intersection(b)));
    }
}