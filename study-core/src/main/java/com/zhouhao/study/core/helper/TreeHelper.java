package com.zhouhao.study.core.helper;

import com.zhouhao.study.core.model.Tree;

public class TreeHelper {

    /**
     * 构建一个二叉查找树
     * @param params
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Tree<T> generateTree(T[] params) {
        Tree<T> tree = new Tree<T>();
        for (T param : params) {
            tree.add(param);
        }
        return tree;
    }

}
