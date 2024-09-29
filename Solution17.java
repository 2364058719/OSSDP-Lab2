import java.util.*;

/*
 * @Description
 * 重复 DNA 序列
 * DNA 序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * 例如，"ACGAATTCCG" 是一个 DNA 序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 给定一个表示 DNA 序列 的字符串 s ，返回所有在DNA分子中出现不止一次的长度为10的序列(子字符串)。你可以按任意顺序返回答案。
 * 
 * 
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 */
class Solution17 {
    static final int L = 10;
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>(); // 初始化为 ArrayList
        int n = s.length(); // 这里要用括号
        if (n <= L) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < L; ++i) { // 使用 < L 而不是 < L - 1
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(x, 1); // 记录第一个子字符串
        for (int i = 1; i <= n - L; ++i) { // 从 1 开始
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }
}