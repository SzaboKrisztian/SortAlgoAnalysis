package dk.kea.stud.chris;

import java.util.List;

public class BSTSort extends SortingStrategy {
    BST bst;

    BSTSort() {
        super("BST Sort");
    }

    @Override
    long sort(List<Integer> data) {
        bst = new BST();
        bst.treeIns(data);
        data.clear();
        data.addAll(bst.getSorted());
        return bst.NoOps;
    }
}
