import java.util.Arrays;

/**
 * @description:
 *
 * 给定一个无序的数组 nums，返回数组在排序之后，相邻元素之间最大的差值。如果数组元素个数小于 2，则返回 0。
 *
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 *
 * 示例 1:
 *
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 * 提示:
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 *
 */
class Solution4 {
    public int maximumGap(int[] nums) {
        int n = nums.length; // 修改为 nums.length
        if (n < 2) {
            return 0;
        }

        int maxVal = Arrays.stream(nums).max().getAsInt();
        int minVal = Arrays.stream(nums).min().getAsInt();

        if (maxVal == minVal) {
            return 0; // 所有元素相等
        }

        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1)); // 桶的大小
        int bucketCount = (maxVal - minVal) / bucketSize + 1; // 桶的数量
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // 将元素放入桶中
        for (int num : nums) {
            int bucketIndex = (num - minVal) / bucketSize;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
        }

        // 计算最大差值
        int maxGap = 0;
        int previousMax = bucketMax[0];

        for (int i = 1; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue; // 空桶跳过
            }
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return maxGap;
    }
}
