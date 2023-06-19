import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Exception2_1 {
    public static void main(String[] args) {
        stringNull();
    
    }

/* Задание 2

try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArrayIndexOutOfBoundsException e) {
   System.out.println("Invalid array index: " + e);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}

// Задание 3

public static void main(String[] args) {
    int a = 90;
    int b = 3;
    System.out.println(a / b);
    printSum(23, 234);
    int[] abc = {1, 2};
    abc[3] = 9;
}

public static void printSum(Integer a, Integer b) {
    System.out.println(a + b);
}*/

// Задание 4

    public static void stringNull(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст: ");
        try {
            String res = read.readLine();
            if(res.equals("")) throw new RuntimeException("Вы не ввели текст!");

            System.out.println(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}