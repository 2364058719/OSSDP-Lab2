import java.util.*;

/*
 * @Description
 * 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 */
import java.util.*;

class Solution16 {
    public String largestNumber(int[] nums) {
        int n = nums.length; // 这里不需要括号
        // 转换成包装类型，以便传入 Comparator 对象
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i]; // 使用 [] 而不是 ()
        }

        Arrays.sort(numsArr, (x, y) -> {
            // 比较 x 和 y 的组合方式
            String sx = String.valueOf(x) + String.valueOf(y);
            String sy = String.valueOf(y) + String.valueOf(x);
            return sy.compareTo(sx); // 反向比较，确保大的在前
        });

        // 如果最大的数字是 0，返回 "0"
        if (numsArr[0] == 0) { // 使用 == 而不是 ===
            return "0";
        }

        StringBuilder ret = new StringBuilder(); // 使用 = 而不是 ===
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString(); // 使用 () 调用 toString 方法
    }
}
