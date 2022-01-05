package dynamicprogramming;

import java.util.*;

public class MinimumJumpsReachHome {
    public int findMinimumJumps(int[] forbidden, int a, int b, int x){
        int steps = 0;
        int nextIdx = 0;
        Queue<Node> myQueue = new LinkedList<>();
        Set visited = new HashSet();
        myQueue.add(new Node(0,false));
        visited.add(new Node(0, false));
        steps++;
        while (!myQueue.isEmpty()) {
            for (int i=0; i< myQueue.size(); i++){
                Node curPos = myQueue.poll();
                System.out.println(curPos.toString());

                nextIdx = curPos.val + a;
                if (nextIdx == x){
                    return steps;
                }
                if (!Arrays.asList(forbidden).contains(nextIdx) && nextIdx < 4000 && !visited.contains(new Node(nextIdx, false))){
                    visited.add(new Node(nextIdx, false));
                    myQueue.add(new Node(nextIdx, false));
                }

                if (!curPos.isLastForward){
                    nextIdx = curPos.val - b;
                    if (!Arrays.asList(forbidden).contains(nextIdx) && nextIdx >= 0 && !visited.contains(new Node(nextIdx,true))) {
                        visited.add(new Node(nextIdx, true));
                        myQueue.add(new Node(nextIdx, true));
                    }
                }
            }
            steps++;

        }
        return -1;
    }
    public static void main(String[] args){
        MinimumJumpsReachHome q1 = new MinimumJumpsReachHome();
        int[] forbidden1 = {14,4,18,1,15};
        int a1 = 3;
        int b1 = 15;
        int x1 = 9;
        int[] forbidden2 = {1,6,2,14,5,17,4};
        int a2 = 16;
        int b2 = 9;
        int x2 = 7;
        System.out.println(q1.findMinimumJumps(forbidden1, a1,b1,x1));
        System.out.println(q1.findMinimumJumps(forbidden2, a2,b2,x2));

    }
}

class Node {
    int val;
    boolean isLastForward;
    public Node(int val,boolean isLastForward){
        this.val = val;
        this.isLastForward = isLastForward;
    }

    public String toString() {
        return "value: " + this.val + " is backward?: " + this.isLastForward;
    }

}
