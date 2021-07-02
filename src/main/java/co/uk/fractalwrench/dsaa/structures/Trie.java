package co.uk.fractalwrench.dsaa.structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * A Trie is a search tree where nodes can be searched depth-first using a given key.
 * These keys are usually characters of a string - all child nodes of a given node will
 * share the same keys. For example, 'car' and 'cat' both share 'ca'.
 * <p>
 * It is important to note that not every node is a valid word. For instance, 'c' is a node
 * but not a word.
 * <p>
 * This implementation is for education purposes only and is not production ready - there is
 * no attempt to deal with concurrent modifications for example.
 * <p>
 */
public class Trie {

    private final Node root = new Node();

    /**
     * Adds a new word to the Trie. This has no effect if the word was already added.
     *
     * @param word the new word.
     */
    public void addWord(String word) {
        Intrinsics.requireNotEmpty(word);
        Node currentNode = root;

        // 1. iterate through chars in string, creating node if not present
        for (char curr : word.toCharArray()) {
            Node childNode = currentNode.children.get(curr);

            if (childNode == null) { // create a new node if needed
                childNode = new Node();
                currentNode.children.put(curr, childNode);
            }
            currentNode = childNode;
        }
        // 2. mark the last node as containing a word
        currentNode.isWord = true;
    }

    /**
     * Deletes a word from the Trie. This has no effect if the word was not present.
     *
     * @param word the new word.
     */
    public void removeWord(String word) {
        Intrinsics.requireNotEmpty(word);
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // 1. check if is a word, adding to the stack as we go
        char[] chars = word.toCharArray();
        for (char curr : chars) {
            Node childNode = stack.peek().children.get(curr);

            if (childNode == null) {
                return;
            } else {
                stack.push(childNode);
            }
        }

        if (!stack.peek().isWord) {
            return;
        }

        stack.peek().isWord = false;

        // 2. remove the word node and any parent nodes with zero children
        for (int k = chars.length - 1; k >= 0; k--) {
            char curr = chars[k];
            Node node = stack.pop();

            if (node.children.isEmpty()) {
                Node parent = stack.peek();
                parent.children.remove(curr);
            }
        }
    }

    /**
     * Finds any words in the Trie that start with the given prefix. If no words
     * match the prefix an empty Collection will be returned.
     *
     * @param prefix the given prefix
     */
    public Collection<String> findWordsWithPrefix(String prefix) {
        // 1. find the node from which to start
        Intrinsics.requireNotEmpty(prefix);
        Node currentNode = findNode(prefix);

        if (currentNode == null) { // the prefix is not in the trie, return immediately
            return Collections.emptyList();
        }

        // 2. search the remaining branches via DFS and return any which are words
        return findWordsWithNode(currentNode, prefix);
    }

    private Collection<String> findWordsWithNode(Node node, String prefix) {
        Collection<String> words = new ArrayList<>();

        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            Node childNode = entry.getValue();
            char key = entry.getKey();

            if (childNode.isWord) {
                words.add(prefix + key);
            }
            words.addAll(findWordsWithNode(childNode, prefix + key));
        }
        return words;
    }

    /**
     * @return true if the Trie contains the given word.
     */
    public boolean containsWord(String word) {
        Intrinsics.requireNotEmpty(word);
        Node node = findNode(word);
        return node != null && node.isWord;
    }

    private Node findNode(String prefix) {
        Node currentNode = root;

        // 1. iterate through chars in string to find the node that contains the word,
        // returning false if does not exist.
        for (char curr : prefix.toCharArray()) {
            currentNode = currentNode.children.get(curr);
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    /**
     * @return true if the Trie contains no words.
     */
    public boolean isEmpty() {
        return root.children.isEmpty();
    }

    private static class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private boolean isWord; // not all nodes are words
    }

}
