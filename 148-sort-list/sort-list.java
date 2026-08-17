class Solution {

    // Merge two sorted linked lists
    ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (left != null && right != null) {

            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        // Remaining elements
        if (left != null) {
            temp.next = left;
        }

        if (right != null) {
            temp.next = right;
        }

        return dummy.next;
    }


    // Merge Sort
    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Divide into two parts
        ListNode right = slow.next;
        slow.next = null;

        // Sort left part
        ListNode left = sortList(head);

        // Sort right part
        right = sortList(right);

        // Merge both parts
        return merge(left, right);
    }
}