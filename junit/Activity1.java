package junitproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Activity1 {
	
	//TestFixture
	public static ArrayList<String> list;
	
	@BeforeEach
	public void SetUp() {
		list=  new ArrayList<String>();
		list.add("Mounika"); 
        list.add("Sundeep"); 
        System.out.println(list.size());
	}
	
	@Test
	public void insertTest() {
		assertEquals(2, list.size(), "Wrong size");
        // Add new element
        list.add(2, "sravya");
        // Assert with new elements
        assertEquals(3, list.size(), "Wrong size");
 
        // Assert individual elements
        assertEquals("Mounika", list.get(0), "Wrong element");
        assertEquals("Sundeep", list.get(1), "Wrong element");
        assertEquals("sravya", list.get(2), "Wrong element");
    }
 
    // Test method to test the replace operation
    @Test
    public void replaceTest() {
        // Replace new element
        list.set(1, "sravya");
 
        // Assert size of list
        assertEquals(2, list.size(), "Wrong size");
        // Assert individual elements
        assertEquals("Mounika", list.get(0), "Wrong element");
        assertEquals("sravya", list.get(1), "Wrong element");
    }
	}
  
   
	
