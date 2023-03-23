import java.util.*;

public class Merge2BSTs {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");

        preorder(root.left);
        preorder(root.right);

    }
    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static Node createBST(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, start, mid - 1);
        root.right = createBST(list, mid + 1, end);
        return root;

    }
    

    public static Node mergeBSTs(Node root1, Node root2) {
        // step1
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        inOrder(root1, list1);

       // step2
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        inOrder(root2, list2);

        // merge two ALs
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                list.add(list1.get(i));
                i++;
            } else {
                list.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }

        return createBST(list, 0, list.size() - 1);
    }

    public static void main(String args[]) {
        Node root1 = new Node(2);// bst1
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);// bst2
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        System.out.println(root.data);
        preorder(root);

    }
}
