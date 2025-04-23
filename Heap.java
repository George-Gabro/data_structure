import java.util.ArrayList;
import java.util.List;

/**
 * Heap super class implements the needed basic heap methods
 */
abstract class Heap {
    private final List<Integer> list; // list for saving the elements
    private int size; // var to keep trace of the size of the heap

    /**
     * new list
     */
    public Heap() {
        this.list = new ArrayList<>();
        this.size = 0;
    }

    /**
     * get left node of element index i
     *
     * @param index element index
     * @return leftNode or -1 if not exist
     */
    public int leftNode(int index) {
        int leftNodeIndex = indexLeftNode(index); // get left node index
        if (leftNodeIndex < getSize()) { // if index is not out of range of the heap
            return getList().get(leftNodeIndex); // return the leftNode
        } else { // if not exists
            return -1;
        }
    }

    /**
     * get right node of element index i
     *
     * @param index element index
     * @return leftNode or -1 if not exist
     */
    public int rightNode(int index) {
        int rightNodeIndex = indexRightNode(index); // get right node index
        if (rightNodeIndex < getSize()) { // if index is not out of range of the heap
            return getList().get(rightNodeIndex); // return the rightNode
        } else { // if not exists
            return -1;
        }
    }

    /**
     * get parent of element index i
     *
     * @param index element index
     * @return 0 if root || index of parent || -1 if not found
     */
    public int parent(int index) {
        int parentNodeIndex = indexParent(index); // get parent index
        if (parentNodeIndex >= 0) { // if the index is the root or node
            return getList().get(parentNodeIndex); // return the parentNode
        } else { // if not exists
            return -1;
        }
    }

    /**
     * method to only get the index of the rightNode
     *
     * @param index i
     * @return index
     */
    public int indexRightNode(int index) {
        return (2 * index + 2);
    }

    /**
     * method to only get the index of the leftNode
     *
     * @param index i
     * @return index
     */
    public int indexLeftNode(int index) {
        return (2 * index + 1);
    }

    /**
     * method to only get the index of the parentNode
     *
     * @param index i
     * @return index
     */
    public int indexParent(int index) {
        return (index - 1) / 2;
    }

    /**
     * increaseSize by 1
     */
    public void increaseSize() {
        size++;
    }

    /**
     * decreaseSize by 1
     */
    public void decreaseSize() {
        size--;
    }

    /**
     * add element to the arrayList
     *
     * @param element int
     */
    public void add(int element) {
        list.add(element);
    }

    /**
     * size of heap
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    public List<Integer> getList() {
        return list;
    }

    /**
     * take a look at an index in the list
     *
     * @param index index
     * @return number
     */
    public abstract int peek(int index);

    /**
     * push an element to the heap
     *
     * @param element number
     */
    public abstract void push(int element);

    /**
     * remove the root of the heap
     *
     * @return removed number
     */
    public abstract int pop();
}
