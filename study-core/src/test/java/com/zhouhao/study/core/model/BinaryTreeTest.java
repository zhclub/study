package com.zhouhao.study.core.model;

import com.zhouhao.study.core.helper.TreeHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    public void testPrint() {
        Integer[] nums = {6, 3, 2, 4, 8, 7, 10, 9};
        BinaryTree<Integer> binaryTree = TreeHelper.generateTree(nums);

        assertEquals("[2, 3, 4, 6, 7, 8, 9, 10]", binaryTree.toString());
    }

}