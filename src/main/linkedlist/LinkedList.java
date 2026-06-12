package linkedlist;

import java.util.Objects;

public class LinkedList<T> {

  private Node<T> head;   // the first node, or null when empty
  private Node<T> tail;   // the last node, or null when empty
  private int size;       // how many nodes are in the list

  private static class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    Node(T value) {
      this.value = value;
    }
  }

  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public void add(T value) {
    Node<T> newNode = new Node<>(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return node(index).value;
  }

  public void set(int index, T value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    node(index).value = value;
  }

  public int size() {
    return size;
  }

  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  public int indexOf(T value) {
    Node<T> current = head;
    int index = 0;
    while (current != null) {
      if (Objects.equals(current.value, value)) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<T> target = node(index);
    T removed = target.value;

    if (target.prev == null) {
      head = target.next;
    } else {
      target.prev.next = target.next;
    }

    if (target.next == null) {
      tail = target.prev;
    } else {
      target.next.prev = target.prev;
    }

    size--;
    return removed;
  }

  public boolean remove(T value) {
    int index = indexOf(value);
    if (index == -1) {
      return false;
    }
    remove(index);
    return true;
  }

  // Walk to the node at a given index. Private — nodes never leave the class.
  private Node<T> node(int index) {
    if (index < size / 2) {
      Node<T> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      return current;
    } else {
      Node<T> current = tail;
      for (int i = size - 1; i > index; i--) {
        current = current.prev;
      }
      return current;
    }
  }
}
