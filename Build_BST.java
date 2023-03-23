public class Build_BST{
static class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
    public static Node insertIN_BST(Node root,int val){

        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){  // left subtree
            root.left = insertIN_BST(root.left, val);

        }
        else{ // right subtree
            root.right = insertIN_BST(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String args[]){
int values [] = {5,1,3,4,2,7};
Node root = null;

for(int i=0;i<values.length;i++){
    root = insertIN_BST(root, values[i]);
}
inOrder(root);
    }
}