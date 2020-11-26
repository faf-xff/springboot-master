package com.example.demo.number;

import java.util.*;

/**
 * 路径：com.example.demo.number
 * 类名：DuplicateRemovalList
 * 功能：List对象去除重复值
 * 备注：
 * 创建人：typ
 * 创建时间：2019/4/15 20:56
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class DuplicateRemovalUtils {

    public static void main(String[] args) {
        List<List<Integer>> list = list();
        removeDuplicateWithOrder(list);
    }

    /**
     * 方法名：removeDuplicate
     * 功能：循环list中的所有元素然后删除重复
     * 描述：
     * 创建人：typ
     * 创建时间：2019/4/15 21:50
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static List removeDuplicate(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    /**
     * 方法名：removeDuplicate1
     * 功能：通过HashSet踢除重复元素
     * 描述：
     * 创建人：typ
     * 创建时间：2019/4/15 21:50
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static List removeDuplicate1(List list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }

    /**
     * 方法名：removeDuplicate2
     * 功能：把list里的对象遍历一遍，用list.contain()，如果不存在就放入到另外一个list集合中
     * 描述：
     * 创建人：typ
     * 创建时间：2019/4/15 21:52
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static List removeDuplicate2(List list) {
        List listTemp = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!listTemp.contains(list.get(i))) {
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }

    /**
     * 方法名：removeDuplicateWithOrder
     * 功能：删除ArrayList中重复元素，保持顺序
     * 描述：
     * 创建人：typ
     * 创建时间：2019/4/15 21:51
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static List removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        return list;
    }


    // 数据
    public static List<List<Integer>> list() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(1235);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(2);
        list2.add(455);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(3);
        list3.add(453);

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(0);
        l.add(0);
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        l1.add(1235);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(455);
        List<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(3);
        l3.add(453);

        List<Integer> ll = new ArrayList<>();
        ll.add(2);
        ll.add(0);
        ll.add(0);
        List<Integer> ll1 = new ArrayList<>();
        ll1.add(2);
        ll1.add(1);
        ll1.add(1235);
        List<Integer> ll2 = new ArrayList<>();
        ll2.add(2);
        ll2.add(2);
        ll2.add(455);
        List<Integer> ll3 = new ArrayList<>();
        ll3.add(2);
        ll3.add(3);
        ll3.add(453);

        List<Integer> lll = new ArrayList<>();
        lll.add(0);
        lll.add(0);
        lll.add(0);
        List<Integer> lll1 = new ArrayList<>();
        lll1.add(0);
        lll1.add(1);
        lll1.add(1235);
        List<Integer> lll2 = new ArrayList<>();
        lll2.add(0);
        lll2.add(2);
        lll2.add(455);
        List<Integer> lll3 = new ArrayList<>();
        lll3.add(0);
        lll3.add(3);
        lll3.add(453);

        List<List<Integer>> listList = new ArrayList<>();
        listList.add(list);
        listList.add(list1);
        listList.add(list2);
        listList.add(list3);

        listList.add(l);
        listList.add(l1);
        listList.add(l2);
        listList.add(l3);

        listList.add(ll);
        listList.add(ll1);
        listList.add(ll2);
        listList.add(ll3);

        listList.add(lll);
        listList.add(lll1);
        listList.add(lll2);
        listList.add(lll3);

        return listList;
    }

}
