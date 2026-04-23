import java.util.*;

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public int top() {
        int res = pop();
        q.add(res);
        return res;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}