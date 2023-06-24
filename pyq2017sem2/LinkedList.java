
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
public class LinkedList<U, E>{
    /*
    Using SinglyLinkedList
    */
    /*Two data types, so implement 2 generics*/
    public class Node<U, E>{
        E element;
        U name;
        Node<U, E> next;
        
        public Node(U name ,E element){
            this.element = element;
            this.name = name;
            this.next = null;
        }
        
    }
    /*Use to keep track the First Node*/
    private Node<U, E> head;
    private Node<U, E> tail;
    /*Use to track the number of element*/
    private int size = 0;
    
    public void insertFirstLink(U name, E data){
        // declre new node
        Node<U, E> newNode = new Node <>(name, data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
            size++;
        }
        size++;
        
    }
    public void addAfter(U name, U newName, E newData){
        Node<U, E> current = head;
        while(current != null){
            if(current.name.equals(name)){
                Node<U, E> newNode = new Node<>(newName, newData);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                break;
            }
            current = current.next;
        }
        
    }
    public int getLocation( U name, E data){
        Node<U, E> current = head;
        int index = 1;
        while(current != null){
            if(current.name.equals(name) && current.element.equals(data)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
        
    }
    
    public boolean checkExist(U name, E data){
        Node<U, E> current = head;
        while(current != null){
            if(current.name.equals(name) && current.element.equals(data)){
                int location = getLocation(name, data);
                System.out.println("Found a match.. "+ name + " is a handbag number "+ location + " in the linked list\n");
                return true;
            }
            current = current.next;
        }
        System.out.println("No match found for "+ name);
        return false;
    }
    
    public void display(){
        Node<U, E> current = head;
        
        // using US locale for comma seperator as shown in the question
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        System.out.println("Displaying the Linked list ******************************");
        while(current != null){
            String formattedData = numberFormat.format(current.element);
            System.out.println(current.name+" : "+formattedData + " Sold");
            current = current.next;
        }
    }
    
    public U removeLink(U name, E data){
        if(head == null){
            return null;
        }
        if(head.name.equals(name) && head.element.equals(data)){
            U removed = head.name;
            head = head.next;
            size--;
            return removed;
        }
        
        Node<U, E> current = head;
        while(current != null){
            if (current.next != null && current.next.name.equals(name) && current.next.element.equals(data)) {
            U removedName = current.next.name;
            current.next = current.next.next;
            size--;
            return removedName; // Node removed
        }

        current = current.next;
    }
    return null;
    
    
    
}
    public static void main(String[] args) {
        LinkedList<String, Integer> list = new LinkedList<>();
        list.insertFirstLink("Tods", 500000000);
        list.insertFirstLink("Prada", 1000000);
        list.insertFirstLink("Chanel", 100000000);
        list.insertFirstLink("Louis Vuitto", 10000000);  
        list.display();
        
        System.out.println("\nAdding Coach after Chanel");
        list.addAfter("Chanel", "Coach", 10000000);
        int ChanelLocation = list.getLocation("Chanel", 100000000);
        System.out.println("Found Chanel which is handbag number "+ ChanelLocation + " in the linked list\n");
        list.display();
        
        System.out.println("\nAdding Mulberry after Coach");
        list.addAfter("Coach", "Mulberry", 90000000);
        int CoachLocation = list.getLocation("Coach", 10000000);
        System.out.println("Found Coach which is handbag number "+ CoachLocation + " in the linked list\n");
        list.display();
        
        System.out.println("\nRemove Chanel..");
        list.checkExist("Chanel", 100000000);
        list.removeLink("Chanel", 100000000);
        list.display();
        
        System.out.println("\nRemove Coach..");
        list.checkExist("Coach", 10000000);
        list.removeLink("Coach", 10000000);
        list.display();   
    }
}
