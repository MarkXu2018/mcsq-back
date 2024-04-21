package com.mc.mcsq.utils;


import com.mc.mcsq.model.dto.UmsDeptDto;
import com.mc.mcsq.model.entity.UmsDept;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class DeptTreeUtils {
    /**
     * 将查询结果转换成树形结构。
     *
     * @param dataList 查询结果列表
     * @param rootId   根节点ID
     * @return List<UmsDeptDto> 树形结构数据列表
     */
    public static List<UmsDeptDto> convertToTree(List<UmsDept> dataList, Long rootId) {
        // 定义树形结构数据列表
        List<UmsDeptDto> treeList = new ArrayList<>();

        // 遍历查询结果列表，将每个节点添加到对应的父节点下面
        for (UmsDept data : dataList) {
            // 找到当前节点的父节点ID
            Long parentId = data.getParentId();

            // 如果当前节点是根节点或者其父节点ID等于根节点ID，则将其添加到树形结构数据列表中
            if (rootId.equals(parentId)) {
                UmsDeptDto node = new UmsDeptDto();
                BeanUtils.copyProperties(data, node);
                node.setChildren(new ArrayList<>());
                treeList.add(node);
            } else {
                // 在已有的树形结构数据列表中查找父节点
                UmsDeptDto parentNode = findNode(treeList, parentId);
                if (parentNode != null) {
                    // 创建子节点，并将其添加到父节点的子节点列表中
                    UmsDeptDto node = new UmsDeptDto();
                    BeanUtils.copyProperties(data, node);
                    node.setChildren(new ArrayList<>());
                    parentNode.getChildren().add(node);
                }
            }
        }

        return treeList;
    }

    /**
     * 在树形数据列表中查找指定节点。
     *
     * @param treeList 树形结构数据列表
     * @param nodeId   要查找的节点ID
     * @return UmsDeptDto 查找到的节点对象，如果未找到则返回null
     */
    private static UmsDeptDto findNode(List<UmsDeptDto> treeList, Long nodeId) {
        for (UmsDeptDto node : treeList) {
            if (node.getDeptId().equals(nodeId)) {
                return node;
            } else {
                UmsDeptDto foundNode = findNode(node.getChildren(), nodeId);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null;
    }
}
