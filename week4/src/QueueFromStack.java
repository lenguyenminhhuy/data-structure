import java.util.Stack;

public class QueueFromStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    public void push(int x){
        if (s1.isEmpty()){
            front = x;
        }
        s1.push(x);
    }

    public int pop(){
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek(){
        if (!s2.isEmpty()){
            return s2.peek();
        }
        else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty(){
        if (s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        QueueFromStack q = new QueueFromStack();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        System.out.println(q.peek()); // 1
        System.out.println(q.pop()); // 1
        System.out.println(q.pop()); // 2
        System.out.println(q.pop()); // 3
        System.out.println(q.pop()); // 4
        System.out.println(q.pop()); // 5
        System.out.println(q.peek()); // 6
        System.out.println(q.pop()); // 6
    }
}
