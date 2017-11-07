package org.david.algorithm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.david.algorithm.recursive.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Unit test for simple App.
 */
public class TreeNodeTest
        extends TestCase {
    Logger logger = Logger.getLogger(TreeNodeTest.class.getName());
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TreeNodeTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TreeNodeTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        Long nodeId;
        String nodeName;
        BigDecimal directValue;
        Map<Long, TreeNode> children;
        TreeNode root = new TreeNode(0L, "0", BigDecimal.valueOf(0), getChildren(0L));
        Map <Long,BigDecimal> result = root.scanTree(root);
        for (Map.Entry<Long,BigDecimal> entry:result.entrySet()){
            BigDecimal decimal = entry.getValue();
            logger.info("id:"+entry.getKey()+" summary value:"+decimal.toString());
        }
        if (result==null){
            assertTrue(false);
        }else{
            assertTrue(BigDecimal.valueOf(21).equals(result.get(21L)));
            assertTrue(BigDecimal.valueOf(22).equals(result.get(22L)));
            assertTrue(BigDecimal.valueOf(23).equals(result.get(23L)));
            assertTrue(BigDecimal.valueOf(11).equals(result.get(11L)));
            assertTrue(BigDecimal.valueOf(12).equals(result.get(12L)));
            assertTrue(BigDecimal.valueOf(24).equals(result.get(1L)));
            assertTrue(BigDecimal.valueOf(68).equals(result.get(2L)));
        }
    }

    public Map<Long, TreeNode> getChildren(Long parentId) {
        Map<Long, TreeNode> children = new HashMap<Long, TreeNode>();
        if (parentId == 0) {
            children.put(1L, new TreeNode(1L, "1", BigDecimal.valueOf(1), getChildren(1l)));
            children.put(2L, new TreeNode(2L, "2", BigDecimal.valueOf(2), getChildren(2l)));
        } else if (parentId == 1) {
            children.put(11L, new TreeNode(11L, "11", BigDecimal.valueOf(11), getChildren(11l)));
            children.put(12L, new TreeNode(12L, "12", BigDecimal.valueOf(12), getChildren(12l)));
        } else if (parentId == 2) {
            children.put(21L, new TreeNode(21L, "21", BigDecimal.valueOf(21), getChildren(21l)));
            children.put(22L, new TreeNode(22L, "22", BigDecimal.valueOf(22), getChildren(22l)));
            children.put(23L, new TreeNode(23L, "23", BigDecimal.valueOf(23), getChildren(23l)));
        }
        return children;
    }


}
