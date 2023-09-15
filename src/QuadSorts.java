import static java.lang.System.arraycopy;

/**
 *
 * @author Cardin N Ben A
 * @version 3.0, 09/15/2023
 */
public class QuadSorts {

    /**
     * This method uses groups of two elements at the same time and sorts each individual one to provide a finished sorted array.
     *
     * @param arr the original array
     * @return a sorted array
     */

    public static int[] bubbleSort(int[] arr){

        int[] tarr = arr;
        //loops n^2 through the array, worst case scenario it takes all of these times, but otherwise it just loops through and tests
        for(int j = 0; j < tarr.length; j++){
            for(int i = 1; i < tarr.length; i++) {

                //tests if the two values being targeted are sorted themselves, if they aren't it switches them
                if(tarr[i-1] > tarr[i]){
                    int temp = tarr[i];
                    tarr[i] = tarr[i-1];
                    tarr[i-1] = temp;
                }

            }
        }

        return tarr;
    }

    /**
     * This method finds the smallest of each value and puts it at the front until the array is completely sorted.
     *
     * @param arr the original array
     * @return a sorted array
     */
    public static int[] selectionSort(int[] arr) {

        //creates temporary array so as not to edit original array
        int[] tarr = arr;

        //loops n^2 through the array
        for(int i = 0; i < tarr.length; i++) {
            int mindex = i;
            for(int j = i; j < tarr.length; j++) {

                //updating smallest value
                if(tarr[j] < tarr[mindex]) {
                    mindex = j;
                }

            }
            //switches smallest value position
            int temp = tarr[i];
            tarr[i] = tarr[mindex];
            tarr[mindex] = temp;

        }
        return tarr;
    }

    /**
     * This method takes each individual value and finds a place for it among the rest of the values.
     *
     * @param arr the original array
     * @return a sorted array
     */
    public static int[] insertionSort(int[] arr) {

        int[] tarr = arr;
        //starting with the first value-in-question (obj) thru the end
        for(int item = 1; item < tarr.length; item++) {

            int obj = tarr[item];
            // for each item before value-in-question
            for(int back = item - 1; back >= 0; back--) {

                //if the previous item is more than the value-in-question then copy it forward
                if(tarr[back] > obj) {
                    tarr[back+1] = tarr[back];
                    tarr[back] = obj;
                    //if it's the last value just copy it there
                    if (back == 0){
                        tarr[back] = obj;
                    } else if (tarr[back-1] < obj) {
                        tarr[back] = obj;
                    }
                    //if the previous item is less than the value-in-question then let it be
                }
            }
        }
        return tarr;
    }

    /**
     * This method splits the array into halves recursively until you can't split each array more, then it puts the arrays back together and sorts them at the same time as it places them back together.
     *
     * @param arr the original array
     * @return a sorted array
     */
    public static int[] mergeSort(int[] arr){

        if (arr.length <= 1){
            return arr;
        }

        //finds the midpoint of the array
        int midIndex = arr.length / 2;

        //creates two empty arrays based on the subsections
        int[] left = new int[midIndex];
        int[] right = new int[arr.length - midIndex];

        //copies the values of the arrays into the subsections
        arraycopy(arr, 0, left, 0, midIndex);
        arraycopy(arr, midIndex, right, 0, arr.length - midIndex);

        //recursively calls upon itself to keep dividing the arrays in half
        left = mergeSort(left);
        right = mergeSort(right);

        int[] what = merge(arr, left, right);
        return what;
    }

    /**
     * This is a helper method for the mergeSort method that sorts the individual pieces to be merged and merges them together.
     *
     * @param arr the original array
     * @param left the left side of the array to be sorted
     * @param right the right side of the array to be sorted
     * @return the merged array out of the left and right
     */
    public static int[] merge(int[] arr, int[] left, int[] right){

        // writes a new sorted array based on the indexes of the smaller arrays
        int leftIndex = 0, rightIndex = 0, sortedIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {

                arr[sortedIndex++] = left[leftIndex++];

            } else {

                arr[sortedIndex++] = right[rightIndex++];

            }
        }

        // adds any excess values from the left array
        while (leftIndex < left.length){

            arr[sortedIndex++] = left[leftIndex++];

        }

        // adds any excess values from the right array
        while (rightIndex < right.length){

            arr[sortedIndex++] = right[rightIndex++];

        }

        return arr;
    }
}