package utils;

/**
 * The UF struct represents a union-find (disjoint sets) data structure
 * It supports **union** and **find** operations, along with methods for
 * determining whether two nodes are in the same component and the total number of components.
 * - This implementation uses weighted quick union (by size or rank) with full path compression.
 * - Initializing a data structure with **n** nodes takes linear time.
 * - Afterwards, **union**, **find**, and **connected** take logarithmic time (in the worst case)
 *   and **count** takes constant time.
 * - Moreover, the amortized time per union**, **find**, and **connected** operation
 *   has inverse Ackermann complexity (which is practically < 5 for 2^(2^(2^(2^16))) - undefined number).
 *
 */
public class UnionFind {
    // parent[i] = parent of i
    private final int[] parent;
    // size[i] = number of nodes in tree rooted at i
    private final int[] size;
    // number of components
    private int count;

    /***
     * Initializes an empty union-find data structure with n elements
     * Initially, each element is in its own set.
     *
     * @param count number of elements
     */
    public UnionFind(int count) {
        this.count = count;
        this.size = new int[count];
        
        this.parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int[] getParent() {
        return parent;
    }

    public int[] getSize() {
        return size;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /***
     * Returns the canonical element(root) of the set containing element `p`.
     *
     * @param p an element
     * @return the canonical element of the set containing element `p`.
     */
    public int find(int p) {
        try {
            validate(p);
            int root = p;

            while (root != parent[root]) {  // find the root
                root = parent[root];
            }

            while (p != root) {
                int newP = parent[p];
                parent[p] = root;  // path compression
                p = newP;
            }

            return root;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * Returns `true` if the two elements are in the same set.
     *
     * @param p one element
     * @param q the other element
     * @return `true` if the two elements are in the same set.
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (!connected(rootP, rootQ)) {  // already connected
            // make smaller root point to larger one
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            this.count -= 1;
        }
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }
}
