package algorithms.stack;

/**
 * @author twt
 * @description 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *  
 * <p>
 * 提示：
 * <p>
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/21
 */
public class RemoveOuterParentheses {

    /**
     * 使用栈实现
     * 遇见'('时push，遇见')'时pop，当栈为空时则为一个有效字符串
     *
     * @param S
     * @return
     */
    /*public String removeOuterParentheses(String S) {

        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') stack.push(c);
            if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    ans.append((S.substring(start + 1, i)));
                    start = i + 1;
                }
            }
        }
        return ans.toString();
    }*/

    /**
     * 不适用栈，使用变量代替。因为栈为空类似变量又回到原始状态。
     *
     * @param S
     * @return
     */
    /*public String removeOuterParentheses(String S) {
        int start = 0;
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if ('(' == c) level++;
            if (')' == c) level--;
            if (level == 0) {
                sb.append((S.substring(start + 1, i)));
                start = i + 1;
            }
        }

        return sb.toString();
    }*/

    /**
     * 大佬使用的更简洁的方法
     * 1.由于字符串肯定以(开始，所以第一个(必然需要过滤，所以大佬先if (')' == c) level--;
     * 2.由于才开始过滤了(，所以第一个有效字符串结束后level为-1，第二个有效字符以(开始，也需要过滤，所以大佬才会在level >= 1时append
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (')' == c) level--;
            if (level >= 1) sb.append(c);
            if ('(' == c) level++;
        }

        return sb.toString();
    }
}
