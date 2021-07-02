package co.uk.fractalwrench.dsaa.structures;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {

    @Test(expected = IllegalArgumentException.class)
    public void findWordsRootNode() {
        Trie trie = new Trie();
        trie.addWord("apple");
        trie.addWord("app");
        trie.findWordsWithPrefix("");
    }

    @Test
    public void findWordsWithPrefix() {
        Trie trie = new Trie();
        assertEquals(Collections.emptyList(), trie.findWordsWithPrefix("test"));

        trie.addWord("apple");
        trie.addWord("app");
        trie.addWord("android");
        trie.addWord("blackberry");

        assertEquals(Collections.singletonList("blackberry"), trie.findWordsWithPrefix("b"));
        assertEquals(Arrays.asList("app", "apple", "android"), trie.findWordsWithPrefix("a"));
        assertEquals(Arrays.asList("app", "apple"), trie.findWordsWithPrefix("ap"));
        assertEquals(Collections.singletonList("apple"), trie.findWordsWithPrefix("app"));
        assertEquals(Collections.emptyList(), trie.findWordsWithPrefix("application"));
    }

    @Test
    public void containsWord() {
        Trie trie = new Trie();
        assertFalse(trie.containsWord("cat"));

        trie.addWord("cat");
        assertFalse(trie.containsWord("dog"));
        assertTrue(trie.containsWord("cat"));

        trie.addWord("car");
        trie.removeWord("cat");
        assertFalse(trie.containsWord("cat"));
        assertTrue(trie.containsWord("car"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeEmptyWord() {
        Trie trie = new Trie();
        trie.removeWord("");
    }

    @Test
    public void removeWords() {
        Trie trie = new Trie();
        trie.addWord("cat");
        trie.addWord("camera");
        trie.removeWord("camera");
        assertEquals(Collections.singletonList("cat"), trie.findWordsWithPrefix("ca"));

        trie.removeWord("ca");
        assertEquals(Collections.singletonList("cat"), trie.findWordsWithPrefix("ca"));

        trie.addWord("car");
        trie.addWord("cater");
        trie.removeWord("cat");
        assertEquals(Arrays.asList("car", "cater"), trie.findWordsWithPrefix("ca"));
    }

    @Test
    public void isEmpty() {
        Trie trie = new Trie();
        assertTrue(trie.isEmpty());

        trie.addWord("hello");
        assertFalse(trie.isEmpty());

        trie.removeWord("hello");
        assertTrue(trie.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEmptyWord() {
        Trie trie = new Trie();
        trie.addWord("");
    }
}
