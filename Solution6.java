import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 *
 * 给你一个数组 favoriteCompanies，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 *
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 *
 * 示例 1：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 *
 * 提示：
 *
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 *
 */
class Solution6 {
    Set<String>[] s = new Set[105];

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size(); // 修正为 n = favoriteCompanies.size()
        List<Integer> ans = new ArrayList<>();

        // 初始化集合
        for (int i = 0; i < n; ++i) {
            s[i] = new HashSet<>(favoriteCompanies.get(i)); // 直接初始化集合
        }

        for (int i = 0; i < n; ++i) {
            boolean isSub = false;
            for (int j = 0; j < n; ++j) {
                if (i != j && check(s[i], s[j])) {
                    isSub = true; // 如果 i 是 j 的子集
                    break;
                }
            }
            if (!isSub) {
                ans.add(i); // 只在不是子集的情况下添加
            }
        }

        return ans;
    }

    public boolean check(Set<String> x, Set<String> y) {
        return y.containsAll(x); // 检查 x 是否是 y 的子集
    }
}
