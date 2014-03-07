package todo.ui;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import todo.jobs.UiJob;
import todo.service.TodoService;

public class TodoUI {

	Scanner scanner;
	TodoService service;
	ArrayList<Integer> menuNumbers;
	Map<Integer, UiJob> jobMap;

	public TodoUI(Scanner scanner, TodoService service) {
		super();
		this.scanner = scanner;
		this.service = service;
		this.menuNumbers = new ArrayList<Integer>();
		this.jobMap = new HashMap<Integer, UiJob>();
		
		addFunctions();

	}

	private void addFunctions() {
		// 클래스가 저장된 폴더를 탐색해서 클래스 목록을 가져온다.
		String[] fileList = (new File("src/todo/jobs/")).list();

		Class[] arguments = { TodoService.class, Scanner.class };
		Class<?> searchingClass = null;
		Constructor<?> constructor = null;
		UiJob uiClass = null;

		// 기능을 추가한다.
		try {
			for (String str : fileList) {
				if (str.indexOf("UIJob") > 0) {
					// 클래스 이름으로 필요한 클래스를 동적 생성한다.
					searchingClass = Class.forName("todo.jobs." + str.replace(".java", ""));
					constructor = searchingClass.getConstructor(arguments);
	
					uiClass = (UiJob) constructor.newInstance(service, scanner);	// 클래스 생성
					
					menuNumbers.add(uiClass.getMenuNumber());	// index를 저장한다.
					
					jobMap.put(uiClass.getMenuNumber(), uiClass);	// 기능과 키워드를 연결한다.
				}

			}

		} catch (ClassNotFoundException | NoSuchMethodException e) {
			System.out.println("명령이 없습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void oper() {

		Collections.sort(menuNumbers);		// 정렬한다.
		for (Integer number : menuNumbers) {
			jobMap.get(number).printMenuItem();
		}

		int oper = Integer.parseInt(scanner.nextLine());

		jobMap.get(oper).doJob();

		oper();

	}

}
