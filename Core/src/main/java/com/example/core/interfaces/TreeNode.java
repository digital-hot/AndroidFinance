package com.example.core.interfaces;

import java.util.List;

//Створює дерево з набору обєктів
public interface TreeNode {

    String getName();

    long getId(); //Кожен элемент дерева повинен мати унікальний номер

    void aad(TreeNode child); //Додати дочірній елемент

    void remove(TreeNode child); //Видалити дочірній елемент

    List<TreeNode> getChilds(); //Список єлементів дерева

    TreeNode getChild(long id); //отримати дочірнього елемента

    TreeNode getParent(); //Отримати власника

    void setParent(TreeNode parent); //Встановити власника

}
