import java.util.*;

public class question2 {
    public static List<Integer> missNum(int[] arr) {
        List<Integer> missingNumbers = new ArrayList<>();
        int start = arr[0];
        int end = arr[arr.length - 1];
        
        boolean[] present = new boolean[end - start + 1];
        for (int num : arr) 
        {
            present[num - start] = true;
        }
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                missingNumbers.add(start + i);
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int s = sc.nextInt();
        int[] arr1 = new int[s];
        System.out.print("Enter the " + s + " Elements(in consectutive integers): ");
        for (int i = 0; i < s;i++)
        {
            arr1[i] = sc.nextInt();
        }
        List<Integer> missingNumbers1 = missNum(arr1);
        System.out.println("Missing numbers: " + missingNumbers1);   
    }
}
