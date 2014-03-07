package todo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import todo.data.Todo;

public class TodoServiceImpl implements TodoService {
	
	private List<Todo> todoList;
	
	public TodoServiceImpl(List<Todo> todoList) {
		super();
		this.todoList = todoList;
	}

	/* (non-Javadoc)
	 * @see todo.TodoService#addNewTodo(todo.Todo)
	 */
	@Override
	public void addNewTodo(Todo obj) {
		
		this.todoList.add(obj);
		
		System.out.println("DEBUG..............");
		System.out.println(this.todoList);
	}

	/* (non-Javadoc)
	 * @see todo.TodoService#findByTitle(java.lang.String)
	 */
	@Override
	public List<Todo> findByTitle(String keyword) {

		List<Todo> resultList = new ArrayList<Todo>();
		
		for (Todo todo : todoList) {			
			if(todo.matchByTitle(keyword)){
				resultList.add(todo);
			}			
		}
		
		return resultList;
	}

	/* (non-Javadoc)
	 * @see todo.TodoService#removeTodo(java.lang.String)
	 */
	@Override
	public int removeTodo(String keyword) {
		
		Todo temp = new Todo();
		temp.setTitle(keyword);
		
		boolean result = this.todoList.remove(temp);
		
		return result?1:0;
	}

	/* (non-Javadoc)
	 * @see todo.TodoService#getList(java.lang.String)
	 */
	@Override
	public List<Todo> getList(String oper) {
		
		if(oper.equals("2")){
			Collections.sort(this.todoList);		
		}		
		return this.todoList;
	}

}

















































