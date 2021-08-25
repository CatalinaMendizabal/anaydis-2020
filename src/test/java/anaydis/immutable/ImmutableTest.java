package anaydis.immutable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


public class ImmutableTest {
    BinaryTree<String, Integer> binaryTree = new BinaryTree<>(String::compareTo);

    @Test
    public void bankerQueueTest() {
        BankersQueue<String> queue = new BankersQueue<>();
        queue = (BankersQueue<String>) queue.enqueue("hola");
        queue = (BankersQueue<String>) queue.enqueue("chau");
        assertFalse(queue.isEmpty());
        assertThat(queue.dequeue().equals("hola"));
        assertThat(queue.dequeue().equals("chau"));
        assertThat(queue.dequeue().equals(null));
        assertThat(queue.dequeue().equals(null));
        assertThat(queue.dequeue().equals(null));
    }

    @Test
    public void binaryTreeTest() {
        List<String> list = new ArrayList<>();
        list.add("hola");
        list.add("como");
        list.add("estas");
        list.add("chau");
        assertTrue(binaryTree.isEmpty());
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("hola", 10);
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("como", 11);
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("asd", 11);
        binaryTree = (BinaryTree<String, Integer>) binaryTree.put("fjh", 11);
        assertThat(binaryTree.get("como").equals(11));
        assertEquals(4, binaryTree.size());
        assertTrue(binaryTree.containsKey("fjh"));
        assertThat(binaryTree.keys().equals(list));
        assertTrue(binaryTree.keys().hasNext());
        assertThat(binaryTree.keys().next().equals("como"));
    }

    public void nodeTest(){
        anaydis.immutable.List<Object> node = anaydis.immutable.List.nil();
        assertTrue(node.isEmpty());
        node = anaydis.immutable.List.cons("a", anaydis.immutable.List.nil());
        assertEquals("a", node.head());
        node = anaydis.immutable.List.cons("a", anaydis.immutable.List.cons("b", anaydis.immutable.List.nil()));
        assertEquals("a", node.head());
        assertEquals("b", node.tail().head());
        anaydis.immutable.List<String> node2 = anaydis.immutable.List.cons("a", anaydis.immutable.List.cons("b", anaydis.immutable.List.cons("c", anaydis.immutable.List.nil())));
        anaydis.immutable.List<String> reversed = node2.reverse();
        assertEquals("c", reversed.head());
        assertEquals("b", reversed.tail().head());
        assertEquals("a", reversed.tail().tail().head());
    }
    @Test (expected = IllegalStateException.class)
    public void test_nil_head(){
        Node.NIL.head();
    }

    @Test (expected = IllegalStateException.class)
    public void test_nil_tail(){
        Node.NIL.tail();
    }

    @Test (expected = IllegalStateException.class)
    public void test_nil_reverse(){
        Node.NIL.reverse();
    }

}
