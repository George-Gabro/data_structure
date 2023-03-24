import java.lang.IllegalStateException;

public class Queue<T> {


    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(5);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        System.out.println("Initial Queue:");
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());

        queue.enqueue("6");

        System.out.println("Final Queue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
    private T[] elements;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        elements = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int size() {
        return size;
    }
}
