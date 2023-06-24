
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */

public class TestPileStack<E> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericStack<String> bookstack = new GenericStack<>();
        System.out.println("An empty pile of books");
        System.out.println("isEmpty() returns true");
        System.out.println("\nPush 3 books to the pile:");
        for(int i=0; i<3; i++){
            System.out.println("Enter book title "+ (i+1)+" : " );
            String bookName = sc.nextLine();
            bookstack.push(bookName);
        }
        System.out.println("The new books that you are added are: "+ bookstack);
        
        boolean checkEmpty = bookstack.isEmpty();
        System.out.println("\nThe pile should not be empty: ");
        System.out.println("isEmpty() returns "+checkEmpty);
        System.out.println("The pile has "+ bookstack.getSize()+ " books");
        
        System.out.println("\nGet the top book and remove the top book: ");
        System.out.println("\n"+bookstack.peek() +" is the top of the pile");
        System.out.println(bookstack.pop() + " is removed from the pile");
        
        System.out.println("\n"+bookstack.peek() +" is the top of the pile");
        System.out.println(bookstack.pop() + " is removed from the pile");
        
        System.out.println("\n"+bookstack.peek() +" is the top of the pile");
        System.out.println(bookstack.pop() + " is removed from the pile");
        
        System.out.println("\nThe pule should be empty");
        boolean checkEmptyAgain = bookstack.isEmpty();
        System.out.println("isEmpty() returns "+checkEmptyAgain);
        
    }
    
}
