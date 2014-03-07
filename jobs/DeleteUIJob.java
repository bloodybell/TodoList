package todo.jobs;

import java.util.Scanner;

import todo.service.TodoService;

public class DeleteUIJob extends AbstractJob {

	public DeleteUIJob(TodoService service, Scanner scanner) {
		super(service, scanner);
		this.classFunctions = "제목으로 삭제하기.";
		this.menuNumber = 2;
	}

	@Override
	public void doJob() {
		System.out.println("삭제할 제목을 입력하세요");
		String keyword = scanner.nextLine();

		int count = service.removeTodo(keyword);

		System.out.println(count + " 건 삭제 되었습니다.");

	}

}
