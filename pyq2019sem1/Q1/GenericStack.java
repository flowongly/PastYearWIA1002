
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */
public class GenericStack<E> {
    public Node<E> head;
    public int size;
    public int capacity;
    public Node<E> tail;
    
    public GenericStack(int capacity){
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    public E peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        
        return head.element;
    }
    
    public void push(E element){
        Node<E> newNode = new Node<>(element);
        
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head=newNode;
        }
        size++;
        
        System.out.println("Push: "+element);
    }
    
    public void pushMany(String elements) {
    String[] elementsArray = elements.split(",");
    for (String element : elementsArray) {
        push((E) element.trim());
        System.out.println("Push: " + element.trim());
    }
}




     
    public E pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        System.out.println("Pop the top of the stack...");
        E deletedData = head.element;
        head = head.next;
        size--;
        return deletedData;
    }
    
    public void popAll(){
        System.out.println("\nThere are " + getSize() +" items in the stack. Removing all....");
        while(!isEmpty()){
            removeElement();
        }
    }
    
    public void removeElement(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        System.out.println("Removing elements from stack...");
        Node<E> current = head;
        while(current != null){
            System.out.println("Remobing element :" + current.element);
            current = current.next;
            size--;
        }
        head = null;
        tail = null;
        
    }
    
    public void display() {
        if(isEmpty()){
            System.out.println("\nStack is empty... nothing to display"); 
        }
        Node<E> current = head;
        System.out.println("\nThere are " + getSize() + " elements in the stack");
        while(current !=null){
            System.out.println(current.element);
            current = current.next;
        }
    }
    

    
    public int getSize(){
        return size;
    }
    
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<String>(5);
        stack1.push("one");
        stack1.display();
        System.out.println(" ");
        stack1.pushMany("two, three four, five, six seven");
        stack1.display();
        System.out.println(" ");
        stack1.pop();
        stack1.pop();
        stack1.display();
        System.out.println("---------------------");
        GenericStack<Integer> stack2 = new GenericStack<Integer>(5);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }

    

    

    
}
