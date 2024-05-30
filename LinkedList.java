package package2;

class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	// Insert a node at a specified position
	public void insertAtPos(int data, int position) {
		Node newNode = new Node(data);
		if (position == 1) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node current = head;
		for (int i = 1; i < position - 1 && current != null; i++) {
			current = current.next;
		}
		if (current == null) {
			System.out.println("The position is out of range.");
			return;
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	// Delete a node at a specified position
	public void deleteAtPosition(int position) {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}
		if (position == 1) {
			head = head.next;
			return;
		}
		Node current = head;
		for (int i = 1; i < position - 1 && current != null; i++) {
			current = current.next;
		}
		if (current == null || current.next == null) {
			System.out.println("The position is out of range.");
			return;
		}
		current.next = current.next.next;
	}

	// Delete a node after a given node
	public void deleteAfterNode(Node node) {
		if (node == null || node.next == null) {
			System.out.println("There is no node to delete after the given node.");
			return;
		}
		node.next = node.next.next;
	}

	// Search for a node with a specific value
	public boolean searchNode(int data) {
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Display the linked list
	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public Node getHead() {
		return head;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.insertAtPos(10, 1);
		list.insertAtPos(20, 2);
		list.insertAtPos(30, 3);
		list.insertAtPos(40, 2);

		System.out.println("Linked List after insertion:");
		list.display();

		list.deleteAtPosition(3);
		System.out.println("Linked List after deletion at position 3:");
		list.display();

		Node node = list.getHead().next; // node with value 40
		list.deleteAfterNode(node);
		System.out.println("Linked List after deleting node after 40:");
		list.display();

		System.out.println("Searching for node with value 20: " + list.searchNode(20));
		System.out.println("Searching for node with value 40: " + list.searchNode(40));
	}
}
