import java.util.Scanner;

public class Exceptions2 {
    public static void main(String[] args) {
        processingNumber(0);
    }

    private static float returnNumber() {
        System.out.println("Введите дробное число: ");
        try (Scanner scan = new Scanner(System.in)) {
            float number = scan.nextFloat();
            System.out.println(number);
            return number;
        }
    }
    
    private static float processingNumber(float num){
        try {
            if (num % 1 == 0){
            System.out.println(num);
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат: введено не дробное число!");
            returnNumber();
        }
        return 0;
    }
}


