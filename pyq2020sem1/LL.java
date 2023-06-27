
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
        
    public void addAfter(N name, N newName, E newElement){
        Node<N, E> temp = head;
        while(temp != null){
            if(temp.element.equals(name)){
                Node<N,E> newNode = new Node<>(newName, newElement);
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
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
            tail.next = newNode;
            tail = newNode;          
        }
        size++;
    }
        
    public N removeNode(N name, E element){
        if(head == null){
            return null;
        }
            
        if(head.name.equals(name) && head.element.equals(element)){
            N removed = head.name;
            head = head.next;
            size--;
            return removed;
        }
            
        Node<N,E> current = head;
        while(current != null && current.next != null){
            if(current.next.name.equals(name) && current.next.element.equals(element)){
                N removedElement = current.next.name;
                current.next = current.next.next;
                size--;
                return removedElement;
                            
            }
            current = current.next;
        }
        return null;
            
    }
        
    public void display(){
        Node<N,E> current = head;
            
        NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
        System.out.println("Displaying the linked list************************************");
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
           myLL.createNode("Lord of the Rings", 100);
           myLL.createNode("Lord of the Rings", 10);
           myLL.display();
           
           // havent complete..
    }
        
       
                
}
    
    
    

    

