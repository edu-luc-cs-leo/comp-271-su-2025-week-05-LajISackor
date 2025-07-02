# Week 04 Reflection

Comparing my implementation of `DoubleLinkedList` to Leo's posted solution helped me clearly see what I got right, what I got close, and where I missed the mark. 

**What I got right**:
- I implemented the `add(Node node)` method correctly by checking for whether the list is empty and using the `tail` pointer to avoid traversing the whole list.
- I correctly wrote a wrapper for `add(String value)` that creates a new node and delegates to the `add(Node)` method.
- My `contains(String)` method is also written as a wrapper around `indexOf`, which is consistent with Leo. 

**What I got close**:
- I used the correct logic in my `indexOf(String)` method, but I did not handle the off-by-one issue that can arise depending on when the counter is incremented. Leo’s approach ensures accuracy by updating the position correctly using `position = counter - 1` after the loop.
- I used a basic size calculation by traversing the list with a counter, but Leo’s solution improved this by maintaining a `size` field that gets updated during insertion—this avoids unnecessary traversal.

**What I missed**:
- My `toString()` was minimal, returning just the list name. Leo’s `toString()` method uses a `StringBuilder` and prints the list content with formatting and punctuation. This shows more care for code readability and object usability.
- I didn’t implement a `compareTo` method based on a unique metric like vowel count. Mine was based on size, which is acceptable, but Leo’s creative implementation was more insightful and gave me ideas on thinking beyond just what you see. 

**What I learned**:
- Wrapper functions and clear delegation make code shorter, cleaner, and more reusable.
- Tracking size as a field is more efficient than recalculating it repeatedly.
- I need to factor out repeated code when possible, such as updating `tail` in both branches of a conditional.

**Plan for improvement**:
I spend more time reading through the instructions and posted solutions before beginning my code. Going forward, I’ll make sure to test earlier and use `toString()` to print intermediate results when debugging. I’ll also double check my loop logic to avoid off by a little errors. Finally, I’ll continue improving my comments and guard statements to follow the Programmer’s Pact.

