package com.jack90john.second;

/**
 * Description: 环
 * Designer: jack
 * Date: 2018/4/6
 * Version: 1.0.0
 */
public class Circle {
    private int total = 0;
    private People first = null;
    private People last = null;

    /**
     * 向环里添加人，将新人添加到链表的尾部
     *
     * @param newPeople 新加入都人
     */
    public void addPeople(People newPeople) {
        if (total <= 0) {
            //如果总数小于或等于零，说明这是环里一个人都没有，这是添加后第一个和最后一个都是自己
            first = newPeople;
            last = newPeople;
            //此时这个人都的左边和右边也都是自己
            newPeople.setLeft(newPeople);
            newPeople.setRight(newPeople);
        } else {
            //如果环里有人，则将新人加入到尾部，因为是尾部，所以操作的就是first和last
            last.setRight(newPeople);//将原先最后一个人的右边变为新人
            newPeople.setLeft(last);//将新人的左边设为原最后一个人也就是现在的倒数第二人
            newPeople.setRight(first);//将行人的右边设为第一个人
            first.setLeft(newPeople);//将第一人的左边变为新人
            last = newPeople;//将最有一个人设为新人
        }
        total++;
    }

    /**
     * 删除被淘汰的人
     *
     * @param deletePeople 需要删除的人
     */
    public void deletePeople(People deletePeople) {
        if (total <= 0) {
            return;
        } else if (total == 1) {
            //如果环中只有一个人，那么游戏结束，首尾都设为null
            first = null;
            last = null;
        } else {
            //环中的人大于一个，是开始删除操作
            if (deletePeople == first) {
                first = deletePeople.getRight(); //如果是第一个人，那么他右边都人就变成第一人
            } else if (deletePeople == last) {
                last = deletePeople.getLeft();   //相反，如果是最后一个人，那么他左边边都人就变成最后一人
            }

            //将删除的人左边的人的右边设为删除的人的右边的人，是不是有点儿绕，举个例子：
            //234，我们要删除3，那么将2的左边设为4。
            deletePeople.getLeft().setRight(deletePeople.getRight());
            //同理，将删除的人右边的人的左边设为删除人的左边的人。
            deletePeople.getRight().setLeft(deletePeople.getLeft());
        }
        total--;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public People getFirst() {
        return first;
    }

    public void setFirst(People first) {
        this.first = first;
    }

    public People getLast() {
        return last;
    }

    public void setLast(People last) {
        this.last = last;
    }
}