package practice;

/**
 * A demo of the sentinel-based LinkedList. Its public behavior is identical to
 * the chapter's LinkedList — the sentinels only change the internals, removing
 * the boundary-case branches from add and remove. Removing at the very ends,
 * in particular, needs no special case here.
 */
public final class PracticeMain {

  private PracticeMain() {}

  public static void main(String[] args) {
    LinkedList<String> names = new LinkedList<>();
    System.out.println("empty: size = " + names.size() + " -> " + toString(names));

    names.add("Ada");
    names.add("Linus");
    names.add("Grace");
    System.out.println("after three adds: " + toString(names));
    System.out.println("get(2) = " + names.get(2));

    names.set(0, "Alan");
    System.out.println("after set(0, \"Alan\"): " + toString(names));

    System.out.println("indexOf(\"Grace\") = " + names.indexOf("Grace"));
    System.out.println("contains(\"Linus\")? " + names.contains("Linus"));

    // Removing at the head and the tail — no boundary branch needed.
    System.out.println("remove(0) returned " + names.remove(0) + " -> " + toString(names));
    System.out.println("remove(size - 1) returned "
        + names.remove(names.size() - 1) + " -> " + toString(names));

    names.remove("Linus");
    System.out.println("after remove(\"Linus\"): " + toString(names));
    System.out.println("now empty? size = " + names.size());
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
