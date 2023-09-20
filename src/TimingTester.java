public class TimingTester {

    /**
     * This main method tests each sort algorithm with a random set of elements.
     */
    public static void main(String[] args) {
        int[] numElements = {1000, 10000, 50000, 100000, 200000, 500000};

        for(int index = 0; index < numElements.length; index++){
            int NUM_ELEMENTS = numElements[index];

            int[][] testCases = new int[4][NUM_ELEMENTS]; //0 - bubble, 1 - selection, 2 - insertion, 3 - merge

            //Build a random array
            int[] originalList = new int[NUM_ELEMENTS];
            for(int i = 0; i < NUM_ELEMENTS; i++){
                originalList[i] = (int)(Math.random() * 1000) + 1;
            }

            //set each test case to deep copy of originalList
            for(int j = 0; j < testCases.length; j++){
                testCases[j] = copyArray(originalList);
            }

            //Sort them using each of the sorting methods
            long now = System.currentTimeMillis();
            QuadSorts.bubbleSort(testCases[0]);
            long after = System.currentTimeMillis();
            System.out.println("Bubble Sort sorted " + numElements[index] + " elements in " + (after - now) + " ms");

            now = System.currentTimeMillis();
            QuadSorts.selectionSort(testCases[1]);
            after = System.currentTimeMillis();
            System.out.println("Selection Sort sorted " + numElements[index] + " elements in " + (after - now) + " ms");

            now = System.currentTimeMillis();
            QuadSorts.insertionSort(testCases[2]);
            after = System.currentTimeMillis();
            System.out.println("Insertion Sort sorted " + numElements[index] + " elements in " + (after - now) + " ms");
            now = System.currentTimeMillis();
            QuadSorts.mergeSort(testCases[3]);
            after = System.currentTimeMillis();
            System.out.println("Merge Sort sorted " + numElements[index] + " elements in " + (after - now) + " ms");

            System.out.println();

            }

        }



    /**
     * This function will return a deep copy of the given array
     *
     * @param arr The array to be copied
     * @return copies array
     */
    public static int[] copyArray(int[] arr){
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            copy[i] = arr[i];
        return copy;
    }

}
