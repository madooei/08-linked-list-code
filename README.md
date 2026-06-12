# The Linked List

A list that stores its elements in linked nodes rather than a backing array, and
the same list rebuilt with sentinel nodes to remove the boundary cases. This is
the reference code for Chapter 8 — the classes here are assembled exactly as the
chapter notes build them up, step by step.

## Prerequisites

- JDK 17+

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  src/
    main/
      linkedlist/
        LinkedList.java   # the chapter's doubly linked list: head/tail/size, private Node
        Main.java         # a small demo
      practice/
        LinkedList.java   # practice: the same list rebuilt with front/back sentinels
        PracticeMain.java # the practice demo
  scripts/
    run.sh                # compile everything and run the Main demo
    run-practice.sh       # compile everything and run the practice demo
```

## How to compile and run

- `scripts/run.sh` — compiles all source into `out/` and runs the `Main` demo.
- `scripts/run-practice.sh` — compiles all source into `out/` and runs the practice demo (`practice.PracticeMain`).

There is no build tool and no test suite: testing is introduced later in the
course. The scripts above are all you need.

## What's here

- `linkedlist.LinkedList<T>` — the chapter's doubly linked list. It keeps `head`,
  `tail`, and `size`, and a private static `Node<T>` with `value`, `next`, and
  `prev`. The public surface matches `DynamicArray` — `add`, `get`, `set`,
  `size`, `contains`, `indexOf`, and the two `remove` overloads — so code written
  against those operations could be handed either class. The private `node(index)`
  walk starts from whichever end is nearer. `add` and `remove` branch on the ends
  of the list (the empty case, the head, the tail).
- `linkedlist.Main` — a runnable demo: build a list, read and update it by index,
  search it, remove by index and by value, and the `remove(int)` vs `remove(T)`
  overload trap.
- `practice.LinkedList<T>` — the chapter's practice problem: the same list rebuilt
  with two sentinel nodes. `head` and `tail` always point to sentinels; the first
  real node is `head.next`, the last is `tail.prev`, and the list is empty exactly
  when `head.next == tail`. Because every real node always has both a `prev` and a
  `next`, `add` (via `insertBetween`) and `remove` (via `removeNode`) have no
  boundary-case branches. The public operations are identical to the chapter's.
- `practice.PracticeMain` — exercises the sentinel list, including removing at the
  head and the tail, which here needs no special case.
