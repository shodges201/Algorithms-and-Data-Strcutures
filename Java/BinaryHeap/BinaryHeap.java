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
            int childIndex = array.size() - 1;
            // if child > parent we need to swap
            bubbleUp(childIndex);
        }
    }

    // removes the root node and takes the last element and replaces it with the
    // root and bubbles down
    public Integer poll() {
        Integer root = array.get(0);
        Integer lastItem = array.remove(array.size() - 1);
        // set last item to be the root and bubble down
        array.set(0, lastItem);
        bubbleDown(0);
        return root;
    }

    public Integer remove(Integer value){
        int targetIndex = linearScan(value);
        //if the target item is the last one then we can just return the value, otherwise
        //we have to swap the last item with the target and bubble up
        if(!(targetIndex == array.size()-1) && targetIndex != -1){
            swap(targetIndex, array.size()-1);
            array.remove(array.size()-1);
            int parentIndex = getParentIndex(targetIndex);
            // if the swapped value is greater than the parent than we can bubble down
            System.out.println("before bubbling: " + array);
            if(array.get(targetIndex).intValue() > array.get(parentIndex).intValue() || parentIndex == targetIndex){
                bubbleDown(targetIndex);
            }
            else{
                bubbleUp(targetIndex);
            }
        }
        else{
            array.remove(array.size()-1);
        }
        return value;
    }

    private int linearScan(Integer item){
        int index = -1;
        for(int i = 0; i < array.size()-1; i++){
            if(item.equals(array.get(i))){
                index = i;
                return index;
            }
        }
        return index;
    }

    private void bubbleDown(int parentIndex) {
        int leftChildIndex = (parentIndex * 2) + 1;
        int rightChildIndex = (parentIndex * 2) + 2;
        Integer leftChildValue;
        Integer rightChildValue;
        if (leftChildIndex > array.size() - 1) {
            leftChildValue = Integer.MAX_VALUE;
        } else {
            leftChildValue = array.get(leftChildIndex);
        }
        if (rightChildIndex > array.size() - 1) {
            rightChildValue = Integer.MAX_VALUE;
        } else {
            rightChildValue = array.get(rightChildIndex);
        }
        Integer parentValue = array.get(parentIndex);
        while (parentValue > leftChildValue || parentValue > rightChildValue) {
            if (leftChildValue.intValue() <= rightChildValue.intValue()) {
                swap(parentIndex, leftChildIndex);
                parentIndex = leftChildIndex;
            } else {
                swap(parentIndex, rightChildIndex);
                parentIndex = rightChildIndex;
            }
            leftChildIndex = (parentIndex * 2) + 1;
            rightChildIndex = (parentIndex * 2) + 2;
            if (leftChildIndex > array.size() - 1) {
                leftChildValue = Integer.MAX_VALUE;
            } else {
                leftChildValue = array.get(leftChildIndex);
            }
            if (rightChildIndex > array.size() - 1) {
                rightChildValue = Integer.MAX_VALUE;
            } else {
                rightChildValue = array.get(rightChildIndex);
            }
            parentValue = array.get(parentIndex);
        }
    }

    private void bubbleUp(int childIndex) {
        int parentIndex = getParentIndex(array.size() - 1);
        Integer childVal = array.get(childIndex);
        Integer parentVal = array.get(parentIndex);
        while (childVal.intValue() < parentVal.intValue()) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            if (getParentIndex(childIndex) >= 0) {
                parentIndex = getParentIndex(childIndex);
            } else {
                // if the child is now the root then exit the loop
                break;
            }
            childVal = array.get(childIndex);
            parentVal = array.get(parentIndex);
        }
    }

    //swap the values of the items at index1 and index2
    private void swap(int index1, int index2) {
        Integer temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    private int getParentIndex(int childIndex) {
        int parentIndex = 0;
        // even indexed item means its a right child
        if (childIndex % 2 == 0) {
            parentIndex = (childIndex - 2) / 2;
        }
        // odd indexed child is a left child
        else {
            parentIndex = (childIndex - 1) / 2;
        }
        if(parentIndex < 0){
            parentIndex = 0;
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
        bh.insert(2);
        bh.printHeap();
        bh.insert(3);
        bh.printHeap();
        bh.insert(5);
        bh.printHeap();
        bh.poll();
        bh.printHeap();
        bh.remove(5);
        bh.printHeap();
        bh.remove(5);
        bh.printHeap();
        bh.remove(1);
        bh.printHeap();
    }

}