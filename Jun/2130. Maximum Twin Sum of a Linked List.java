/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        ListNode temp=head;
        while(fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            temp.next=prev;
            prev=temp;
            temp=slow;
        }

        temp=slow.next;
        slow.next=prev;
        int max=0;
        while(temp!=null){
          max=Math.max(max,temp.val+slow.val);
          temp=temp.next;
          slow=slow.next;
        }
        return max;
    }
}
