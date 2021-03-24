package com.deepdoo;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author caoyunzhou
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
interface NestedInteger {
     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}

/**
 * @author caoyunzhou
 */
public class NestedIntegerIterator implements Iterator<Integer> {

    Integer pos = 0;
    List<Integer> innerList = new ArrayList<>();

    public NestedIntegerIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            flatList(nestedInteger);
        }
    }

    private void flatList(NestedInteger nest) {
        if(nest.isInteger()) {
            innerList.add(nest.getInteger());
        }else {
            for (NestedInteger nestedInteger : nest.getList()) {
                flatList(nestedInteger);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return pos < innerList.size();
    }

    @Override
    public Integer next() {
        return innerList.get(pos++);
    }
}
