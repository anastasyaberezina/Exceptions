import java.util.ArrayList;
import java.util.Arrays;

public class Exception1 {

	public static void main(String[] args) {
		int[] array1 = new int[]{1,2,3,4,5,6,7};
		int[] array2 = new int[]{2,4,6,8,10};
		System.out.println("Первый массив " + Arrays.toString(array1));
        System.out.println("Второй массив " + Arrays.toString(array2));
        System.out.println("Разница двух  массивов " + lengthCheck(array1, array2));
        System.out.println("Частное двух массивов " + checkArr(array1, array2));
	}

    public static ArrayList<Integer> lengthCheck(int[] arra1, int[] arra2) {
        ArrayList<Integer> result = new ArrayList<>();
        int min = Math.min(arra1.length, arra2.length);
        int max = Math.max(arra1.length, arra2.length);
        if (min < 1) {
            throw new RuntimeException("Один из массивов пустой!");
        }

        if (min < max) {
            throw new RuntimeException("Массивы по длине не равны!");
        }
            
        for (int i = 0; i < min; i++) {
            result.add(arra1[i] - arra2[i]);
        }
        return result;
    }

    public static ArrayList<Float> checkArr(int[] arr1, int[] arr2) {
        ArrayList<Float> resu = new ArrayList<>();
        int min = Math.min(arr1.length, arr2.length);
        int max = Math.max(arr1.length, arr2.length);

        if (min < 1) {
            throw new RuntimeException("Один из массивов пустой!");
        }

        if (min < max) {
            throw new RuntimeException("Массивы по длине не равны!");
        }

            
        for (int i = 0; i < min; i++) {
            if (arr2[i] != 0) {
                resu.add((float) (arr1[i] / arr2[i]));
            } else {
                throw new RuntimeException("Деление на ноль!");
            }   
        }
        return resu;
    }
}