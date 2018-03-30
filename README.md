# A library facilitates learning algorithm

## Getting Started

### Installing

This library is maven based, so to initialize

```
mvn install
```

then
```
cd fe
npm install
npm build
```

And run one of the examples, say

```
com.aiexpanse.algo.tree.traversal.PostOrderTraversal
```

## Visualization
An easy to use visualization approach is created in this library. Run any example with visualization
support will start an embedded jetty server which serves at port 8080.

```java
package com.aiexpanse.algo.tree.traversal;

import com.aiexpanse.algo.tree.Node;
import com.aiexpanse.algo.tree.TreeBase;

public class PostOrderTraversal extends TreeBase<Integer> {

    public static void main(String[] args) {
        PostOrderTraversal self = new PostOrderTraversal();
        Node<Integer> postOrderSeq = self.createPostOrderSeq(103, 1, IntGen);
        self.postOrderTraverse(postOrderSeq, IntPrint);
        self.serve(postOrderSeq);
    }

}
```

serves below interactive tree:

![Tree](images/tree.png?raw=true "Tree")