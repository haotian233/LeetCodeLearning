//单链表反转
/*
1.[pre] [head]->[next]->[]
2.[pre]<-[head] [next]->[]
3.[]<-[pre] [head]->[next]
4.[]<-[pre]<-[head]->[next]
5.[]<-[]<-[pre]<-[head]

head.next = pre;
pre = head;
head = next;
next = head.next;
*/
public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode next = head.next;
        ListNode pre = null;
        while(head.next!=null){
            head.next = pre;
            pre = head;
            head = next;
            next = head.next;   
        }
        head.next = pre;
        return head;
    }
