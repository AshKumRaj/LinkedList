/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 *
 * @author Ashish
 */
public class Node {
    Node next = null;
        int data;
        public Node(int d){
            data = d;
        }
        public Node partitionList(Node node,int partition){
		//Node node = this;
		Node sList = null , bList =null;
                //System.out.println(node.data);
		while(node!=null){
                    Node n = node;
                    //node = null;
			if(n.data < partition){
                            if(sList == null){
                                sList = n;
                            }
                            else
                            {
                                sList.next = n;
                            }
				
                        }
                        else{
                            if(bList == null){
                                bList = n;
                            }
                            else
                            {
                                bList.next = n;
                            }
                        }
				
			node = node.next;
		}
		//sList.next = bList;
                sList.showData();
                System.out.println();
                bList.showData();
                System.out.println();
                return sList;
			
	}
        void appendToTail(int d){
            Node end = new Node(d);
            Node n = this;
            while(n.next != null){
                n = n.next;
            }
            n.next = end;
        }
        void showData(){
            Node n = this;
            while(n!=null){
                System.out.print(n.data+"->");
                n=n.next;
            }
                       
        }
        
        Node deleteNode(Node head, int d){
            Node n = head;
            boolean found = false;
            if(n.data == d){
                found = true;
                return head.next;
                
            }
            while(n.next != null){
                if(n.next.data == d){
                    n.next = n.next.next;
                    found = true;
                    return head;
                }
                n = n.next;
            }
            if(!found)
                System.out.println("The given node is not present in the list.");
            return head;
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node n1 = new Node(10);
        Node head = n1;
        n1.appendToTail(2);
        n1.appendToTail(3);
        n1.appendToTail(0);
        n1.appendToTail(5);
        n1.showData();
        //head = n1.deleteNode(head, 1);
        //System.out.println();
        System.out.println("Head="+head.data);
        //head.showData();
        Node newList = head.partitionList(head,3);
        newList.showData();
    }
    
}
