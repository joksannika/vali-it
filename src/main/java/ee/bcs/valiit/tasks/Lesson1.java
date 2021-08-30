package ee.bcs.valiit.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - min");
        System.out.println("2 - max");
        System.out.println("3 - abs");
        System.out.println("4 - isEven");
        System.out.println("5 - min3");
        System.out.println("6 - max3");
        int command = scanner.nextInt();
        if (command == 1) {
            System.out.println("Sisesta esinene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Vastus on:" + min(a, b));
        }
        else if (command == 2){
            System.out.println("Sisesta esinene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Vastus on:" + max(a,b));
        }
        else if (command == 3){
            System.out.println("Sisesta esinene number");
            int a = scanner.nextInt();
            System.out.println("Vastus on:" + abs(a));
        }
        else if (command == 4){
            System.out.println("Sisesta esinene number");
            int a = scanner.nextInt();
            System.out.println("Vastus on:" + isEven(a));
        }
        else if (command == 5){
            System.out.println("Sisesta esinene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int c = scanner.nextInt();
            System.out.println("Vastus on:" + min3 (a, b, c));
        }
        else if (command == 6){
            System.out.println("Sisesta esinene number");
            int a = scanner.nextInt();
            System.out.println("Sisesta teine number");
            int b = scanner.nextInt();
            System.out.println("Sisesta kolmas number");
            int c = scanner.nextInt();
            System.out.println("Vastus on:" + max3(a, b, c));
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        // String tekst = "\"\\\"\\\\\"\"";
        return "\"\\\"\\\\\"\"";
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        return max(a, max(b, c));
    }

}
