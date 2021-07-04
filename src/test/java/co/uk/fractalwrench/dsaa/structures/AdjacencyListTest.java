package co.uk.fractalwrench.dsaa.structures;

import co.uk.fractalwrench.dsaa.structures.AdjacencyList.GraphNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdjacencyListTest {

    @Test
    public void zeroFriends() {
        GraphNode adrian = new GraphNode("Adrian");
        AdjacencyList list = new AdjacencyList();
        assertEquals(Collections.emptyList(), list.findFriendSuggestions(adrian));
    }

    /**
     * Setup a cyclic graph representing relationships between friends
     */
    @Test
    public void findFriendsOfFriends() {
        GraphNode adrian = new GraphNode("Adrian");
        GraphNode bob = new GraphNode("Bob");
        GraphNode cecil = new GraphNode("Cecil");
        GraphNode dave = new GraphNode("Dave");
        GraphNode eve = new GraphNode("Eve");
        GraphNode freya = new GraphNode("Freya");
        GraphNode greta = new GraphNode("Greta");
        GraphNode harold = new GraphNode("Harold");
        GraphNode ivan = new GraphNode("Ivan");

        // adrian's friends
        adrian.addAdjacentNode(cecil);
        adrian.addAdjacentNode(dave);
        adrian.addAdjacentNode(freya);

        // bob's friends
        bob.addAdjacentNode(cecil);
        bob.addAdjacentNode(eve);
        bob.addAdjacentNode(freya);

        // dave's friends
        dave.addAdjacentNode(freya);

        // freya's friends
        freya.addAdjacentNode(greta);

        // greta's friends
        greta.addAdjacentNode(harold);

        // greta's friends
        harold.addAdjacentNode(ivan);

        // check friends of friends
        AdjacencyList list = new AdjacencyList();
        assertEquals(Arrays.asList("Bob", "Greta", "Eve", "Harold", "Ivan"), list.findFriendSuggestions(adrian));
        assertEquals(Arrays.asList("Cecil", "Freya", "Adrian", "Dave", "Greta", "Harold", "Ivan"), list.findFriendSuggestions(eve));
        assertEquals(Arrays.asList("Cecil", "Eve", "Harold", "Ivan"), list.findFriendSuggestions(freya));
        assertEquals(Arrays.asList("Greta", "Freya", "Adrian", "Bob", "Dave", "Cecil", "Eve"), list.findFriendSuggestions(ivan));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingRelationshipToSelf() {
        GraphNode alice = new GraphNode("Alice");
        alice.addAdjacentNode(alice);
    }

    @Test
    public void addingNodeCreatesRelationship() {
        GraphNode alice = new GraphNode("Alice");
        GraphNode bob = new GraphNode("Bob");
        alice.addAdjacentNode(bob);

        assertEquals(1, alice.getAdjacentNodes().size());
        assertEquals(1, bob.getAdjacentNodes().size());
        assertTrue(alice.getAdjacentNodes().contains(bob));
        assertTrue(bob.getAdjacentNodes().contains(alice));

        // adding a second time has no effect on relationship
        alice.addAdjacentNode(bob);
        bob.addAdjacentNode(alice);
        assertEquals(1, alice.getAdjacentNodes().size());
        assertEquals(1, bob.getAdjacentNodes().size());
        assertTrue(alice.getAdjacentNodes().contains(bob));
        assertTrue(bob.getAdjacentNodes().contains(alice));
    }
}