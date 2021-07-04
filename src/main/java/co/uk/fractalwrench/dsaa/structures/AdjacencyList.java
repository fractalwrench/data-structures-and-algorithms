package co.uk.fractalwrench.dsaa.structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AdjacencyList {

    /**
     * Finds suggestions of new friends by exhaustively searching the graph using BFS.
     * Suggestions are returned by relevance - the closest relationships will be first.
     *
     * @param startNode - the node from which to start.
     * @return friends of friends.
     */
    public List<String> findFriendSuggestions(GraphNode startNode) {
        // 1. mark nodes as visited to handle cyclic relationships in the graph
        Set<GraphNode> visited = new HashSet<>();
        visited.add(startNode);
        Queue<GraphNode> queue = new LinkedList<>(startNode.getAdjacentNodes());
        List<String> suggestions = new ArrayList<>();

        // 2. perform BFS
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();

            if (visited.contains(node)) { // 3. skip any nodes that are already visited
                continue;
            }

            // 4. add the suggested friend if it is not the root or a friend of the root node
            if (!node.getAdjacentNodes().contains(startNode)) {
                suggestions.add(node.data);
            }

            // 5. add child nodes to the queue and mark this node as visited
            queue.addAll(node.getAdjacentNodes());
            visited.add(node);
        }
        return suggestions;
    }

    /**
     * Represents a node in the graph, which contains references to all the adjacent nodes.
     */
    public static class GraphNode {
        private final String data;
        private final Collection<GraphNode> adjacentNodes = new ArrayList<>();

        public GraphNode(String data) {
            this.data = data;
        }

        public void addAdjacentNode(GraphNode node) {
            if (node == this) {
                throw new IllegalArgumentException("Cannot add self as an adjacent node");
            }
            if (!adjacentNodes.contains(node)) {
                adjacentNodes.add(node);
                node.addAdjacentNode(this);
            }
        }

        public Collection<GraphNode> getAdjacentNodes() {
            return adjacentNodes;
        }
    }
}
