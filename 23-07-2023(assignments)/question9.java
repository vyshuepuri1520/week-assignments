import java.util.*;

public class question9 {

    public static int maxuniq(int[] nums, int m) {
        int maxUnique = 0;
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : nums) {
            deque.add(num);
            set.add(num);

            if (deque.size() > m) {
                int removed = deque.remove();
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }

            maxUnique = Math.max(maxUnique, set.size());
        }

        return maxUnique;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int result = maxuniq(nums, m);
        System.out.println(result);

        in.close();
    }
}