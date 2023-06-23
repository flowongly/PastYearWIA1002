/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pyq2016sem2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author flore
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Specify your day in number");
        System.out.println("1 for Monday");
        System.out.println("2 for Tuesday");
        System.out.println("3 for Wednesday");
        System.out.println("4 for Thursday");
        System.out.println("5 for Friday");
        System.out.println("6 for Saturday");
        System.out.println("7 for Sunday");
        System.out.println("Enter a number between 1 and 7: ");
        int dayNumber = sc.nextInt();
        
        Map<Integer, String> dayMap = new HashMap<>();
        dayMap.put(1, "Monday");
        dayMap.put(2, "Tuesday");
        dayMap.put(3, "Wednesday");
        dayMap.put(4, "Thursday");
        dayMap.put(5, "Friday");
        dayMap.put(6, "Saturday");
        dayMap.put(7, "Sunday");

        String dayOfWeek = dayMap.getOrDefault(dayNumber, "Invalid day number");

        System.out.println("The name of the day is : " + dayOfWeek);
        
        String followingDay;
        
        if(dayNumber >= 1 && dayNumber <= 6){
            int followingDayNumber = dayNumber + 1;
            followingDay = dayMap.getOrDefault(followingDayNumber, "Invalid day number");
        }else if(dayNumber == 7){
            followingDay = dayMap.getOrDefault(1, "Invalid");
        }else{
            followingDay = "Invalid Number";
        }
        
        System.out.println("The following day of "+ dayOfWeek + " is : " + followingDay);
        
        String previousDay;
        if(dayNumber >= 2 && dayNumber <= 7){
            int previousDayNumber = dayNumber - 1;
            previousDay = dayMap.getOrDefault(previousDayNumber, "Invalid");
        }else if(dayNumber == 1){
            previousDay = dayMap.getOrDefault(7, "Invalid");
        }else{
            previousDay = "Invalid Number";
        }
        System.out.println("The previous dat of "+ dayOfWeek + " is : "+ previousDay);
        
        System.out.println("How many days to add to the current day "+"("+dayOfWeek+")" +"? :");
        int additionalDays = sc.nextInt();

        // Calculate future date by adding additionalDays to the current day
        int futureDayNumber = (dayNumber + additionalDays) % 7;
        if (futureDayNumber == 0) {
            futureDayNumber = 7;
        }
        String futureDay = dayMap.getOrDefault(futureDayNumber, "Invalid day number");

        System.out.println("The future date after " + additionalDays + " days will be: " + futureDay);
    }
}
        
        
      
    
    
    

