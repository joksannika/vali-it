package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 2, 3, 4})));
        System.out.println(min(new int[]{58, 67, 8, 234}));
        multiplyTable(5,5);

    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int length = inputArray.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = inputArray[length - i - 1];
        }
        return array;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (i + 1) * 2;
        }
        return array;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) {
    int min = x[0];
    for (int i = 1; i < x.length; i++){
        if ( min >= x[i] ){
        min=x[i];
        }
    }
        return min;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int max = x[0];
        for (int i = 1; i < x.length; i++){
            if ( max <= x[i]){
            max = x[i];
            }
        }
        return max;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int sum = 0;
        for (int element : x){
            sum += element; //sum=sum+i
        }
        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        for (int j = 1; j <= y; j++) {
            for (int i = 1; i <= x; i++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // TODO, for loop sobib
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        if(n ==0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }else{
            int a = 0;
            int b = 1;
            for(int i = 1; i < n; i++){
                int tmp = a;
                a = b;
                b = tmp + a;
            }
            return b;
        }
       /* if(n == 0) {
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return fibonacci(n+2) + fibonacci(n-2); */
    }


    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20


    public static int sequence3n(int x, int y) {
    int i = 10;
    while(i>1) {
        if (i % 2 == 0) {
            i = i / 2;
        } else {
            i = 3 * i + 1;
        }
        System.out.println(i);
    }
     return i;
    }}
