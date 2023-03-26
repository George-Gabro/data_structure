import java.util.*;

public class DoubleEndedPriorityQueue {
    private Node front;
    private Node back;

    private static class Node {
        int item;
        int priority;
        Node prev;
        Node next;

        Node(int item, int priority) {
            this.item = item;
            this.priority = priority;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", priority=" + priority +
                    '}';
        }
    }

    public DoubleEndedPriorityQueue() {
        front = null;
        back = null;
    }

    public void push(int item, int priority) {
        Node newNode = new Node(item, priority);
        if (front == null) {
            front = newNode;
            back = newNode;
        } else {
            Node curr = front;
            while (curr != null && curr.priority <= priority) {
                curr = curr.next;
            }
            if (curr == null) {
                newNode.prev = back;
                back.next = newNode;
                back = newNode;
            } else if (curr.prev == null) {
                newNode.next = front;
                front.prev = newNode;
                front = newNode;
            } else {
                newNode.prev = curr.prev;
                newNode.next = curr;
                curr.prev.next = newNode;
                curr.prev = newNode;
            }
        }
    }

    public int popFront() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        int item = front.item;
        if (front == back) {
            front = null;
            back = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        return item;
    }

    public int popBack() {
        if (back == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        int item = back.item;
        if (front == back) {
            front = null;
            back = null;
        } else {
            back = back.prev;
            back.next = null;
        }
        return item;
    }

    public static void main(String[] args) {
        DoubleEndedPriorityQueue queue = new DoubleEndedPriorityQueue();
        queue.push(1,10);
        queue.push(2,5);
        queue.push(3,7);
        queue.push(5,8);
        queue.push(6,100);

        System.out.println("Current high and low priority");
        System.out.println(queue.back);
        System.out.println(queue.front);

        System.out.println("popping low and high");
        queue.popBack();
        queue.popFront();

        System.out.println("Current high and low priority");
        System.out.println(queue.back);
        System.out.println(queue.front);
    }
}
