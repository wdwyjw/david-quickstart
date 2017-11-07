package org.david.algorithm.recursive;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
    private Long nodeId;
    private String nodeName;
    private BigDecimal directValue;
    private BigDecimal summaryValue;
    private Map<Long,TreeNode> children;

    public TreeNode(Long nodeId, String nodeName, BigDecimal directValue, Map<Long,TreeNode> children) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.directValue = directValue;
        this.children = children;
    }

    public void setSummaryValue(BigDecimal summaryValue) {
        this.summaryValue = summaryValue;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public BigDecimal getDirectValue() {
        return directValue;
    }

    public BigDecimal getSummaryValue() {
        return summaryValue;
    }

    public Map<Long,TreeNode> getChildren() {
        return children;
    }

    public void addSummary(BigDecimal addedValue){
        if (this.summaryValue==null){
            this.summaryValue=this.directValue;
        }
        if (this.summaryValue!=null){
            this.summaryValue= this.summaryValue.add(addedValue);
        }
    }

    public  Map <Long,BigDecimal> scanTree(TreeNode node){
        Map <Long,BigDecimal> mapResult=new HashMap<Long, BigDecimal>();
        getSummaryValueOfNode(node,mapResult);
        return mapResult;
    }

    public  BigDecimal getSummaryValueOfNode(TreeNode node,Map <Long,BigDecimal> mapResult){
        if (node==null || node.getChildren()==null || node.getChildren().size()==0){
            node.setSummaryValue(node.getDirectValue());
            mapResult.put(node.getNodeId(),node.getSummaryValue());
            return node.getSummaryValue();
        }
        for (Map.Entry<Long,TreeNode> entry:node.getChildren().entrySet()){
            Long deptId=entry.getKey();
            TreeNode child = entry.getValue();
            BigDecimal decimal= getSummaryValueOfNode(child,mapResult);
            node.addSummary(decimal);
        }
        mapResult.put(node.getNodeId(),node.getSummaryValue());
        return node.getSummaryValue();
    }

}