package ee.bcs.valiit.sample;

public class LoopSample {
    public static void main(String[] args) {
        int[] array = {2, 5, 7};
        int i = 0; //while, 4 rida
        while (i < array.length) {
            System.out.println(array[i]);
            i++;
        }

        for (int j = 0; j < array.length; j++) { //for, l[hem
            System.out.println(array[j]);
        }

        for (int i1 : array) { //for each, veel l[hem
            System.out.println(i1);
        }
    }
}
