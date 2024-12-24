import java.util.List;

class treeNode {
    String city;
    String temperature;
    treeNode left, right;

    public treeNode(String city, String temperature) {
        this.city = city;
        this.temperature = temperature;
        left = right = null;
    }
}

class BinaryTree {
    private treeNode root;

    // Add data to the tree
    public void add(String city, String temperature) {
        root = addRecursive(root, city, temperature);
    }

    private treeNode addRecursive(treeNode node, String city, String temperature) {
        if (node == null) return new treeNode(city, temperature);

        if (city.compareTo(node.city) < 0) {
            node.left = addRecursive(node.left, city, temperature);
        } else if (city.compareTo(node.city) > 0) {
            node.right = addRecursive(node.right, city, temperature);
        }
        return node;
    }

    // Print all data in the tree (inorder traversal)
    public void printAll() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(treeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.city + ": " + node.temperature);
            printInOrder(node.right);
        }
    }
}
public static void insertionSort(List<treeNode> nodes) {
    for (int i = 1; i < nodes.size(); i++) {
        treeNode key = nodes.get(i);
        int j = i - 1;

        // Compare temperatures (convert String to Integer for comparison)
        while (j >= 0 && Integer.parseInt(nodes.get(j).temperature) > Integer.parseInt(key.temperature)) {
            nodes.set(j + 1, nodes.get(j));
            j--;
        }
        nodes.set(j + 1, key);
    }
}

public void main() {
}

