package com.jack90john.second;

/**
 * Description:通过链表方式实现
 * Designer: jack
 * Date: 2018/4/6
 * Version: 1.0.0
 */
public class SecondWay {
    public static void main(String[] args) {
        int total = 10; //定义要添加的人数
        int keyNumber = 3; //数到3退出
        Circle circle = compute(total, keyNumber);
        System.out.println(total + "个人围成一圈数数，数到" + keyNumber + "的被淘汰，最后剩下的是第" + circle.getFirst().getId() + "个人。");
    }

    private static Circle compute(Integer total, Integer keyNumber){
        Circle circle = new Circle();
        for (int i = 0; i < total; i++) {
            People people = new People(i);
            circle.addPeople(people); //向环中添加人
        }

        Integer count = 0;//用来计数
        People people = circle.getFirst(); //先拿到第一个人
        while (circle.getTotal() > 1) {
            count++;
            if (count.equals(keyNumber)) {
                count = 0;
                circle.deletePeople(people);
            }
            people = people.getRight();//一个一个往后报数
        }
        return circle;
    }
}