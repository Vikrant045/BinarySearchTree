import java.util.*;
public class BST_to_BalancedBST {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node (int data){
            this.data = data;
            this.left= null;
            this.right = null;
        }
    }
    public static void inorder(Node root,ArrayList<Integer> list){
        if(root == null){
            return ;
        }
        inorder(root.left, list);
        list.add(root.data);
        System.out.print(root.data+" ");
        inorder(root.right, list);

    }
    public static void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");

        preorder(root.left);
        preorder(root.right);

    }
    public static Node createBST(ArrayList<Integer> list,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
      Node  root = new Node(list.get(mid));
      root.left = createBST(list, start, mid-1);
      root.right =createBST(list, mid+1, end);
      return root;
    }
    public static Node balancedBST(Node root){
    // step 1 to add sorted node in Al
        ArrayList<Integer> list= new ArrayList<Integer>();
inorder(root, list);

// step 2 create BST balanced
return createBST(list, 0, list.size()-1);

        
    }
    public static void main(String args[]){
Node root = new Node(8);
root.left = new Node(6);
root.left.left = new Node(5);
root.left.left.left = new Node(3);
root.right = new Node(10);
root.right.right = new Node(11);
root.right.right.right = new Node(12);

root =balancedBST(root);
preorder(root);

    }
    
}
