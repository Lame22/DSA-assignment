package package_1;

public class ToDoList_1 {
	private Node_1 head;

	public ToDoList_1() {
		this.head = null;
	}

	public void addToDo(Task_1 task) {
		Node_1 newNode = new Node_1(task);
		if (head == null) {
			head = newNode;
		} else {
			Node_1 current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void markToDoAsCompleted(String title) {
		Node_1 current = head;
		while (current != null) {
			if (current.task.getTitle().equals(title)) {
				current.task.markCompleted();
				return;
			}
			current = current.next;
		}
		System.out.println("Task not found: " + title);
	}

	public void viewToDoList() {
		Node_1 current = head;
		if (current == null) {
			System.out.println("The to-do list is empty.");
			return;
		}

		while (current != null) {
			System.out.println("Title: " + current.task.getTitle());
			System.out.println("Description: " + current.task.getDescription());
			System.out.println("Completed: " + (current.task.isCompleted() ? "Yes" : "No"));
			System.out.println();
			current = current.next;
		}
	}

	public static void main(String[] args) {
		ToDoList_1 toDoList = new ToDoList_1();

		Task_1 task1 = new Task_1("Buy groceries", "Milk, Bread, Cheese, Eggs");
		Task_1 task2 = new Task_1("Doctor's appointment", "Annual check-up at 10 AM");
		Task_1 task3 = new Task_1("Finish project report", "Complete the financial analysis section");
		Task_1 task4 = new Task_1("Call plumber", "Fix the leaking kitchen sink");
		Task_1 task5 = new Task_1("Read book", "Read 30 pages of 'The Alchemist'");

		toDoList.addToDo(task1);
		toDoList.addToDo(task2);
		toDoList.addToDo(task3);
		toDoList.addToDo(task4);
		toDoList.addToDo(task5);

		System.out.println("To-Do List:");
		toDoList.viewToDoList();

		System.out.println("Marking 'Finish project report' as completed.");
		toDoList.markToDoAsCompleted("Finish project report");

		System.out.println("Marking 'Call plumber' as completed.");
		toDoList.markToDoAsCompleted("Call plumber");

		System.out.println("To-Do List:");
		toDoList.viewToDoList();
	}
}

