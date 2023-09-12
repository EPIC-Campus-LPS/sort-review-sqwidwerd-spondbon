public class QuadSorts {

    public static int[] bubbleSort(int[] arr){
        int[] tarr = arr;
        for(int j = 0; j < tarr.length; j++){
            for(int i = 1; i < tarr.length; i++) {

                if(tarr[i-1] > tarr[i]){
                    int temp = tarr[i];
                    tarr[i] = tarr[i-1];
                    tarr[i-1] = temp;
                }

            }
        }

        return tarr;
    }

    public static int[] selectionSort(int[] arr) {

        int[] tarr = arr;

        for(int i = 0; i < tarr.length; i++) {
            int mindex = i;

            for(int j = i; j < tarr.length; j++) {

                if(tarr[j] < tarr[mindex]) {
                    mindex = j;
                }

            }

            int temp = tarr[i];
            tarr[i] = tarr[mindex];
            tarr[mindex] = temp;

        }
        return tarr;
    }

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



}
