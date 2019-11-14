/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inverse.bst;

/**
 *
 * @author Vibhushit Singhal
 */
import java.util.*;
public class inverseBST {

    /**
     * @param args the command line arguments
     */
    class Node{
        int data;
        Node left, right;
        Node(int key){
            this.data = key;
            left = right = null;
        }
    }
    Node root;
    inverseBST(){
        root = null;
    }
    Node insert(Node root, int key){
        if(root == null)
            root = new Node(key);
        if(root.data > key)
            root.left = insert(root.left, key);
        else if(root.data < key)
            root.right = insert(root.right, key);
        return root;
    }
    
    void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    
    void preOrderTraversal(Node node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    
    void postOrderTraversal(Node node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    int height(Node node){
        if(node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight >= rightHeight){
            return leftHeight+1;
        }else{
            return rightHeight+1;
        }
    }
    
    void reverseLevelOrder(){
        int height = height(root);
        for(int i = height; i >= 1; i--){
            printGivenLevel(root, i);
            System.out.println();
        }
    }
    
    void printGivenLevel(Node root, int level){
        if(root == null)
            return;
        if(level == 1)
            System.out.print(root.data + " ");
        else if(level > 1){
            printGivenLevel(root.right, level-1);
            printGivenLevel(root.left, level-1);
        }
    }
    
    Node preOrderRead(Node root1, Node root2){
        if(root1 != null){
            root2 = inverseInsert(root2, root1.data);
            preOrderRead(root1.left, root2);
            preOrderRead(root1.right, root2);
        }
        return root2;
    }
    
    Node inverseInsert(Node root2, int key){
        if(root2 == null){
            root2 = new Node(key);
        }
        if(root2.data < key){
            root2.left = inverseInsert(root2.left, key);
        }else if(root2.data > key){
            root2.right = inverseInsert(root2.right, key);
        }
        return root2;
    }
    
    void traverseLevelOrder(){
        int height = height(root);
        for(int i = 1; i <= height; i++){
            printLevel(root, i);
            System.out.println();
        }
    }
    
    void printLevel(Node root, int level){
        if(root == null)
            return;
        if(level == 1)
            System.out.print(root.data + " ");
        else if(level > 1){
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        inverseBST bt = new inverseBST();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of nodes of BST");
        int n = s.nextInt();
        System.out.println("Enter the elements of BST");
        while(n-- > 0){
            bt.root = bt.insert(bt.root, s.nextInt());
        }
        System.out.println("Inorder traversal of given tree");
        bt.inOrderTraversal(bt.root);
        System.out.println("\nReverse Level order traversalof given tree");
        bt.reverseLevelOrder();
        bt.postOrderTraversal(bt.root);
        
        inverseBST bti = new inverseBST();
        bti.root = bti.preOrderRead(bt.root, bti.root);
        
        System.out.println("\nInorder traversal of inverse of tree");
        bti.inOrderTraversal(bti.root);
        System.out.println("\nPreorder traversal of inverse of tree");
        bti.preOrderTraversal(bti.root);
        System.out.println("\nPostorder traversal of inverse of tree");
        bti.postOrderTraversal(bti.root);
        System.out.println("\nLevel order traversal of inverse of tree");
        bti.traverseLevelOrder();
        System.out.println("\nReverse Level order traversal of inverse of tree");
        bti.reverseLevelOrder();
    }
}
