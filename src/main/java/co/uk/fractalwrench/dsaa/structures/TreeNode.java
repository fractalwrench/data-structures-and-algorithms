package co.uk.fractalwrench.dsaa.structures;

import java.util.Collection;

/**
 * A custom implementation of a Tree. The tree data structure consists of a root node which branches off into child
 * nodes, which itself can point to other nodes. A tree is simply a graph that does not have any cyclic relationships
 * between nodes.
 * <p></p>
 * This implementation is immutable after construction and is not complete or balanced. The class mainly exists to
 * showcase a simple breadth-first-search and depth-first-search implementation. More complex trees and graphs are
 * implemented elsewhere in the codebase.
 * <p></p>
 * This implementation is for education purposes only and is not production ready.
 *
 * @param <T> the data type held in the graph.
 */
public class TreeNode<T> {

    private final T data;
    private final Collection<TreeNode<T>> children;

    public TreeNode(T data, Collection<TreeNode<T>> children) {
        this.data = data;
        this.children = children;
    }

    /**
     * @return the data associated with this node.
     */
    public T getData() {
        return data;
    }

    /**
     * Retrieves children of this Node. This will contain either branches/terminal nodes, or be empty if
     * the node is a terminal node.
     *
     * @return the children of this node.
     */
    public Collection<TreeNode<T>> getChildren() {
        return children;
    }
}
