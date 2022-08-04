import sun.lwawt.macosx.CPrinterDevice;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private static final int COUNT =10 ;
    Node root;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    public static void preOrder(Node root) {
        if(root==null)return ;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void postOrder(Node root) {
        if(root==null)return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()){
            Node n = q.remove();
            if (n.left != null){
                q.add(n.left);
            }

            if (n.right != null){
                q.add(n.right);
            }
            System.out.print(n.data+" ");
        }
    }
    public static Node insert(Node root,int data) {
        Node node=new Node(data);
        if(root==null)
            return node;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node tempNode=queue.poll();
            if(tempNode.data>node.data&&tempNode.left != null)
                queue.add(tempNode.left);
            else if(tempNode.data>node.data&&tempNode.left == null) {
                    tempNode.left = node;
                    break;
            }

            else {
                if (tempNode.right != null)
                    queue.add(tempNode.right);
                else {
                    tempNode.right = node;
                    break;
                }
            }
        }
        return root;

    }

    static boolean  checkBST(Node root) {
       return  isBST(root,null,null);
    }
    static boolean isBST(Node root, Node l, Node r)
    {
        // Base condition
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.data <= l.data)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.data >= r.data)
            return false;

        // check recursively for every node.
        return isBST(root.left, l, root) &&
                isBST(root.right, root, r);
    }
    public static int maxPathSum(Node root)
    {
        int maxSum=0;
        int sum=0;
        return childNode(root,0,0);

    }
    public static int childNode( Node root,int maxSum,int sum){
        if(root==null)return maxSum<sum?sum:maxSum;
        sum+=root.data;
        maxSum=childNode(root.left,maxSum,sum);
        maxSum=childNode(root.right,maxSum,sum);

        return maxSum;
    }
    static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }
    public static Node deleteNode(Node root,int k)
    {
        //add code here.
        if(root==null)
            return root;
        if(root.data<k)
            root.right=deleteNode(root.right,k);
        else if(root.data>=k)
            root=deleteNode(root.left,k);
        return root;
    }
    public static void main(String[] args) {
        Tree tree=new Tree();
        /************POST,PRE,IN ORDER INPUTS*************/
        /*tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        preOrder(tree.root);
        System.out.println();
        postOrder(tree.root);*/

        /************LEVEL AND TOP VIEW  INPUTS*************/
        /*tree.root=new Node(1);
        tree.root.right=new Node(2);
        tree.root.right.right=new Node(5);
        tree.root.right.right.left=new Node(3);
        tree.root.right.right.right=new Node(6);
        tree.root.right.right.left.right=new Node(4);
         levelOrder(tree.root);*/


        /************INSERTION  INPUTS*************/
        /*tree.root=new Node(4);
        tree.root.left=new Node(2);
        tree.root.right=new Node(7);
        tree.root.left.left=new Node(1);
        tree.root.left.right=new Node(3);
        preOrder(insert(tree.root,6));
        System.out.println(checkBST(tree.root));*/

       /* tree.root=new Node(8);
        tree.root.left=new Node(3);
        tree.root.left.left=new Node(1);
        tree.root.left.right=new Node(6);
        tree.root.left.right.left=new Node(4);
        tree.root.left.right.right=new Node(7);
        tree.root.right=new Node(10);
        tree.root.right.right=new Node(14);
        tree.root.right.right.left=new Node(9);
        System.out.println(checkBST(tree.root));*/


       /* tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        System.out.println(maxPathSum(tree.root));*/


        tree.root=new Node(8);
        tree.root.left=new Node(3);
        tree.root.right=new Node(10);
        tree.root.left.left=new Node(1);
        tree.root.left.right=new Node(6);
        tree.root.left.right.left=new Node(4);
        tree.root.left.right.right=new Node(7);
        tree.root.right.right=new Node(14);
        tree.root.right.right.left=new Node(13);
        Node node=deleteNode(tree.root,4);
        print2DUtil(node,0);
        //System.out.println(node.data);







    }
}
