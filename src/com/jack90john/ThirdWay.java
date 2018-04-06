package com.jack90john;

import java.util.LinkedList;

/**
 * Description:
 * Designer: jack
 * Date: 2018/4/6
 * Version: 1.0.0
 */
public class ThirdWay {
    public static void main(String[] args) {
        Integer total = 10;
        Integer keyNumber = 3;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            list.addLast(i+1);
        }
        int index = 0;
        while (list.size() > 1) {
            for (int i = 1; i < keyNumber; i++) {
                if (index == list.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
            list.remove(index);
        }
        System.out.println(total + "个人围成一圈数数，数到" + keyNumber + "的被淘汰，最后剩下的是第" + list.get(0) + "个人。");
    }
}
