public class Array {
    private int[] arr;
    private int size;

    public Array(int size) {
        arr = new int[size];
        this.size = size;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = value;
    }

    public int size() {
        return size;
    }
}
