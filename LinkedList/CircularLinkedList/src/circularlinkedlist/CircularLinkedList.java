package circularlinkedlist;

import java.util.Collections;
/**
 *
 * @author Nonobeam
 * Find me more on this https://nonobeam.github.io/myPorfolio/?fbclid=IwAR38ZSEEUKN8octg-XKC670qr7-FgkPzWOjaKp0wve6UQtT0fvwpMT8ejKA
 */

class Node<T>{
    T val;
    Node<T> next;
    Node<T> pre;
    
    public Node() {
    }

    public Node(T val) {
        this.val = val;
    }
    
    public Node(T val, Node<T> pre, Node<T> next) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
    
}
class CircularedLinkedList<T>{
    Node<T> head = null;
    
    CircularedLinkedList(){
    }
    
    boolean isEmpty(){
        return head == null;
    }
    
    
    public void add(T val){
        Node<T> p = new Node(val);
        
        if (head == null){
            head = p;
        }else{
            p.next = head;
            head.pre = p;
            head = p;
        }
    }
    
    
    public void addMany(T [] a){
        for(T i : a){
            Node<T> p = new Node(i);
            if(isEmpty()){
                head = new Node(a[0]);
            }else{
                add(i);
            }
        }
    }
    
    public int sizeCLL(){
        Node tmp = head;
        int size = 0;
        while(tmp != null){
            size++;
            tmp = tmp.next;
        }
            
        return size;
    }
    
    public void removeValue(){
        
    }
    
    public void removeAll(){
        head = null;
    }
    
    public void printAll(){
        Node<T> p = head;
        if (p == null) {
            System.out.println("Single LinkedList is empty");
            return;
        }
        while(p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println("");
    }
    
//    -------------------------------------------------------------------------

}
public class CircularLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.format(String.join(""), Collections.nCopies(10, "----")); 
        CircularedLinkedList cll = new CircularedLinkedList();
        
        Integer [] test = {2, 1, 4, 8};
        
        cll.add("Hello");
        cll.add("How are you");
        cll.add("I'm fine");
        System.out.println("After addFirst");
        cll.printAll();
        cll.add(3);
        cll.add(15);
        System.out.println("After addLast");
        cll.printAll();
        cll.addMany(test);
        System.out.println("After addMany");
        cll.printAll();
        System.out.println("Size of Single LinkedList");
        System.out.println(cll.sizeCLL());
   
        cll.removeAll();
        System.out.println("After remove ALL");
        cll.printAll();
    }
    
}