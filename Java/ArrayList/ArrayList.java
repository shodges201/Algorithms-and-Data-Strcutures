
public class ArrayList<E extends Object> implements Iterable<T> {
    private int capacity;
    private int size;
    private Object[] arr;

    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        size = 0;
        arr = new Object[initialCapacity];
    }

    public ArrayList() {
        capacity = 10;
        size = 0;
        arr = new Object[10];
    }

    public Iterator<ArrayList> iterator() { 
        return new ArrayListIterator<ArrayList>(this); 
    } 

    public void add(E item) {
        checkSize();
        size++;
        arr[size - 1] = item;
    }

    public void add(Integer index, E item){
        checkIndexBounds(index);
        checkSize();
        size++;
        Object left = arr[index];
        arr[index] = item;
        for(int i = index+1; i < size; i++){
            Object right = arr[i];
            arr[i] = left;
            left = right;
        }
    }

    public E get(Integer index){
        checkIndexBounds(index);
        return (E) arr[index];
    }

    public void set(Integer index, E item){
        checkIndexBounds(index);
        arr[index] = item;
    }

    public Boolean contains(E item){
        for(int i = 0; i < size; i++){
            if(item.equals(arr[i])){
                return true;
            }
        }
        return false;
    }

    public Integer indexOf(E item){
        for(int i = 0; i < size; i++){
            if(item.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    public Integer lastIndexOf(E item){
        Integer index = -1;
        for(int i = 0; i < size; i++){
            if(item.equals(arr[i])){
                index = i;
            }
        }
        return index;
    }
    /*
    * input type: Integer
    * input: index 
    * description: removes an element at index, and shifts the rest of the items over left to fill in the spaces
    * ouput: void 
    */

    //[1, 2, 3, 4, 5] 
    //[1, 2, 4, 5, null]

    public E remove(Integer index){
        checkIndexBounds(index);
        Object removedItem = arr[index];
        Object shiftItem = arr[size-1];
        arr[size-1] = null;
        for(int i = size-2; i >= index; i--){
            Object temp = arr[i];
            arr[i] = shiftItem;
            shiftItem = temp;
        }   
        size--;
        return (E)removedItem;
    }

    public boolean remove(E o){
        Integer index = indexOf(o);
        if(index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    public void clear(){
        size = 0;
        for(int i = 0; i < size; i++){
            arr[i] = null;
        }
    }

    public Boolean isEmpty(){
        return(size == 0);
    }

    public Integer size(){
        return size;
    }

    public String toString() {
        String stringArr = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringArr += arr[i];
            } else {
                stringArr += arr[i].toString() + ", ";
            }
        }
        // System.out.println("before last: " + stringArr);
        stringArr += "]";
        // System.out.println("after last: " + stringArr);
        return stringArr;
    }

    private void checkIndexBounds(Integer index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Unable to access item at index " + index.toString());
        }
    }

    /*
    * input: void
    * Checks whether the underlying array needs to be swapped out for an array double the size
    * returns: void
    */
    private void checkSize(){
        if(size == capacity){
            capacity *= 2;
            Object[] newArr = new Object[capacity];
            for(int i = 0; i < size; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }

    private void displayList(){
        String stringArr = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringArr += arr[i];
            } else {
                stringArr += arr[i].toString() + ", ";
            }
        }
        // System.out.println("before last: " + stringArr);
        stringArr += "]";
        // System.out.println("after last: " + stringArr);
        System.out.println(stringArr);
    }

    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        list.add("new item");
        list.add("newer item");
        list.add("newest item");
        System.out.println(list.toString());
        list.add(0, "hello");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(0) instanceof String);
        System.out.println(list.get(0).concat("great"));
        //list.get(9);
        //list.clear();
        System.out.println(list.toString());
        System.out.println(list.size());
        list.set(1, "great");
        System.out.println(list.toString());
        System.out.println(list.contains("hello"));
        System.out.println(list.indexOf("newer item"));
        System.out.println(list.lastIndexOf("newer item"));
        list.remove(1);
        System.out.println(list.toString());
        list.remove("hello");
        System.out.println(list.toString());
    }
}