
public class SearchKEY_inBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);

        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean SearchKEY(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data== key){
            return true;
        }
       
       
        if(root.data>key){
            return   SearchKEY(root.left,key);
        }
        else{
            return    SearchKEY(root.right, key);
        }
       
    }

    public static void main(String args[]) {

        int values[] = { 45, 2, 1, 96, 8, 36 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        System.out.println(SearchKEY(root,36));

    }
}
