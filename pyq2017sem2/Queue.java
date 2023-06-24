public class Queue<E> {
    private E[] items;
    private int size;
    private int front;
    private int end;
    public Queue(E[]items){
        this.items = items;
        this.size = items.length;
        this.front = 0;
        this.end = 0;
        
    }
    public Queue(){
        this(30);
    }

    private Queue(int capacity) {
        this.items = (E[]) new Object [capacity];
        this.size = 0;
        this.front = 0;
        this.end = 0;
    }
    public void enqueue(E e){
       if(size == items.length){
           throw new IllegalStateException("Queue is full");
       } 
       items[end] = e;
       // update the next available index
       // for example : new item is index 2, item.length = 5
       // so, (2+1) % 5
       // index 17, item.length = 30 (17+1) % 30 = 
       end = (end + 1)% items.length;
       size++;
    }
    public E dequeue(){
        if(size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        E element = items[front];
        items[front] = null;
        front = (front + 1)%items.length;
        size--;
        return element;
    }
    public E getElement(int i){
        if(i < 0 || i>= size){
            throw new IndexOutOfBoundsException("Invalid Index");  
        }
        int index = (front + i) % items.length;
        return items[index];
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[(front + i)% items.length]);
            if(i < size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
