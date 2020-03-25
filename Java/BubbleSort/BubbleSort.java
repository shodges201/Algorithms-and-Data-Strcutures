class BubbleSort{
    static int bubblesort(int[] array){
        int length = array.length;
        if(length <= 1){
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = 1;
        boolean swapped = false;
        int numIterations = 0;
        while(swapped || !(rightIndex > length-1)){
            System.out.println("leftIndex: " + leftIndex);
            System.out.println("rightIndex: " + rightIndex);
            if(rightIndex > length - 1){
                leftIndex = 0;
                rightIndex = 1;
                swapped = false;
            }
            int leftItem = array[leftIndex];
            int rightItem = array[rightIndex];
            System.out.println("leftItem: " + leftItem);
            System.out.println("rightItem: " + rightItem);
            if(leftItem > rightItem){
                System.out.println("swapping");
                swap(array, leftIndex, rightIndex);
                swapped = true;
            }
            leftIndex++;
            rightIndex++;
            numIterations ++;
        }
        return numIterations;
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
        int numIterations = bubblesort(array);
        printArray(array);
        System.out.println("numIterations: " + numIterations);
    }
}
