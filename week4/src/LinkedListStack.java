public class LinkedListStack<T> {
   private int size;
   private Node<T> top;

   public LinkedListStack(){
       size = 0;
       top = null;
   }
   public int size(){
       return size;
   }
   public boolean isEmpty(){
       return size == 0;
   }
   public void push(T elememnt){
       Node<T> newNode = new Node<>(elememnt);
       if (!isEmpty()){
           newNode.next = top;
       }
       top = newNode;
       size++;
   }
   public Node<T> pop(){
       Node<T> temp;
       if (!isEmpty()){
            temp = top;
            top = top.next;
       }
       else{
           return null;
       }
       size--;
       return temp;
   }
   public T peek(){
       if (isEmpty()){
           return null;
       }
       return top.data;
   }
   public void printStack(){

   }
}


// initialize class Node with datatype T
class Node<T>{
    T data;
    Node<T> next;
    public Node(T data){
        this.data = data;
        next = null;
    }
}