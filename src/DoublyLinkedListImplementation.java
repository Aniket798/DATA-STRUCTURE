public class DoublyLinkedListImplementation {
    DoublyLinkedListNode head;
    static class DoublyLinkedListNode{
        int data;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        DoublyLinkedListNode(int d){
            data=d;
            prev=null;
            next=null;
        }
    }
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode node=new DoublyLinkedListNode(data);
        DoublyLinkedListNode newNode=head;
      if(head==null)
          return node;
      while(newNode!=null){
          if(newNode.data>data){
              node.prev=newNode.prev;
              node.next=newNode;
              newNode.prev=node;
              if(node.prev==null)
              return node;
              else{
                  node.prev.next=node;
                  return head;
              }
          }
          else if(newNode.next==null){
            node.next=null;
            node.prev=newNode;
            newNode.next=node;
            break;
          }
          newNode=newNode.next;
      }
        return head;

    }
    //null<-1<->2<->3<->4<->5->null
    //null<-5<->4<->3<->2<->1->null
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head){
        DoublyLinkedListNode currentnode=head;
        DoublyLinkedListNode res=null;
        while(currentnode!=null){
            DoublyLinkedListNode tempNode=currentnode.next;
            currentnode.next=res;
            currentnode.prev=tempNode;
            res=currentnode;
            currentnode=tempNode;

        }
        return res;
    }
    public static void display(DoublyLinkedListNode head){
        DoublyLinkedListNode node=head;
        while(node!=null){
            System.out.println(node.data);
            node=node.next;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedListImplementation dlli=new DoublyLinkedListImplementation();
        dlli.head=new DoublyLinkedListNode(1);
        DoublyLinkedListNode second=new DoublyLinkedListNode(2);
        dlli.head.next=second;
        second.prev=dlli.head;
        DoublyLinkedListNode third=new DoublyLinkedListNode(4);
        second.next=third;
        third.prev=second;
        DoublyLinkedListNode fourth=new DoublyLinkedListNode(5);
        third.next=fourth;
        fourth.prev=third;
        DoublyLinkedListNode fifth=new DoublyLinkedListNode(10);
        fourth.next=fifth;
        fifth.prev=third;
        display(sortedInsert(dlli.head,3));
        display(reverse(dlli.head));


    }
}
