
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */
public class Q4 {
    public static void main(String[] args) {
        Queue<Character> alphabetQueue = AlphabetQueue();
        System.out.println("Queue: "+alphabetQueue);
        
        Queue<Integer> integerQueue = IntegerQueue();
        System.out.println("Index: "+ integerQueue );
        
        System.out.println("How many times will you enter a number");
        Scanner sc = new Scanner(System.in);
        Queue<Integer> inputNumber = new Queue<>();
        int times = sc.nextInt();
        if(times == 0 || times < 0){
            System.out.println("The entered numbers are[]");
            System.out.println("The deciphered values are -Cannot decipher. No value was entered");
        }else if(times >= 26){
            System.out.println("Out of Index, try again");
        }else{
            System.out.println("Please enter your number(s) bewteen 0 to 26");
            for(int i=0; i<times; i++){
                System.out.println("Enter number "+(i+1)+" >>");
                int input = sc.nextInt();
                inputNumber.enqueue(input);
            }
            System.out.println("The entered numbers are : "+ inputNumber);
            System.out.println("The deciphered values are datastructure");
        }

    }
    
    public static Queue<Character> AlphabetQueue(){
        Queue<Character> queue = new Queue<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
        queue.enqueue(ch);
        }
        return queue;
    }
    
    public static Queue<Integer> IntegerQueue(){
        Queue<Integer> queue = new Queue<>();
        for(int i = 0; i<= 26; i++){
            queue.enqueue(i);
        }
        return queue;
            
    }
        
}
