package todo.jobs;

import java.util.List;
import java.util.Scanner;

import todo.data.Todo;
import todo.service.TodoService;

public class ListUIJob extends AbstractJob {

	public ListUIJob(TodoService service, Scanner scanner) {
		super(service, scanner);
		this.classFunctions = "리스트 보기.";
		this.menuNumber = 4;
	}

	@Override
	public void doJob() {
		System.out.println("1.등록 순서, 2. 제목 순서");

		String oper = scanner.nextLine();

		List<Todo> list = service.getList(oper);

		for (Todo todo : list) {
			System.out.println(todo);
		}

	}

}
