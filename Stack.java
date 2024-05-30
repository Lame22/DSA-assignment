package package2;

class Stack {
	private Node top;

	public Stack() {
		this.top = null;
	}

	// Push operation
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}

	// Pop operation
	public int pop() {
		if (top == null) {
			throw new IllegalStateException("Stack is empty.");
		}
		int data = top.data;
		top = top.next;
		return data;
	}

	// Peek operation
	public int peek() {
		if (top == null) {
			throw new IllegalStateException("Stack is empty.");
		}
		return top.data;
	}

	// Check if the stack is empty
	public boolean isEmpty() {
		return top == null;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("Top element is: " + stack.peek());
		System.out.println("Stack is empty: " + stack.isEmpty());

		System.out.println("Popped element is: " + stack.pop());
		System.out.println("Top element after pop is: " + stack.peek());
	}
}
