/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */
public class LinkedList {
    public class Node{
       private int data;
       private Node next;
       
       public Node(int data){
           this.data = data;
           this.next = next;
       }
    }
    private Node head;
    private Node tail;
    private int size = 0;
    
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        
    }
    
    public void addAfter(int newData, int existingData) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node newNode = new Node(newData);
        Node current = head;

        while (current != null) {
            if (current.data == existingData) {
                newNode.next = current.next;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode; // Update tail if the new node is added after the current tail node
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Existing data not found in the list");
    }
    
    public int deleteFront(){
        if(head == null){
            return -1;
        }
        Node deleteNode = head;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return deleteNode.data;
    }
    
    public int deleteAfter(int data) {
        if (head == null || head.next == null) {
            return -1; // Return a sentinel value or throw an exception to indicate invalid operation
        }
        
        Node current = head;
        
        while (current != null && current.next != null) {
            if (current.data == data) {
                Node deleteNode = current.next;
                current.next = deleteNode.next;
                deleteNode.next = null;
                return deleteNode.data;
            }
            current = current.next;
        }
        
        return -1; // Return a sentinel value or throw an exception to indicate node with given data not found
    }
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


}
