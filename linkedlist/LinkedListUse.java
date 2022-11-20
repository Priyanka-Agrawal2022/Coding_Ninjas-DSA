package linkedlist;

import java.util.Scanner;

public class LinkedListUse {

	public static void main(String[] args) {
//		Node<Integer> n1 = new Node<>(10);
//		System.out.println(n1);
//		System.out.println(n1.data);
//		System.out.println(n1.next);
		
//		Node<Integer> head = createLinkedList();
		Node<Integer> head = optimizeTakeInput();
		printLinkedList(head);
		head = insertNode(80, 6, head);
		printLinkedList(head);
		head = deleteNode(6, head);
		printLinkedList(head);
//		printLinkedList(head);
//		System.out.println();
		
//		int[] arr = new int[] {1, 2, 3, 4};
//		
//		for(int a: arr)
//			System.out.print(a + " ");
//		System.out.println();
//		print(arr);
//		
//		for(int a: arr)
//			System.out.print(a + " ");
	}
	
	public static Node<Integer> createLinkedList() {
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		Node<Integer> head = n1;
		return head;
	}
	
	public static Node<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null;
		
		while(data != -1) {
			Node<Integer> curr = new Node<Integer>(data);
			if(head==null) {
				//curr will become head
				head = curr;
			}
			else {
				Node<Integer> tail = head;
				//make tail refer to the last node
				//connect curr after the last node
				while(tail.next != null) {
					tail = tail.next;
				}
				tail.next = curr;
			}
			data = sc.nextInt();
		}
		
		return head;
	}
	
	public static Node<Integer> optimizeTakeInput() {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null, tail = null;
		
		while(data != -1) {
			Node<Integer> curr = new Node<Integer>(data);
			if(head==null) {
				//curr will become head & tail will point to curr
				head = curr;
				tail = curr;
			}
			else {
				//connect curr after the last node
				tail.next = curr;
				//make tail refer to the last node
				tail = tail.next; //tail = curr
			}
			data = sc.nextInt();
		}
		
		return head;
	}
	
	public static Node<Integer> insertNode(int data, int pos, Node<Integer> head) {
		Node<Integer> newNode = new Node<>(data);
        
//        //calculate length
//		Node<Integer> temp = head;
//        int len=0;
//        while(temp != null) {
//            len++;
//            temp = temp.next;
//        }
//        
//        if(pos>len)
//            return head;
        
        //insertion at 0th index
        if(pos==0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        
        Node<Integer> prev = head;
        
        for(int i=0; i<pos-1 && prev!=null; i++) {
            prev = prev.next;
        }
        
        if(prev != null) {
        	newNode.next = prev.next;
            prev.next = newNode;
        }
        
        return head;
	}
	
	public static Node<Integer> deleteNode(int pos, Node<Integer> head) {
		if(head==null)
			return head;
		
		//deleting 1st node
		if(pos==0) {
            head = head.next;
            return head;
        }
        
        Node<Integer> prev = head;
        int i=0;
        
        //reaching node just before the node to be deleted
        while(i<pos-1 && prev.next!=null) {
            prev = prev.next;
            i++;
        }
        
        if(prev.next!=null) {
            prev.next = prev.next.next;
        }
        
        return head;
	}

	public static void printLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
//		if(head == null)
//			return;
//		System.out.print(head.data + " ");
//		printLinkedList(head.next);
	}
	
	public static void print(int[]arr) {
		arr = new int[]{5, 10, 15};
		
		for(int a: arr)
			System.out.print(a + " ");
		System.out.println();
	}
}
