package com.zhouhao.study.core.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree<T extends Comparable> {

    private TreeNode<T> root;

    @SuppressWarnings("unchecked")
    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("value can not be null.");
        }

        if (root == null) {
            root = new TreeNode<>(value);
            return;
        }

        for (TreeNode<T> node = root; ; ) {
            if (value.compareTo(node.value) < 0) {
                if (node.left == null) {
                    node.left = new TreeNode<>(value);
                    return;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode<>(value);
                    return;
                } else {
                    node = node.right;
                }
            }
        }
    }

    @Override
    public String toString() {
        return orderTraverse();
    }

    // 中序遍历
    private String orderTraverse() {
        List<T> list = new ArrayList<>();
        Deque<TreeNode<T>> stack = new LinkedList<>();

        for (TreeNode<T> node = root; node != null; ) {
            // 将左子树依次入栈，直到左子树为空
            for (; node != null; node = node.left) {
                stack.push(node);
            }

            /**
             * 出栈并输出，有两种情况：
             * 1. 栈为空：遍历结束
             * 2. 右子树不为空：相当于使用当前的右子树节点作为root，遍历一棵树
             */
            for (; node == null && !stack.isEmpty(); node = node.right) {
                node = stack.pop();
                list.add(node.value);
            }
        }

        return list.toString();
    }

    // 中序遍历
    private void orderTraverse(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }

        orderTraverse(node.left, list);
        list.add(node.value);
        orderTraverse(node.right, list);
    }

    static class TreeNode<T> {

        public T value;

        public TreeNode<T> left;

        public TreeNode<T> right;

        public TreeNode() {
        }

        public TreeNode(T value) {
            this.value = value;
        }
    }
}
