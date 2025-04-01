
 // Step 1 - Create a BST tree object called lab5Tree
 class Node {
  int key;
  Node left, right;

  public Node(int item) {
      key = item;
      left = right = null;
  }
}

class lab5Tree {
  Node root;

  public lab5Tree() {
      root = null;
  }

  // Insertion operation
  void insert(int key) {
      root = insertRec(root, key);
  }

  Node insertRec(Node root, int key) {
      if (root == null) {
          root = new Node(key);
          return root;
      }

      if (key < root.key)
          root.left = insertRec(root.left, key);
      else if (key > root.key)
          root.right = insertRec(root.right, key);

      return root;
  }

  // Deletion operation
  void delete(int key) {
      root = deleteRec(root, key);
  }

  Node deleteRec(Node root, int key) {
      if (root == null)
          return root;

      if (key < root.key)
          root.left = deleteRec(root.left, key);
      else if (key > root.key)
          root.right = deleteRec(root.right, key);
      else {
          if (root.left == null)
              return root.right;
          else if (root.right == null)
              return root.left;

          root.key = minValue(root.right);

          root.right = deleteRec(root.right, root.key);
      }

      return root;
  }

  int minValue(Node root) {
      int minv = root.key;
      while (root.left != null) {
          minv = root.left.key;
          root = root.left;
      }
      return minv;
  }

  // Search operation
  boolean search(int key) {
      return searchRec(root, key);
  }

  boolean searchRec(Node root, int key) {
      if (root == null)
          return false;
      if (root.key == key)
          return true;
      if (root.key < key)
          return searchRec(root.right, key);
      return searchRec(root.left, key);
  }

  // Inorder traversal
  void inorder() {
      inorderRec(root);
      System.out.println("\n");
  }

  void inorderRec(Node root) {
      if (root != null) {
          inorderRec(root.left);
          System.out.print(root.key + " ");
          inorderRec(root.right);
      }
  }

  // Preorder traversal
  void preorder() {
      preorderRec(root);
      System.out.println("\n");
      
  }

  void preorderRec(Node root) {
      if (root != null) {
          System.out.print(root.key + " ");
          preorderRec(root.left);
          preorderRec(root.right);
      }
  }

  // Postorder traversal
  void postorder() {
      postorderRec(root);
      System.out.println("\n");
  }

  void postorderRec(Node root) {
      if (root != null) {
          postorderRec(root.left);
          postorderRec(root.right);
          System.out.print(root.key + " ");
      }
  }

  // Path from root to key

  void path(int key) {
    System.out.println("Path to " + key);
    pathRec(root, key);
    System.out.println();
  }
  void pathRec(Node root, int key) {
    if (root == null) {
      System.out.println("Key not found");
      return;
    }
    System.out.println(root.key + " ");
    if (key < root.key) {
      pathRec(root.left, key);
    } else if (key > root.key) {
      pathRec(root.right, key);
    }
  }
}

class Main {
  public static void main(String[] args) {
    // Driver Class
    lab5Tree tree = new lab5Tree();
  
   // Step 2 - Insert the following values: 13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10
    tree.insert(13);
    tree.insert(22);
    tree.insert(36);
    tree.insert(5);
    tree.insert(48);
    tree.insert(17);
    tree.insert(39);
    tree.insert(2);
    tree.insert(26);
    tree.insert(40);
    tree.insert(29);
    tree.insert(34);
    tree.insert(10);

    // Step 3 - Delete the value 17
    tree.delete(17);

    // Step 4 - Traverse and output the values using inorder (sorted)
    System.out.print("Inorder Traversal:");
    tree.inorder();

    // Step 5 - Traverse and output the values using postorder
    System.out.print("Postorder Traversal:");
    tree.postorder();

    // Step 6 - Traverse and output the values using preorder
    System.out.print("Preorder Traversal:");
    tree.preorder();

    // Step 7 - Display the result of a search for the value 36
    System.out.println("Search(36): " + tree.search(36));

    // Step 8 - Display the result of a search for the value 37
    System.out.println("Search(37): " + tree.search(37));

    // Step 9 - Using the path() method, display the path from the root to 2
    tree.path(2);

    // Step 10 - Display the path from the root to 34
    tree.path(34);

  }  
}
