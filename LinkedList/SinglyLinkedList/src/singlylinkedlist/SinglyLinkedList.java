/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

import java.util.Collections;

/**
 *
 * @author Nonobeam
 * Find me more on this https://nonobeam.github.io/myPorfolio/?fbclid=IwAR38ZSEEUKN8octg-XKC670qr7-FgkPzWOjaKp0wve6UQtT0fvwpMT8ejKA
 */

class Node<T>{
    T val;
    Node<T> next;
    
    public Node() {
    }

    public Node(T val) {
        this.val = val;
    }
    
    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }
    
}
class SingleLinkedList<T>{
    Node<T> head, tail;
    
    SingleLinkedList(){
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
    
    public void addPos(int pos, T val){
        Node<T> p = new Node(val);
        Node<T> tmp = head;
        
        if (isEmpty()) {
            head = tail = p;
        }else{
            //if the position is the first
            if(pos == 1){
                addFirst(val);
                return;
            }
            
            //if the position is randomly except the last
            int i = 1;
            while (i <= pos){
                if(i + 1 == pos && !tmp.next.equals(tail)){
                    p.next = tmp.next;
                    tmp.next = p;
                    return;
                }
                
                //ask PhD for tail = p;
                if(i + 1 == pos && tmp.next.equals(tail)){
                    tail.val = p.val;
                    return;
                }
                tmp = tmp.next;
                i++;
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
    
    public int sizeSLL(){
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
        if (val == tail.val) return sizeSLL();
        if (isEmpty()) return -1;
        
        int pos = -1;
        for(int i = 1; i < sizeSLL()-2; i++){
            if(tmp.val == val){
                pos = i-1;
            }else{
                tmp = tmp.next;
            }
        }
        
        return pos;
    }
    
    public T searchByIndex(int index) {
            if (index < 0) {
                throw new IllegalArgumentException("Index must be non-negative");
            }

            Node<T> currentNode = head;
            int currentPosition = 0;

            while (currentNode != null && currentPosition < index -1) {
                currentNode = currentNode.next;
                currentPosition++;
            }

            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Index out of range");
            }

            return currentNode.val;
        }
    
    public void removeFirst(){
        if(!isEmpty()){
            if (head == tail){
                head = tail = null;
            }
            head = head.next;
        }else{
            System.out.println("Empty Single LinkedList");
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
            System.out.println("Empty Single LinkedList");
        }
    }
    
    public void removePos(int pos){
        if(!isEmpty()){
            if(head == tail){
                head = tail = null;
            }else if(pos == 0){
                removeFirst();
            }else if(pos == sizeSLL()){
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
            System.out.println("Empty Single LinkedList");
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

public class SinglyLinkedList {
    
    
    //addFirst, addLast, addPos, addMany, size, indexOf, removefirst, removeLast, removePos, removeAll
   
    public static void main(String[] args) {
        System.out.format(String.join(""), Collections.nCopies(10, "----")); 
        SingleLinkedList sll = new SingleLinkedList();
        
        Integer [] test = {2, 1, 4, 8};
        
        sll.addFirst("Hello");
        sll.addFirst("How are you");
        sll.addFirst("I'm fine");
        System.out.println("After addFirst");
        sll.printAll();
        sll.addLast(3);
        sll.addLast(15);
        System.out.println("After addLast");
        sll.printAll();
        sll.addPos(1, 13);
        System.out.println("After addPos 13 at index 1");
        sll.printAll();
        sll.addPos(3, 20);
        System.out.println("After addPos 20 at index 3");
        sll.printAll();
        sll.addPos(7, 11);
        System.out.println("After addPos 11 at index 7");
        sll.printAll();
        sll.addMany(test);
        System.out.println("After addMany");
        sll.printAll();
        System.out.println("Size of Single LinkedList");
        System.out.println(sll.sizeSLL());
        System.out.println("After get indexOf 11");
        System.out.println(sll.indexOf(11));
        
        System.out.println("After search by index 3");
        System.out.println(sll.searchByIndex(3));
        
        sll.removeFirst();
        System.out.println("After remove first");
        sll.printAll();
        
        sll.removeLast();
        System.out.println("After remove last");
        sll.printAll();
        
        sll.removePos(4);
        System.out.println("After remove at 4th");
        sll.printAll();
        
        sll.removeAll();
        System.out.println("After remove ALL");
        sll.printAll();
        
    }
    
}
