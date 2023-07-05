
import java.text.NumberFormat;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */
public class LL<N, E> {
    public class Node<N, E>{
        N name;
        E element;
        Node<N, E> next;
        
        public Node(N name, E element){
            this.element = element;
            this.name = name;
            this.next = null;
        }
        
        public int getElement(){
            return (Integer) this.element * 1000000;
        }
    }
    
    private Node<N, E> head;
    private Node<N, E> tail;
    private int size = 0;
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void findBook(N name) {
       Node<N, E> current = head;
       int index = 0;
       boolean bookFound = false;

       while (current != null) {
          if (current.name.equals(name)) {
              System.out.println("Found " + name + " which is book number " + (index + 1) + " in the linked list");
              bookFound = true;
              break;
            }
            current = current.next;
            index++;
        }

        if (!bookFound) {
           System.out.println("Couldn't find book with name: " + name);
        }
    }
        
    public void addAfter(N name, N newName, E newElement){
        Node<N, E> temp = head;
        while(temp != null){
            if(temp.name.equals(name)){
                Node<N,E> newNode = new Node<>(newName, newElement);
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                System.out.println("\nAdding " + newName + " after " + name);
                break;           
            }
            temp=temp.next;
        }
            
    }
    
    public void createNode(N name, E element){
        Node<N, E> newNode = new Node<>(name, element);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
//            newNode.next = head;
//            head = newNode;
                   
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
        
    public N removeNode(N name){
        int index = 0;
        System.out.println("\nRemove " + name);
        if(head == null){
            System.out.println("Nothing to remove");
            return null;
        }
        
        if(head.name.equals(name)){
            System.out.println(name + " is the first book." + " Removing "+ name + " from the linked list");
            System.out.println("");
            N removed = head.name;
            head = head.next;
            size--;
            return removed;
        }
            
        Node<N,E> current = head;
        while(current != null && current.next != null){
            index++;
            if(current.next.name.equals(name)){
                System.out.println(name + " is the " + index+1 + " book." + " Removing "+ name + " from the linked list");
                N removedElement = current.next.name;
                current.next = current.next.next;
                size--;
                return removedElement;             
            }
            current = current.next;
        }
        System.out.println("Could'nt find the bookname");
        return null;
            
    }
        
    public void displayReverse(){
       Node<N, E> current = head;
       Node<N, E> previous = null;
       Node<N, E> next; 
       
       while(current != null){
           next = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }
       
        Node<N, E> reversedHead = previous;
        Node<N, E> reversedCurrent = reversedHead;
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

        System.out.println("Display the linked list******************************************************");
        while (reversedCurrent != null) {
           String formattedElement = numberFormat.format(reversedCurrent.getElement());
           System.out.println(reversedCurrent.name + ": " + formattedElement + " sold");
           reversedCurrent = reversedCurrent.next;
        }

        // Restore the original order of the linked list
        current = reversedHead;
        previous = null;

        while (current != null) {
           next = current.next;
           current.next = previous;
           previous = current;
           current = next;
        }

        head = previous;
    }
    
    public void display(){
        Node<N,E> current = head;
            
        NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
        System.out.println("Displaying the linked list************************************************");
        while(current != null){
            String formattedData = numberformat.format(current.getElement());
            System.out.println(current.name +": "+ formattedData + " Sold");
            current = current.next;
        }  
    }
        
    public int totalSold(){
        Node<N, E> current = head;
        int total = 0;
        while(current != null){
            // total += Integer.parseInt(current.element.toString());
            total += current.getElement();
            current = current.next;
        }
        return total;
    }
    
    public static void main(String[] args) {
           LL<String, Integer> myLL = new LL<>(); 
           myLL.createNode("Lord of the Rings", 500);
           myLL.createNode("Tale of the Body Thief", 1);
           myLL.createNode("Memnoch the Devil", 100);
           myLL.createNode("Heart of a Samurai", 10);
//           myLL.display();
           myLL.displayReverse();
          
           myLL.addAfter("Memnoch the Devil", "White Crane", 10);
           myLL.findBook("Memnoch the Devil");
           
           System.out.println("");
           myLL.displayReverse();;
//           myLL.display();
   
           
           myLL.addAfter("White Crane", "Memoirs of Geisha",90);
           myLL.findBook("White Crane");
           
           System.out.println("");
           myLL.displayReverse();
//           myLL.display();
           
           myLL.removeNode("Harry Potter");
           
           myLL.removeNode("Heart of a Samurai");
           myLL.displayReverse();
           
//           myLL.display();
    }   
}
    
