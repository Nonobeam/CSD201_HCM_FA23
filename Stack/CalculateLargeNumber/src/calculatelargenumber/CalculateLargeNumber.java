package calculateLargeNumber;

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
    
    //Take out top node and return the value of it
    public T pop(){
        T topValue = null;
        if(!isEmpty()){
            topValue = top.val;
            top = top.next;
        }
        
        return topValue;
    }
    
    //Looke for teh value of the top node without remove it
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
public class CalculateLargeNumber {
    
    public static String addition(String a, String b){
        StackNode<String> stackA = new StackNode();
        StackNode<String> stackB = new StackNode();
        int lengthA = a.length();
        int lengthB = b.length();
        String result = "";
        
        for (int i = 0; i < lengthA; i++){
            stackA.push(a.substring(i, i+1));
        }
        
        for (int i = 0; i < lengthB; i++){
            stackB.push(a.substring(i, i+1));
        }
        
        int over = 0;
        while(!stackA.isEmpty() || !stackB.isEmpty()){
//            if (stackA.isEmpty()){
//                result += stackB.pop()
//            }
            int plus = Integer.parseInt(stackA.pop()) + Integer.parseInt(stackB.pop());
            if (over != 0){
                if (plus % 10 != 0){
                    over = plus % 10;
                }
            }else{
                if (plus)
            }
            
            String subResult = String.valueOf(plus);
            subResult.concat(result);
            result = subResult;
        }
        
        return result;
    }
    
    public static String subtraction(String a, String b){
        
    }
    
    public static String multiplication(String a, String b){
        
    }
    
    public static String division(String a, String b){
        
    }

    public static void main(String[] args) {
        //String with the length of 2,147,483,647 characters
        String a = "9732467560132746410234434";
        String b = "4347560260340351378410347";
        
        System.out.println(addition(a, b));
        System.out.println(subtraction(a, b));
        System.out.println(multiplication(a, b));
        System.out.println(division(a, b));
        
    }
    
}
