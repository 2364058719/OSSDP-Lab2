import java.util.Arrays;

/**
 * @description:
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的和小于或等于 target 的非空子序列的数目。
 *
 * 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 示例 3：
 *
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= target <= 10^6
 *
 */
class Solution5 {
    static final int P = 1000000007;
    static final int MAX_N = 100005;

    int[] f = new int[MAX_N];

    public int numSubseq(int[] nums, int target) {
        pretreatment();
        Arrays.sort(nums);

        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n && nums[i] * 2 <= target; ++i) {
            int maxValue = target - nums[i];
            int pos = binarySearch(nums, maxValue) - 1;
            int contribute = (pos >= i) ? f[pos - i] : 0;
            ans = (ans + contribute) % P; // 修改为取模
        }

        return ans;
    }

    public void pretreatment() {
        f[0] = 1; // 修改为 1，因为 2^0 = 1
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] * 2) % P; // 修改乘法的实现
        }
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1; // 修改 high 的初始值
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1; // 修改 high 的更新方式
            }
        }
        return low;
    }
}
