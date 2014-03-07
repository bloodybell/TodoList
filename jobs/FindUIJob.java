package todo.jobs;

import java.util.List;
import java.util.Scanner;

import todo.data.Todo;
import todo.service.TodoService;

public class FindUIJob extends AbstractJob {

	public FindUIJob(TodoService service, Scanner scanner) {
		super(service, scanner);
		this.classFunctions = "제목으로 검색하기.";
		this.menuNumber = 3;
	}

	@Override
	public void doJob() {

		System.out.println("검색할 제목을 입력하세요");
		String keyword = scanner.nextLine();

		List<Todo> target = service.findByTitle(keyword);

		for (Todo todo : target) {
			System.out.println(todo);
		}

	}

}
