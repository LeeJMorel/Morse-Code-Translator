/*CS211 SPRING 2020, Created: 6/17/20, Lee Janzen 
This executes programming project 2, chapter 17.
It is an exercise on binary search trees.
It is designed as a morse code translator.
Class morse tree is based on search tree found in the materials for Building Java Programs*/

import java.io.*; //file reader
import java.util.*;
 
public class MorseTree implements MorseCodeInterface {
   private MorseTreeNode overallRoot; // root of overall tree

   // post: constructs a morse search tree
   public MorseTree() {
        overallRoot = new MorseTreeNode();//set the overall root to an empty node (first part of tree)
        readMorseDat();//populate tree
   }
    
   //post: reads the morse code file to our tree
   private void readMorseDat() {
        String data = "";
        String[] morseDat = {"e.", "t-", "a.-", "i..", "m--", "n-.", "d-..", "g--.", "k-.-", "o---", "r.-.", "s...", 
        "u..-", "w.--", "b-...", "c-.-.", "f..-.", "h....", "j.---", "l.-..", "p.--.", "q--.-", "v...-", "x-..-",
        "y-.--", "z--..", "5.....", "4....-", "3...--", "2..---", "1.----", "0-----", "6-....", "7--...", "8---..", 
        "9----.", "..-.-.-", ",--..--", "?..--..", "!..--.", ":---...", "'.----.", "=-...-", "/-..-.", };
        for (int i = 0; i < morseDat.length; i++){
              data = morseDat[i];
              if (data.length() > 0) {
                add(data.charAt(0), data.substring(1)); //add(letter, morse code following letter) Example: add(e, .)
             }
        }
   }
   
    
   // post: value added to tree so as to preserve binary search tree
   // private - we do not want this altered or accessed for any reason.
   // User can change the dat file if nessecary, not the code.
   private void add(char letterValue, String morseCodeValue) {
         MorseTreeNode root = overallRoot;
         for (int i = 0; i < morseCodeValue.length(); i++) {
            root = nextNode(root, morseCodeValue.charAt(i));
         }
         root.setData(letterValue);
   }
   
   //pre: provides a morse code dot or dash with it's associated letter value
   //post: sorts tree values by dot or dash
   private MorseTreeNode nextNode(MorseTreeNode root, char morse) {
         if (morse == '.') {
               if (root.left == null)
                  root.setLeft(new MorseTreeNode());
               return root.left;
         } else if (morse == '-' || morse == '_') {
               if (root.right == null)
                  root.setRight(new MorseTreeNode());
               return root.right;
         } else {
               throw new IllegalArgumentException("bad Morse character");
       }
    }
    
    //pre: a morse code string is provided for translation
    //post: gives english translation of morse code
    public String decode(String userInput) {
        char morse;
        StringBuffer result = new StringBuffer("");
        MorseTreeNode root = overallRoot;
         
        for (int i = 0; i < userInput.length(); i++) {
            morse = userInput.charAt(i);
            if (morse=='.') {
                   root = root.left;
            } else if (morse=='-') {
                    root = root.right;
            } else {
                result.append(root.data);
                root = overallRoot;
            }
        }
        result.append(root.data);
        return result.toString();
    }
    
    
    //pre: a morse code string is provided for translation
    //post: gives english translation of morse code
    public String encode(String userInput) {
        StringBuffer result = new StringBuffer("");
        String encoded = "";
        char ltr;
         
        for (int i = 0; i < userInput.length(); i++) {
            ltr = userInput.toLowerCase().charAt(i); //all our data is in lowercase
            result.append(searchTree(ltr, encoded));
        }
        return result.toString();
    }
    
    //pre: needs a character to search for, and a string that the letter is associated with in our tree
    //post: returns the morse code value off a particular root
    public String searchTree(char ltr, String encoded) {
        return searchTree(overallRoot, ltr, encoded);
    }
    
    //post: returns . or - based on the location in our tree
    private String searchTree(MorseTreeNode root, char ltr, String encoded) {
    String result = "";
       if (root.data == ltr) { 
            result = encoded; 
            return result;
       } else {
            if (root.left != null) {
                result = searchTree(root.left, ltr, encoded + ".");
                if (result != "") {
                     return result;
                }
            }
            if (root.right != null) {
                result = searchTree(root.right, ltr, encoded + "-");
                if (result != "") {
                     return result;
                }
            }    
       }
       return result; 
    }
    
    
    //inner node class
    private static class MorseTreeNode {
        private char data;            // data stored in this node
        private MorseTreeNode left;   // left subtree
        private MorseTreeNode right;  //  right subtree
        public static final char EMPTY = ' '; //our default char

        // post: constructs a leaf node with given data
        public MorseTreeNode() {
            this(EMPTY, null, null);
        }

        // post: constructs a node with the given data and links
        public MorseTreeNode(char data, MorseTreeNode left,
                              MorseTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
   
        //set methods added in order to sort the tree
        public void setData(char letter) { data = letter; }
        public void setLeft(MorseTreeNode l) { left = l; }
        public void setRight(MorseTreeNode r) { right = r; }

   }
    
   //methods below are tester methods, leftover from the original SearchTree class


    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(MorseTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }
    
    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(MorseTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
 
}
    
