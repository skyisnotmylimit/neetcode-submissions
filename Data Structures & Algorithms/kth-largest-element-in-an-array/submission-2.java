class FixedSizePriorityQueue<E> extends PriorityQueue<E> {
    private int maxSize;

    public FixedSizePriorityQueue(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(E e) {
        if (size() < maxSize) {
            return super.add(e);
        } else {
            Comparator<? super E> comp = comparator();
            // Handle both cases: natural order or custom comparator
            if ((comp == null && ((Comparable<? super E>) e).compareTo(peek()) > 0) || 
                (comp != null && comp.compare(e, peek()) > 0)) {
                // If the new element is larger than the smallest, replace the smallest
                poll();
                return super.add(e);
            }
        }
        return false;
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap of size k to store the k largest elements
        FixedSizePriorityQueue<Integer> pq = new FixedSizePriorityQueue<>(k);
        for (int num : nums) {
            pq.add(num);
        }
        // The top of the priority queue is the kth largest element
        return pq.peek();
    }
}
