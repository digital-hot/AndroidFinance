package com.example.core.abstracts;

import com.example.core.interfaces.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractTreeNode implements TreeNode {

    private long id;
    private List<TreeNode> childs = new ArrayList<>();
    private TreeNode parent;
    private String name;

    public AbstractTreeNode() {

    }

    public AbstractTreeNode(String mame) {
        this.name = mame;
    }

    public AbstractTreeNode(long id, String mame) {
        this.id = id;
        this.name = mame;
    }

    public AbstractTreeNode(List<TreeNode> childs) {
        this.childs = childs;
    }

    public AbstractTreeNode(long id, List<TreeNode> childs, TreeNode parent, String name) {
        this.id = id;
        this.childs = childs;
        this.parent = parent;
        this.name = name;
    }

    @Override
    public void aad(TreeNode child) {
        child.setParent(this);
        childs.add(child);

    }

    @Override
    public void remove(TreeNode child) {
        childs.remove(child);
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<TreeNode> getChilds() {
        return childs;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public TreeNode getChild(long id) {
        for (TreeNode child: childs) {
            if (child.getId() == id ) {
                return child;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTreeNode that = (AbstractTreeNode) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
