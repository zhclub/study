package com.zhouhao.study.core.helper;

import com.zhouhao.study.core.model.BinaryTree;

public class TreeHelper {

    /**
     * 构建一个二叉查找树
     * @param params
     * @param <T>
     * @return
     */
    public static <T extends Comparable> BinaryTree<T> generateTree(T[] params) {
        BinaryTree<T> binaryTree = new BinaryTree<T>();
        for (T param : params) {
            binaryTree.add(param);
        }
        return binaryTree;
    }

}
