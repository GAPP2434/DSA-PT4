import java.util.*;

class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

public class BinaryTree {
    private Node root;

    public void insert(int data) {
        Node tempNode = new Node(data);
        Node current;
        Node parent;

        if (root == null) {
            root = tempNode;
        } else {
            current = root;
            parent = null;

            while (true) {
                parent = current;

                if (data < parent.data) {
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = tempNode;
                        return;
                    }
                } else {
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = tempNode;
                        return;
                    }
                }
            }
        }
    }

    public Node search(int data) {
        Node current = root;
        System.out.print("Visiting elements: ");

        while (current.data != data) {
            if (current != null) {
                System.out.print(current.data + " ");
            }

            if (current.data > data) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.leftChild);
            System.out.print(root.data + " ");
            inOrderTraversal(root.rightChild);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.leftChild);
            postOrderTraversal(root.rightChild);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        int[] array = {27, 14, 35, 10, 19, 31, 42};
        for (int i = 0; i < array.length; i++) {
            binaryTree.insert(array[i]);
        }

        System.out.println("Enter traversal method:\n1. Preorder\n2. Inorder\n3. Postorder");
        System.out.print("Answer: ");
        int choice = scanner.nextInt();

        if (choice == 1){
                System.out.println("Preorder traversal: ");
                binaryTree.preOrderTraversal(binaryTree.root);
        }
            else if (choice == 2){
                System.out.println("Inorder traversal: ");
                binaryTree.inOrderTraversal(binaryTree.root);
            }
               else if (choice == 3){
                System.out.println("Postorder traversal: ");
                binaryTree.postOrderTraversal(binaryTree.root);
               }
               else{
                System.out.println("Invalid choice");
               }
        }

    }
