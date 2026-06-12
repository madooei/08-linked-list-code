package linkedlist;

/** A runnable demo of the chapter's doubly linked LinkedList. */
public final class Main {

  private Main() {}

  public static void main(String[] args) {
    LinkedList<String> names = new LinkedList<>();
    names.add("Ada");
    names.add("Linus");
    names.add("Grace");
    System.out.println("names: " + toString(names));
    System.out.println("size = " + names.size());
    System.out.println("get(1) = " + names.get(1));

    names.set(1, "Alan");
    System.out.println("after set(1, \"Alan\"): " + toString(names));

    System.out.println("contains(\"Grace\")? " + names.contains("Grace"));
    System.out.println("indexOf(\"Grace\") = " + names.indexOf("Grace"));

    String removed = names.remove(0);
    System.out.println("remove(0) returned " + removed + " -> " + toString(names));
    names.remove("Grace");
    System.out.println("after remove(\"Grace\"): " + toString(names));

    // The remove overload trap: remove(int) is by index, remove(T) is by value.
    LinkedList<Integer> scores = new LinkedList<>();
    scores.add(50);
    scores.add(60);
    scores.add(70);
    System.out.println();
    System.out.println("scores: " + toString(scores));
    scores.remove(2);                      // remove(int): index 2 (the 70)
    System.out.println("after remove(2) — by index: " + toString(scores));
    scores.remove(Integer.valueOf(50));    // remove(T): the value 50
    System.out.println("after remove(Integer.valueOf(50)) — by value: " + toString(scores));
  }

  // Builds "[a, b, c]" by reading the list through its public get/size.
  private static <T> String toString(LinkedList<T> list) {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < list.size(); i++) {
      str.append(list.get(i));
      if (i < list.size() - 1) {
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();
  }
}
