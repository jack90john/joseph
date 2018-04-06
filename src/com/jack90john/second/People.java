package com.jack90john.second;

/**
 * Description: 人
 * Designer: jack
 * Date: 2018/4/6
 * Version: 1.0.0
 */
public class People {
    private Integer id;
    //因为是一个圈子那么人就有左右两个属性，而且左右也都是人，所以明确定义其类型
    private People left;
    private People right;

    public People(Integer i) {
        this.id = i + 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getLeft() {
        return left;
    }

    public void setLeft(People left) {
        this.left = left;
    }

    public People getRight() {
        return right;
    }

    public void setRight(People right) {
        this.right = right;
    }
}
