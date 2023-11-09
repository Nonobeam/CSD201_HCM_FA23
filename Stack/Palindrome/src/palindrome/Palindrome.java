package palindrome;

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

public class Palindrome {
    
    public static boolean palindrome(String val){
        StackNode<Character> stack = new StackNode();
        int length = val.length();
        
        if(length % 2 != 0){
            return false;
        }
        for(int i = 0; i < length; i++){
            if(val.charAt(i) == '{' || val.charAt(i) == '[' || val.charAt(i) == '('){
                stack.push(val.charAt(i));
            }else if(val.charAt(i) == '}' || val.charAt(i) == ']' || val.charAt(i) == ')'){
                char a = stack.pop();
                char b = val.charAt(i);
                if(a == '{'){
                    if(!(b == '}')){
                        return false;
                    }
                }
                if(a == '['){
                    if(!(b == ']')){
                        return false;
                    }
                }
                if(a == '('){
                    if(!(b == ')')){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "([({})])";
        String test2 = "{({}]]}";
        
        System.out.println(palindrome(test1));
        System.out.println(palindrome(test2));
    }
    
}
