package todo.service;

import java.util.List;

import todo.data.Todo;

public interface TodoService {

	public abstract void addNewTodo(Todo obj);

	public abstract int removeTodo(String keyword);

	public abstract List<Todo> findByTitle(String keyword);

	public abstract List<Todo> getList(String oper);

}
