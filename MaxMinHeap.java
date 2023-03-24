public class MaxMinHeap {
    private int[] heap;
    private int size;

    public MaxMinHeap(int capacity)
    {
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int position) { return (position - 1) / 2; }

    private int leftChild(int position) { return (2 * position) + 1; }

    private int rightChild(int position)
    {
        return (2 * position) + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    public void insert(int element)
    {
        heap[size] = element;

        int current_element = size;
        while (heap[current_element] > heap[parent(current_element)]) {
            swap(current_element, parent(current_element));
            current_element = parent(current_element);
        }
        size++;
    }

    private boolean isLeaf(int position)
    {
        return position > (size / 2) && position <= size;
    }

    private void maxHeapify(int position)
    {
        if (isLeaf(position))
            return;

        if (heap[position] < heap[leftChild(position)]
                || heap[position] < heap[rightChild(position)]) {

            if (heap[leftChild(position)]
                    > heap[rightChild(position)]) {
                swap(position, leftChild(position));
                maxHeapify(leftChild(position));
            }
            else {
                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            }
        }
    }

    public int getMax()
    {
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }

    public static void main(String[] arg)
    {
        MaxMinHeap maxHeap = new MaxMinHeap(15);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        System.out.println("Max min heap values from biggest to smallest");
        while (maxHeap.size != 0) {
            System.out.println(maxHeap.getMax());
        }
    }

}