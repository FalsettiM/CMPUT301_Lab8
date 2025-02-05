package com.example.lab8;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        City city = mockCity();
        // Check when list is empty
        assertFalse(list.hasCity(city));
        // Add city and check for that city and a non existent city
        City city2 = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city2);
        assertTrue(list.hasCity(city2));
        assertFalse(list.hasCity(city));
    }

    @Test
    public void testDelete() {
        list = MockCityList();
        City city = mockCity();
        // Test with city and empty list
        assertThrows(IllegalArgumentException.class, () -> list.delete(city));
        // Add city and test if it is deleted
        list.addCity(city);
        assertThrows(IllegalArgumentException.class, () -> list.delete(null));
        list.delete(city);
        assertFalse(list.hasCity(city));

    }

    @Test
    public void testCountCities() {
        list = MockCityList();
        City city = mockCity();
        // Test with empty list
        assertEquals(0, list.countCities());

        // Add a city
        list.addCity(city);
        assertEquals(1, list.countCities());

        // Delete a city
        list.delete(city);
        assertEquals(0, list.countCities());

    }
}
