/*
 * @Description:
 * 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */

class Solution13 {
    public void sortColors(int[] nums) {
        int n = nums.length; // 使用 length 属性
        int ptr = 0; // 初始化指针

        // 第一遍遍历，将所有0移动到前面
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) { // 使用 [] 来访问数组元素
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }

        // 第二遍遍历，将所有1移动到前面（在0之后）
        for (int i = ptr; i < n; ++i) { // 使用 () 进行循环条件
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}
