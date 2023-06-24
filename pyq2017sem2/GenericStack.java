
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author flore
 */
public class GenericStack<E> implements StackInterface<E> {
    private ArrayList<E> list;
    
    public GenericStack(){
        list = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public E peek() {
        return list.get(getSize()-1);
    }

    @Override
    public E pop() {
        E o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public String toString(){
        return list.toString();
    }
}
