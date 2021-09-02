package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;

public class Lesson3 {

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        //int factorial = x;
        int sum = 1;
        for (int i = 1; i <= x; i++) {
            sum = sum * i;
        }
        return sum;
    }

    // TODO tagasta string tagurpidi //substring, char @
    public static String reverseString(String a) {
        String reversed = "";
        for (int i = 0; i < a.length(); i++) {
            reversed = a.charAt(i) + reversed;
        }
        return reversed;

    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        if (x == 1){
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // TODO sorteeri massiiv suuruse järgi (v'iksemast suuremaks).
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    // mitu for ts[kklit
    public static int[] sort(int[] a) {
        int temp; //ajutine muutuja
        for (int j = 0 ; j < a.length -1; j++) { //sisemise ts[kli pikkus
            for (int i = 0; i < a.length-1; i++) {  //if tuleb teha rivi algusest kuni l]puni
                if (a[i] > a[i + 1]) {  //vaatab kas esimene ja teine tuleb vahetada
                    temp = a[i]; //salvestab ajutise
                    a[i] = a[i + 1]; //esimene saab teise v''rtuse
                    a[i + 1] = temp; //teine endise esimese v''rtuse
                }
            }
        }
        return a;
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int a = 0;
        int b = 1;
        int sum = 0;
        while(a + b <= x){
            int c = a + b;
            a = b;
            b = c;
            if(b % 2 == 0){
                sum += b;
            }
        }
        return sum;
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        Map <String, String> morseCodes = new HashMap<>();
        morseCodes.put("s", "...");
        morseCodes.put("o", "---");
        morseCodes.put("h","....");
        morseCodes.put("e",".");
        morseCodes.put("l",".-..");
        String result = "";
        for(int i = 0; i < text.length(); i++){
            String a = text.substring(i, i +1);
            result += morseCodes.get(a);
            if(i < text.length() -1) {
                result += " ";
            }
        }
        return result;
    }
}
