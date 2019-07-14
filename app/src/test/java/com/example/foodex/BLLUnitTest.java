package com.example.foodex;

import com.example.foodex.BILL.FoodBLL;
import com.example.foodex.BILL.UserBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BLLUnitTest {

    @Test
    public void testLogin() {
        UserBLL userBLL = new UserBLL("admin@gmail.com", "admin123");
        boolean actualResult = userBLL.loginUser();
        assertEquals(true, actualResult);
    }

    @Test
    public void testRegister() {
        UserBLL userBLL = new UserBLL("admin admin", "admin@gmail.com", "admin123", "9711318827", "kathmandu", "image.jpg", "user");
        boolean actualResult = userBLL.registerUser();
        assertEquals(true, actualResult);
    }

    @Test
    public void testAddFood() {
        FoodBLL foodBLL = new FoodBLL(1, "Tea", "BREAKFAST", 40, "tea.jpg");
        boolean actualResult = foodBLL.addFood();
        assertEquals(true, actualResult);
    }

    @Test
    public void testDeleteFood() {
        FoodBLL foodBLL = new FoodBLL(1, "Tea", "BREAKFAST", 40, "tea.jpg");
        boolean actualResult = foodBLL.deleteFood();
        assertEquals(true, actualResult);
    }

    @Test
    public void testUpdateFood() {
        FoodBLL foodBLL = new FoodBLL(1, "Tea", "BREAKFAST", 40, "tea.jpg");
        boolean actualResult = foodBLL.updateFood();
        assertEquals(true, actualResult);
    }
}
