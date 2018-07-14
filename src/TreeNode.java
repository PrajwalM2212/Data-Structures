import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class TreeNode<T> {


    private TreeNode<T> parent;
    private List<TreeNode<T>> children;
    private T data;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {

        this.children.add(child);
        child.parent = this;

    }

    public void printTree(TreeNode<T> root) {

        out.print(root.data.toString());
        out.print("(");
        int size = root.children.size();
        while (size > 0) {
            printTree(root.children.get(size - 1));
            size--;
        }
        out.print(")");
    }

    public static void main(String[] args) {

        TreeNode<String> root = new TreeNode<>("root");
        TreeNode<String> child1 = new TreeNode<>("child1");
        TreeNode<String> child2 = new TreeNode<>("child2");
        root.addChild(child1);
        root.addChild(child2);
        TreeNode<String> child12 = new TreeNode<>("child12");
        child1.addChild(child12);
        root.printTree(root);

    }

}
