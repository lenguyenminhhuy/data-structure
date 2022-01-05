public class StackUsingLinkedList {
    private class Node{
        int value;
        Node next;
    }
    Node top;

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int x){
        Node temp = new Node();
        if (temp == null){
            System.out.println("Stack is full");
        }
        temp.value = x;
        temp.next = top;
        top = temp;
    }
    public int pop(){
        if (top == null){
            System.out.println("stack is empty");
        }
        int result = top.value;
        top = top.next;
        return result;
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        return top.value;
    }



    public void display(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            Node temp = top;
            while (temp!=null){
                System.out.printf("%d-->", temp.value);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList s1 = new StackUsingLinkedList();
        s1.push(2);
        s1.push(3);
        s1.push(5);
//        s1.pop();
        s1.display();
//        System.out.println(s1.peek());

    }
}

