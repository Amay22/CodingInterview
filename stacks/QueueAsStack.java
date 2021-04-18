package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAsStack {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x){
        q.add(x);
    }

    public int pop(){
        int size = q.size()-1;
        while(size> 0) {
            q.add(q.remove());
            size--;
        }
        return q.remove();
    }

    public static void main(String[] args) {
        QueueAsStack p = new QueueAsStack();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
        System.out.println(p.pop());
    }
}
