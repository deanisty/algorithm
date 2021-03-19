package com.deepdoo.misc;

/**
 * 一张纸从下往上对折N次
 * 从上往下依次打印折痕的方向
 *
 * @author caoyunzhou
 */
public class FoldPaper {

    static int n;

    public static void main(String[] args) {
        n = 3;
        travel(0, "下");
    }


    public static void travel(int s, String str) {
        if(s >= ((1 << n) - 1)) {
            return;
        }
        travel((s << 1) + 1, "下");
        System.out.println(str);
        travel((s << 1) + 2, "上");
    }
}
