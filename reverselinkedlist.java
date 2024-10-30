import java.util.*;

public class reverselinkedlist {
    Node head;
    private int size;
    linkedlist()
    {
        this.size=0;
    }
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
            size++;
        }
    }
        //addfirst
    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
        
    }
    public void addBetween(int data,int position)
    {
        Node newNode=new Node(data);
        if(position==0)
        {
            newNode.next=head;
            head=newNode;
            return;
        }
        Node temp=head;
        for(int i=0;i<position-1&&temp!=null;i++)
        {
            temp=temp.next;
        }
        if(temp==null)
        {
            System.out.println("out of bounds");
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public void deleteFirst()
    {
        if(head==null)
        {
            System.out.println("list is empty");
            return;
        }
        size--;
        head=head.next;
    }
    public void deleteLast()
    {
        if(head==null)
        {
            System.out.println("list is empty");
            return;
        }
        size--;
        if(head.next==null)
        {
            head=null;
            return;
        }
        Node secondlast=head;
        Node last=head.next;
        while(last.next!=null)
        {
            last=last.next;
            secondlast=secondlast.next;
        }
        secondlast.next=null;
    }
    public void deleteBetween(int position)
    {
        if(head==null)
        {
            System.out.println("list is empty");
            return;
        }
        size--;
        if(position==0)
        {
            head=head.next;
        }
        Node temp=head;
        for(int i=0;i<position-1&&temp!=null;i++)
        {
            temp=temp.next;
        }
        if(temp==null||temp.next==null)
        {
            System.out.println("out of bounds");
            return;
        }
        temp.next=temp.next.next;
    }
    public void printList()
    {
        if(head==null)
        {
            System.out.println("list is empty");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int getSize()
    {
        return size;
    }
    public void reverseiterate()
    {
        if(head==null||head.next==null)
        {
            return;
        }
        Node prevNode=head;
        Node currNode=head.next;
        while(currNode!=null)
        {
            Node nextNode=currNode.next;

            currNode.next=prevNode;

            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }
    public Node recursivelinkedlist(Node head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        Node newHead=recursivelinkedlist(head.next);

        head.next.next=head;
        head.next=null;

        return newHead;
    }
    public static void main(String[] args) {
        reverselinkedlist list=new reverselinkedlist();
        list.addFirst(3);
        list.addFirst(2);
        list.addLast(4);
        list.printList();
        list.addFirst(1);
        list.printList();
        list.addBetween(5, 2);
        list.printList();
        
        list.head=list.recursivelinkedlist(list.head);
        list.printList();
    
}
    
}
