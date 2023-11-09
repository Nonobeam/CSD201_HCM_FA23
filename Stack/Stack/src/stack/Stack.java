package stack;

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

public class Stack {
    public static void main(String[] args) {
        StackNode<Integer> stack = new StackNode<>();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(8);
        stack.push(1);
        stack.push(11);
        
        System.out.println("PEAK:");
        System.out.print(stack.peek());
        System.out.println("");
        
        System.out.println("POP:");
        System.out.print(stack.pop());
        System.out.println("");
        System.out.println(stack.peek());
        
        System.out.println("CLEAR:");
        stack.clear();
        System.out.println(stack.peek());
        System.out.println("");

    }   
}
