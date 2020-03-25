class InsertionSort{
    public static void insertionSort(int[] array){
        int sortedIndex = 1;
        while(sortedIndex < array.length){
            int reverseIndex = sortedIndex;
            while(reverseIndex > 0 && array[reverseIndex-1] > array[reverseIndex] ){
                swap(array, reverseIndex, reverseIndex-1);
                reverseIndex--;
            }
            sortedIndex++;
        }
    }

    static void swap(int[] array, int leftIndex, int rightIndex){
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    static void printArray(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] array = new int[] {5, 4, 3, 2, 1};
        int[] emptyArray = new int[]{};
        insertionSort(array);
        insertionSort(emptyArray);
        printArray(array);
        printArray(emptyArray);
    }
}