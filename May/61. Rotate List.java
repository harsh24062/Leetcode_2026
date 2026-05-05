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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        int size=0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }

        k = k%size;
        if(k==0)return head;
        temp=head;
        int n = size-k;
        while(n-->1){
            temp=temp.next;
        }
        ListNode temp2 = temp.next;
        ListNode temp3 = temp.next;
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        temp2.next=head;
        temp.next=null;
        head=temp3;
        return head;
    }
}
