package co.uk.fractalwrench.dsaa.algorithms;

import co.uk.fractalwrench.dsaa.structures.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeNodeBfsTest {

    @Test
    public void testEmptyBfs() {
        TreeNode<String> node = new TreeNode<>("a", Collections.emptyList());
        List<String> data = performBfs(node);
        assertEquals(Collections.singletonList("a"), data);
    }

    @Test
    public void testChildNodesBfs() {
        Collection<TreeNode<String>> children = Arrays.asList(
                new TreeNode<>("b", Collections.emptyList()),
                new TreeNode<>("c", Collections.emptyList())
        );
        TreeNode<String> node = new TreeNode<>("a", children);
        List<String> data = performBfs(node);
        assertEquals(Arrays.asList("a", "b", "c"), data);
    }

    @Test
    public void testComplexTreeBfs() {
        Collection<TreeNode<String>> children = Arrays.asList(
                new TreeNode<>("b", Arrays.asList(
                        new TreeNode<>("e", Collections.emptyList()),
                        new TreeNode<>("f", Collections.emptyList())
                )),
                new TreeNode<>("c", Arrays.asList(
                        new TreeNode<>("g", Arrays.asList(
                                new TreeNode<>("i", Collections.emptyList()),
                                new TreeNode<>("j", Collections.emptyList())
                        )),
                        new TreeNode<>("h", Collections.emptyList())
                )),
                new TreeNode<>("d", Collections.emptyList())
        );
        TreeNode<String> node = new TreeNode<>("a", children);
        List<String> data = performBfs(node);
        assertEquals(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"), data);
    }

    private List<String> performBfs(TreeNode<String> node) {
        List<String> data = new ArrayList<>();

        SearchUtils.breadthFirstSearch(node, str -> {
            data.add(str);
            return null;
        });
        return data;
    }
}
