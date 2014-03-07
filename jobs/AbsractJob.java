package todo.jobs;

import java.util.Scanner;

import todo.service.TodoService;

public abstract class AbstractJob implements UiJob {
	protected TodoService service;
	protected Scanner scanner;
	
//	protected String className;
	protected String classFunctions;
	protected int menuNumber;


	protected AbstractJob(TodoService service, Scanner scanner) {
		this.service = service;
		this.scanner = scanner;

//		this.className = this.getClass().getName().replace("todo.jobs.", "").replace("UIJob", "").toLowerCase();

	}
	
	@Override
	public void doJob() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printMenuItem() {
		System.out.println(menuNumber + ". " + classFunctions);
	}
	
	public int getMenuNumber() {
		return menuNumber;
	}
}
