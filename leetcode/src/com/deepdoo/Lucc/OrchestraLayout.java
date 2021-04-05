package com.deepdoo.Lucc;

/**
 * 2. 乐团站位
 * 通过的用户数660
 * 尝试过的用户数2260
 * 用户总通过次数670
 * 用户总提交次数6710
 * 题目难度Easy
 * 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
 *
 * 为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
 *
 * image.png
 *
 * 请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
 *
 * 示例 1：
 *
 * 输入：num = 3, Xpos = 0, Ypos = 2
 *
 * 输出：3
 *
 * 解释：
 * image.png
 *
 * 示例 2：
 *
 * 输入：num = 4, Xpos = 1, Ypos = 2
 *
 * 输出：5
 *
 * 解释：
 * image.png
 *
 * 提示：
 *
 * 1 <= num <= 10^9
 * 0 <= Xpos, Ypos < num
 */
public class OrchestraLayout {
    // 填充的数
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int index = 0;

    // 每个位置的值
    int[][] map;

    int total;
    int i = 0;
    // 方向
    String[] directs = new String[]{"right", "down", "left", "up"};
    int direct = 0;

    public int solution(int num, int xPos, int yPos) {

        map = new int[num][num];
        total = num * num;

        int row = 0, column = 0;

        while (i++ < total) {

            map[row][column] = numbers[index];
            index = (++index) % 9;

            if(row == xPos && column == yPos) {
                return map[row][column];
            }

            if("up".equals(directs[direct])) {
                row--;
            }else if("down".equals(directs[direct])) {
                row++;
            }else if("left".equals(directs[direct])) {
                column--;
            } else if("right".equals(directs[direct])) {
                column++;
            }

            if(row <= 0 || row >= num - 1 || column <= 0 || column >= num - 1 || map[row][column] > 0) {
                direct = (++direct) % 3;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        int num = 3;
        int xPos = 2;
        int yPos = 2;

        OrchestraLayout ol = new OrchestraLayout();

        System.out.println(ol.solution(num, xPos, yPos));
    }
}
