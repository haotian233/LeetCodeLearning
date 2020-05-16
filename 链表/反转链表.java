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


//K个长度的子链表分别反转
//K长度的子链表的反转，返回一个子链表的头，不改变输入
public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode next;
        ListNode pre = null;
        ListNode cur=head;
        while(cur.next!=null){
            next = cur.next; 
            cur.next = pre;
            pre = cur;
            cur = next;  
        }
        cur.next = pre;
        return cur;
    }
//将链表划分为数个长度为K的子链表，再拼接
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        ListNode pre = new ListNode(0);//链表的初始化
        pre.next = head;
        ListNode tail = pre;
        ListNode cur = head;
        ListNode next;
        ListNode h = pre;//记录头链表位置
        while(tail.next!=null&&tail!=null){
            for(int i=0;i<k&&tail!=null;i++) tail =tail.next;//寻找尾节点，如果为空则返回
            if(tail==null) break;//如果剩下的长度不够K保持原样，直接退出
            next = tail.next;//将tail的next置null前保存next
            tail.next = null;
            pre.next = reverseList(cur);//反转，将pre的next与子链表的头部拼接
            cur.next = next;//将cur，子链表反转后的尾部与next拼接
            pre = cur;//pre变为下一个子链表的pre
            tail = pre;//tail赋值
            cur =next;//cur初始化
        }
        return h.next;
    }
