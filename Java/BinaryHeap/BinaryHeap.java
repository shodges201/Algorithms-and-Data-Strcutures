import java.util.*;

class BinaryHeap {
    private ArrayList<Integer> array;
    private int numItems;

    public BinaryHeap() {
        array = new ArrayList<>();
        numItems = 0;
    }

    public void insert(Integer item) {
        array.add(item);
        numItems++;
        if (array.size() > 1) {
            System.out.println("array larger than one");
            int parentIndex = getParentIndex(array.size() - 1);
            int childIndex = array.size() - 1;
            // if child > parent we need to swap
            Integer childVal = array.get(childIndex);
            Integer parentVal = array.get(parentIndex);
            System.out.println(childVal);
            System.out.println(parentVal);
            while (childVal.intValue() < parentVal.intValue() && parentIndex >= 0) {
                childVal = array.get(childIndex);
                parentVal = array.get(parentIndex);
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
                parentIndex = getParentIndex(childIndex);
            }
        }
    }

    private void swap(int index1, int index2) {
        Integer temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    private int getParentIndex(int childIndex) {
        int parentIndex = -1;
        // even indexed item means its a right child
        if (childIndex % 2 == 0) {
            parentIndex = (childIndex - 2) / 2;
        }
        // odd indexed child is a left child
        else {
            parentIndex = (childIndex - 1) / 2;
        }
        return parentIndex;
    }

    public void printHeap() {
        System.out.println(array);
    }

    public static void main(String args[]) {
        BinaryHeap bh = new BinaryHeap();
        bh.insert(5);
        bh.printHeap();
        bh.insert(4);
        bh.printHeap();
        bh.insert(1);
        bh.printHeap();
        bh.insert(0);
        bh.printHeap();
    }

}