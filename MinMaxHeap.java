import java.util.Arrays;

public class MinMaxHeap {

    private int[] heap;
    private int size;

    public MinMaxHeap(int capacity) {
        heap = new int[capacity];
    }

    public static void main(String[] args) {
        MinMaxHeap heap = new MinMaxHeap(10);

        heap.add(5);
        heap.add(1);
        heap.add(7);
        heap.add(3);
        heap.add(10);
        heap.add(2);
        heap.add(4);
        heap.add(8);
        heap.add(9);
        heap.add(6);

        while (!heap.isEmpty()) {
            System.out.print(heap.removeMin() + " ");
        }
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && heap[index] < heap[parent]) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int value) {
        if (size >= heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
