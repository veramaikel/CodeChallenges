package sort.mergesort;

/*
Merge Sort Algorithm
 */
public class MergeSort {

    public static Integer[] sort(Integer[] a){

        if(a.length < 2) return a;

        Integer[] result = new Integer[a.length];

        Integer[] left = new Integer[a.length/2];
        Integer[] right = new Integer[a.length - left.length];

        System.arraycopy(a, 0, left, 0, a.length / 2);

        System.arraycopy(a, a.length / 2, right, 0, a.length - a.length / 2);

        left = sort(left);

        right = sort(right);


        int li = 0, ri = 0, i = 0;
        for (; i < result.length && li < left.length && ri < right.length; i++) {
            if(left[li].compareTo(right[ri]) > 0){
                result[i] = right[ri];
                ri++;
            }
            else {
                result[i] = left[li];
                li++;
            }
        }

        for (; i < result.length && ri < right.length ; i++, ri++) {
            result[i] = right[ri];
        }

        for (; i < result.length && li < left.length ; i++, li++) {
            result[i] = left[li];
        }

        return result;
    }

}
