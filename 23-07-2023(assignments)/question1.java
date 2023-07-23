import java.util.Arrays;
import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arrNum = new int[n];
        System.out.print("Enter the " + n + " Elements: ");
        for(int i = 0 ;i < n;i++)
        {
            arrNum[i] = sc.nextInt();
        }
        int[] cumMul = calCumMuls(arrNum);
        System.out.println("arrNum = " + Arrays.toString(cumMul));
    }
    public static int[] calCumMuls(int[] arr) {
        int[] cumulativeMultiples = new int[arr.length];
        int cm = 1; 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cm = 0;
            }
            cm *= arr[i];
            cumulativeMultiples[i] = cm;
        }
        return cumulativeMultiples;
    }
}