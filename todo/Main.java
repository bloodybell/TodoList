package todo;

import java.util.ArrayList;
import java.util.Scanner;

import todo.data.Todo;
import todo.service.TodoService;
import todo.service.TodoServiceImpl;
import todo.ui.TodoUI;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		TodoService service = new TodoServiceImpl(new ArrayList<Todo>());

		TodoUI ui = new TodoUI(scanner, service);

		 ui.oper();

	}
}
