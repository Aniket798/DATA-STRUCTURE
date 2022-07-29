public class InserNewNodeAtTheTailOfLinkedList {
Node head;
Node head1;
Node head2;
static class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }

}
    static Node insertNodeAtTail(Node head, int data) {
        Node newNode=new Node(data);

        if(head==null)
            return newNode;

        Node n=head;
        while(n.next!=null){
            n=n.next;
        }
        n.next=newNode;
        return head;



    }
    public  void display(Node head)
    {
        //100->200>300->500
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data+" \n");
            n = n.next;
        }
    }
    public static Node inserNodeAtPosition(Node head,int data,int position){
      Node newNode=new Node(data);
      Node currentNode=head;
      int count=0;
      while(count<=position){
          count++;
          if(count==position){
              Node tempNode=currentNode.next;
              currentNode.next=newNode;
              newNode.next=tempNode;

          }
          else{
              currentNode=currentNode.next;
          }
      }
return head;
    }
    public static Node deleteNode(Node head,int position){
        int count=0;
        Node node=head;
        if(position==0)
            return head.next;
        while(count<position){
            if(count==position-1)
                node.next=node.next.next;
            count++;
            node=node.next;

        }
        return head;
    }
    static Node reverse(Node head) {
        if(head==null)return head;
        Node prev=null;
        Node currentnode=head;
        while(currentnode!=null)
        {
            Node newnode=currentnode.next;
            currentnode.next=prev;
            prev=currentnode;
            currentnode=newnode;
        }
        return prev;
    }
    static Node mergeSortedList(Node headA,Node headB){
        if(headA==null)
            return headB;
        else if(headB==null)
            return headA;
        if (headA.data < headB.data){
            headA.next = mergeSortedList(headA.next, headB);
            return headA;
        }
        else {
            headB.next = mergeSortedList(headA, headB.next);
            return headB;
        }

    }
    public static int getNode(Node llist, int positionFromTail) {
        // Write your code here
        Node newNode=llist;
        Node prev=null;
        while(newNode!=null){
            Node tempNode=newNode.next;
            newNode.next=prev;
            prev=newNode;
            newNode=tempNode;
        }
        Node curentNode=prev;
        int count=0;
        while(count!=positionFromTail){
            count++;
            curentNode=curentNode.next;
        }
        return curentNode.data;
    }
    public static Node removeDuplicates(Node head){
    Node currentNode=head;
    while(currentNode.next!=null){
        if(currentNode.data==currentNode.next.data){
            currentNode.next=currentNode.next.next;
            currentNode=head;
        }
        else
        currentNode=currentNode.next;
    }
    return head;
    }
    public static int pallindrome(Node head){
    //head=2->3->7->3->2->12->24
        //rev=24->12->2->3->7->3->2
        //head=12->4->4->3->14
        //rev=14->3->4->4->12
        int result=0;
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node tempNode=curr.next;
            curr.next=prev;
            result = Math.max(result,
                    2 * countCommon(prev, tempNode)+1);
            result = Math.max(result,
                    2*countCommon(curr, tempNode));

            prev = curr;
            curr = tempNode;

        }
       return result;

    }
    public static int countCommon(Node a,Node b){
    int count=0;
        while(a!=null&&b!=null){
            if(a.data==b.data){
                count++;
                a=a.next;
                b=b.next;
            }
            else
                break;

        }
        return count;
    }

    public static void main(String[] args) {
        InserNewNodeAtTheTailOfLinkedList insert=new InserNewNodeAtTheTailOfLinkedList();
        /*insert.head=new Node(100);
        Node second =new Node(200);
        Node third=new Node(300);
        insert.head.next=second;
        second.next=third;
        System.out.println("Insert Node at tail output");
        insert.display(insertNodeAtTail(insert.head,500));
        System.out.println("Insert Node at Position output");
        insert.display( inserNodeAtPosition(insert.head,324,2));
        System.out.println("Delete Node at position output");
        insert.display(deleteNode(insert.head,3));
        System.out.println("Reverse Node output");
        insert.display(reverse(insert.head));
        insert.head1=new Node(4);
        insertNodeAtTail(insert.head1,5);
        insertNodeAtTail(insert.head1,6);
        insert.head2=new Node(1);
        insertNodeAtTail(insert.head2,2);
        insertNodeAtTail(insert.head2,10);
        System.out.println("Merged Sorted List Output");
        insert.display(mergeSortedList(insert.head1,insert.head2));
        System.out.println("Get Node Position From Tail Output");
        System.out.println(getNode(insert.head1,2));
        System.out.println("Remove Duplicates output");
        Node input=new Node(1);
        input.next=new Node(2);
        input.next.next=new Node(2);
        input.next.next.next=new Node(3);
        input.next.next.next.next=new Node(3);
        input.next.next.next.next.next=new Node(4);
        insert.display(removeDuplicates(input));
*/
        //2->3->7->3->2->12->24
        insert.head=new Node(2);
        insert.head.next=new Node(3);
        insert.head.next.next=new Node(7);
        insert.head.next.next.next=new Node(3);
        insert.head.next.next.next.next=new Node(2);
        insert.head.next.next.next.next.next=new Node(12);
        insert.head.next.next.next.next.next.next=new Node(24);
        System.out.println("Longest pallindrome otput "+pallindrome(insert.head));







//1->2->3

    }
}
