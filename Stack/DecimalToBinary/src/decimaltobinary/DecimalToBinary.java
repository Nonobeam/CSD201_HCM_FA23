package decimaltobinary;

/**
 *
 * @author Nonobeam
 * Find me more on this https://nonobeam.github.io/myPorfolio/?fbclid=IwAR38ZSEEUKN8octg-XKC670qr7-FgkPzWOjaKp0wve6UQtT0fvwpMT8ejKA
 */

class Node<T>{
    T val;
    Node<T> next;
    
    Node(T data){
        this.val = data;
        this.next = null;
    }
}

class StackNode<T>{
    Node<T> top;
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public void clear(){
        if(!isEmpty()){
            top = null;
        }
    }
    
    public void push(T val){
        if(!isEmpty()){
            Node<T> newNode = new Node(val);
            newNode.next = top;
            top = newNode;
        }else{
            Node<T> newNode = new Node(val);
            top = newNode;
        }
    }
    
    public T pop(){
        T topValue = null;
        if(!isEmpty()){
            topValue = top.val;
            top = top.next;
        }
        
        return topValue;
    }
    
    public T peek(){
        if(!isEmpty()){
            return top.val;
        }else{
            return null;
        }
    }
    
    public int search(T val){
        Node<T> subNode = top;
        int index = 1;
        while(subNode != null){
            if (subNode.val.equals(val)){
                break;
            }
            index++;
            subNode = subNode.next;
        }
        return index;
    }
}

public class DecimalToBinary {

    public static void decToBin(int k) {
        StackNode s = new StackNode();
        System.out.print(k + " in binary system is: ");
        while (k > 0) {
            s.push(new Integer(k % 2));
            k = k / 2;
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        decToBin(11);
        System.out.println();
    }
}
