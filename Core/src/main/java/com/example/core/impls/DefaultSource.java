package com.example.core.impls;

import com.example.core.Objects.OperationType;
import com.example.core.abstracts.AbstractTreeNode;
import com.example.core.interfaces.Source;
import com.example.core.interfaces.TreeNode;

import java.util.List;

public class DefaultSource extends AbstractTreeNode implements Source {

    private OperationType operationType;

    public DefaultSource() {
    }

    public DefaultSource(String mame, OperationType operationType) {
        super(mame);
    }

    public DefaultSource(long id, String mame, OperationType operationType) {
        super(id, mame);
    }

    public DefaultSource(List<TreeNode> childs, OperationType operationType) {
        super(childs);
    }

    public DefaultSource(long id, List<TreeNode> childs, TreeNode parent, String name, OperationType operationType) {
        super(id, childs, parent, name);
    }


    @Override
    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public void aad(TreeNode child) {
        // TODO використати паттерн
        //Заповнюємо тип у підпорядкованих елементах
        if (child instanceof DefaultStorage){
            ((DefaultStorage)child).setOperationType(operationType);
        }
        super.aad(child);
    }
}
