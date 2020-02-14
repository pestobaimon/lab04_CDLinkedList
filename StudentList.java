
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) throws Exception {
		DListIterator i2next = new DListIterator (i2.currentNode.nextNode);
		DListIterator i2prev = new DListIterator (i2.currentNode.previousNode);
		DListIterator i1next = new DListIterator (i1.currentNode.nextNode);
		DListIterator i1prev = new DListIterator (i1.currentNode.previousNode);
		
		//i1Node
		i1.currentNode.nextNode = i2next.currentNode;
		i1.currentNode.previousNode = i2prev.currentNode;
		//i1NextNode
		i1next.currentNode.previousNode = i2.currentNode;
		//i1prevNode
		i1prev.currentNode.nextNode = i2.currentNode;
		
		//i2Node
		i2.currentNode.nextNode = i1next.currentNode;
		i2.currentNode.previousNode = i1prev.currentNode;
		//i2NextNode
		i2next.currentNode.previousNode = i1.currentNode;
		//i2prevNode
		i2prev.currentNode.nextNode = i1.currentNode;
		
		
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
		if(lst.size == 0) return;
		DListIterator ilstHead = new DListIterator (lst.header.nextNode);
		DListIterator i1next = new DListIterator (i1.currentNode.nextNode);
		DListIterator ilstTail = new DListIterator (lst.header.previousNode);
		i1.currentNode.nextNode = ilstHead.currentNode;
		i1next.currentNode.previousNode = ilstTail.currentNode;
		ilstHead.currentNode.previousNode = i1.currentNode;
		ilstTail.currentNode.nextNode = i1next.currentNode;
	}

	// implement this method
	public void gender(String g) throws Exception {
		System.out.println(g);
		DListIterator itr = new DListIterator (this.header.nextNode);
		CDLinkedList temp = new CDLinkedList();
		DListIterator tempitr = new DListIterator (temp.header);
		DListIterator header = new DListIterator(this.header);
		
		while(itr.currentNode.data != null) {
			Student s = (Student) itr.currentNode.data;
			if(s.getSex() == g) { 
				DListIterator itrremove = new DListIterator (itr.currentNode.previousNode);
				temp.insert(itr.currentNode.data, tempitr);
				tempitr.next();
				itr.next();
				this.remove(itrremove);
			}else itr.next();
		}
		itr.next();
		while(itr.currentNode.data != null) {
			System.out.println(itr.currentNode.data);
			itr.next();
		}
		this.insertList(header, temp);
	}

}
