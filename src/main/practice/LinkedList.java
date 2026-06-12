package practice;

import java.util.Objects;

/**
 * The same LinkedList as the chapter's, rebuilt with two sentinel nodes. The
 * public operations are identical; the sentinels only change the internals.
 *
 * head and tail always point to sentinel nodes. The first real node is
 * head.next, the last real node is tail.prev, and the list is empty exactly
 * when head.next == tail. Because every real node always has both a prev and a
 * next, add and remove need no boundary-case branches.
 */
public class LinkedList<T> {

  private Node<T> head;   // front sentinel
  private Node<T> tail;   // back sentinel
  private int size;       // number of real nodes

  private static class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    Node(T value) {
      this.value = value;
    }
  }

  public LinkedList() {
    head = new Node<>(null);
    tail = new Node<>(null);
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  public void add(T value) {
    insertBetween(value, tail.prev, tail);
  }

  public T get(int index) {
    return node(index).value;
  }

  public void set(int index, T value) {
    node(index).value = value;
  }

  public int size() {
    return size;
  }

  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  public int indexOf(T value) {
    Node<T> current = head.next;
    int index = 0;
    while (current != tail) {
      if (Objects.equals(current.value, value)) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  public T remove(int index) {
    return removeNode(node(index));
  }

  public boolean remove(T value) {
    Node<T> current = head.next;
    while (current != tail) {
      if (Objects.equals(current.value, value)) {
        removeNode(current);
        return true;
      }
      current = current.next;
    }
    return false;
  }

  // Insert a new node holding value between two existing nodes.
  private Node<T> insertBetween(T value, Node<T> before, Node<T> after) {
    Node<T> node = new Node<>(value);
    node.prev = before;
    node.next = after;
    before.next = node;
    after.prev = node;
    size++;
    return node;
  }

  // Unlink a node and return its value. With sentinels, target always has both
  // a prev and a next, so there are no boundary branches.
  private T removeNode(Node<T> target) {
    T removed = target.value;
    target.prev.next = target.next;
    target.next.prev = target.prev;
    size--;
    return removed;
  }

  // Walk to the node at a given index, from whichever end is nearer.
  private Node<T> node(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    if (index < size / 2) {
      Node<T> current = head.next;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      return current;
    } else {
      Node<T> current = tail.prev;
      for (int i = size - 1; i > index; i--) {
        current = current.prev;
      }
      return current;
    }
  }
}
