import java.util.Scanner;

public class question3{

    public static int countsinglesocks(int[] arrNum) {
        int singlecount = 0;
        int maxSockId = maxSockId(arrNum);
        int[] sockCount = new int[maxSockId + 1];
        for (int sockId : arrNum) {
            sockCount[sockId]++;
        }
        for (int count : sockCount) {
            if (count > 0 && count % 2 != 0) {
                singlecount++;
            }
        }

        return singlecount;
    }

    private static int maxSockId(int[] arrNum) {
        int maxSockId = Integer.MIN_VALUE;
        for (int sockId : arrNum) {
            if (sockId > maxSockId) {
                maxSockId = sockId;
            }
        }
        return maxSockId;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int s = sc.nextInt();
        int[] a = new int[s];
        System.out.print("Enter the " + s + " Elements: ");
        for (int i = 0; i < s;i++)
        {
            a[i] = sc.nextInt();
        }
        int output = countsinglesocks(a);
        System.out.println("Count of singular socks = " + output);
    }
}
