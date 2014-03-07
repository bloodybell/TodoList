package todo.jobs;

import java.util.Scanner;

import todo.data.Todo;
import todo.service.TodoService;

public class CreateUIJob extends AbstractJob {

	public CreateUIJob(TodoService service, Scanner scanner) {
		super(service, scanner);
		this.classFunctions = "todo 등록 작업.";
		this.menuNumber = 1;
	}

	@Override
	public void doJob() {

		System.out.println("새로운 할일을 작성합니다.");

		System.out.println("제목 작성합니다.");
		String title = scanner.nextLine();

		System.out.println("내용을 작성합니다.");
		String desc = scanner.nextLine();

		Todo obj = new Todo();
		obj.setTitle(title);
		obj.setDesc(desc);

		System.out.println(obj);
		service.addNewTodo(obj);

	}

}
