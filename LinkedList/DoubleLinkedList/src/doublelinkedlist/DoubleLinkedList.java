package doublelinkedlist;

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
class DoublerLinkedList<T>{
    Node<T> head, tail;
    
    DoublerLinkedList(){
    }
    
    boolean isEmpty(){
        return head == null;
    }
    
    
    public void addFirst(T val){
        Node<T> p = new Node(val);
        if(isEmpty()){
            head = tail = p;
        }else{
           p.next = head;
           head = p;
        }
    }
    
    public void addLast(T val){
        Node<T> p = new Node(val);
        if(isEmpty()){
            head = tail = p;
        }else{
            tail.next = p;
            tail = p;
        }
    }
    
    public void addPos(int pos, T val) {
        Node<T> p = new Node(val);

        if (pos <= 0) {
            addFirst(val);
        } else {
            Node<T> current = head;
            int currentPosition = 0;

            while (current != null && currentPosition < pos - 1) {
                current = current.next;
                currentPosition++;
            }

            if (current != null) {
                p.next = current.next;
                p.pre = current;
                current.next = p;

                if (p.next != null) {
                    p.next.pre = p;
                }
            } else {
                addLast(val);
            }
        }

    }
    
    public void addMany(T [] a){
        for(T i : a){
            Node<T> p = new Node(i);
            if(isEmpty()){
                head = tail = new Node(a[0]);
            }else{
                tail.next = p;
                tail = p;
            }
        }
    }
    
    public int sizeDLL(){
        Node tmp = head;
        int size = 0;
        while(tmp != tail){
            size++;
            tmp = tmp.next;
        }
            
        return ++size;
    }
    
    public int indexOf(T val){
        Node<T> tmp = head.next;
        if (val == head.val) return 0;
        if (val == tail.val) return sizeDLL();
        if (isEmpty()) return -1;
        
        int pos = -1;
        for(int i = 1; i < sizeDLL()-2; i++){
            if(tmp.val == val){
                pos = i-1;
            }else{
                tmp = tmp.next;
            }
        }
        
        return pos;
    }
    
    public T searchByIndex(int index) {
        Node<T> tmp = head;
        int currentPosition = 0;
        
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }

        

        while (tmp != null && currentPosition < index-1) {
            tmp = tmp.next;
            currentPosition++;
        }

        if (tmp == null) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        return tmp.val;
    }
    
    public void removeFirst(){
        if(!isEmpty()){
            if (head == tail){
                head = tail = null;
            }
            head = head.next;
        }else{
            System.out.println("Empty Double LinkedList");
        }
    }
    
    public void removeLast(){
        if(!isEmpty()){
            if(head == tail){
                head = tail = null;
            }else{
                Node tmp = head;
                while(!tmp.next.equals(tail)){
                    tmp = tmp.next;
                }
                tmp.next = null;
                tail = tmp;
            }
        }else{
            System.out.println("Empty Double LinkedList");
        }
    }
    
    public void removePos(int pos){
        if(!isEmpty()){
            if(head == tail){
                head = tail = null;
            }else if(pos == 0){
                removeFirst();
            }else if(pos == sizeDLL()){
                removeLast();
            }else{
                Node<T> tmp = head;
                int i = 1;
                while(i < pos-1){
                    tmp = tmp.next;
                    i++;
                }
                tmp.next = tmp.next.next;
            }
        }else{
            System.out.println("Empty Double LinkedList");
        }
    }
    
    public void removeAll(){
        head = null;
        tail = null;
    }
    
    public void printLast(){
        Node<T> p = tail;
        System.out.println(p.val);
    }
    
    public void printFirst(){
        Node<T> p = head;
        System.out.println(p.val);
    }
    
    public void printAll(){
        Node<T> p = head;
        if (p == null) {
            System.out.println("Double LinkedList is empty");
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
public class DoubleLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.format(String.join(""), Collections.nCopies(10, "----")); 
        DoublerLinkedList dll = new DoublerLinkedList();
        
        Integer [] test = {2, 1, 4, 8};
        
        dll.addFirst("Hello");
        dll.addFirst("How are you");
        dll.addFirst("I'm fine");
        System.out.println("After addFirst");
        dll.printAll();
        dll.addLast(3);
        dll.addLast(15);
        System.out.println("After addLast");
        dll.printAll();
        dll.addPos(1, 13);
        System.out.println("After addPos 13 at index 1");
        dll.printAll();
        dll.addPos(3, 20);
        System.out.println("After addPos 20 at index 3");
        dll.printAll();
        dll.addPos(7, 11);
        System.out.println("After addPos 11 at index 7");
        dll.printAll();
        dll.addMany(test);
        System.out.println("After addMany");
        dll.printAll();
        System.out.println("Size of Single LinkedList");
        System.out.println(dll.sizeDLL());
        System.out.println("After get indexOf 11");
        System.out.println(dll.indexOf(11));
        
        System.out.println("After search by index 5");
        System.out.println(dll.searchByIndex(5));
        
        dll.removeFirst();
        System.out.println("After remove first");
        dll.printAll();
        
        dll.removeLast();
        System.out.println("After remove last");
        dll.printAll();
        
        dll.removePos(4);
        System.out.println("After remove at 4th");
        dll.printAll();
        
        dll.removeAll();
        System.out.println("After remove ALL");
        dll.printAll();
    }
    
}
