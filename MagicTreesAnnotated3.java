import java.util.Scanner;
import java.lang.Math;

// Errors throughout:
// Checking: No error handling is done 
// Non-Functional Error: No white space

public class MagicTreesAnnotated2 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        int Ret = 0;
        String trees[][] = new String[n][];
        for (int i = 0; i < n; i++) {
            double a = Sc.nextInt(); // Assignment Error/ Data error. Should be an int
            Ret += Math.pow(a, 2); // External Interface (incorrect calling sequence for power. Should be 2, a)
            trees[i] = createTree(a); // Internal interface (incorrect type for createTree method)
        }
        System.out.println(Ret);
        for (int i = 0; i < trees.length; i++) {
            printTree(trees[i]);
            // Algorithm Error, there should be a blank line printed here
        }
    }
    // Creates a tree // Non-Functional error, unclear method description
    public static String[] createTree(int a) {
        String[] tree = new String[(int)Math.pow(2, a) + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = "";
        }
        int num = (int)Math.pow(2, a) - 1;
        for (int i = 0; i < num; i++) {
            tree[tree.length - 1] += '-'; // Algorithm error: every instance of a dash being added should be a space
        }
        tree[tree.length - 1] += '|';
        for (int i = 0; i < num; i++) {tree[tree.length - 1] += '-';} // one line for loop :(
        for (int i = 0; i < (int)Math.pow(2, a); i++) {
            tree[0] += '0'; // Algorithm Error: uses '0' instead of 'O'. May also use 'o'.
            tree[0] += '-'; // Algorithm Error: Adds an extra dash after the last character
        }
        return recursiveTree(a, tree);
    }
    // Recursively adds branches to the tree.
    public static String[] recursiveTree(int a, String[] tree) {
        if (a == 0) // curly brackets
            return tree;
        else {
            int num = (int)Math.pow(2, a) - 1; // Non-Functional/ Timing: two to the A should be saved in a variable
            for (int i = 0; i < num; i++) {
                tree[(int)Math.pow(2, a)-1] += '-'; // Timing: this value could have been calculated once and stored in a variable
            }
            tree[(int)Math.pow(2, a)-1] += 'Y';
            for (int i = 0; i < num; i++) {
                tree[(int)Math.pow(2, a)-1] += '-';
            }
            num--;
            int c = (int)Math.pow(2, a-1) - 1;
            int L = (int)Math.pow(2, a)-2;
            int x = 1;
            while (num > c && num > 0) {
                for (int i = 0; i < num; i++) {
                    tree[L] += '-';
                }
                tree[L] += '\\';
                for (int i = 0; i < x; i++) {
                    tree[L] += '-';
                }
                tree[L] += '/';
                for (int i = 0; i < num; i++) {
                    tree[L] += '-';
                }
                L--;
                num--;
                x += 2;
            }
            recursiveTree(a-1, tree);
            for (int i = L; i > 0; i--) {
                tree[i] += '-';
            }
            recursiveTree(a-1, tree);
            return tree;
        }
    }
    // Iterates through each line of the tree in a for loop and prints it using System.out.println.
    // Returns nothing.
        // these comments are far too descriptive
    public static void printTree(String[] tree) {
        for (int i = 0; i <= tree.length; i++) { 
            System.out.println(tree[i]); // Data error: Iterates past the bounds of the tree data structure
        }
    }
}
