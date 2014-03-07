package todo.data;

public class Todo implements Comparable<Todo>{
	
	private String title;
	private String desc;

	public void setTitle(String title) {		
		this.title = title;
		
	}

	public void setDesc(String desc) {		
		this.desc = desc;		
	}

	@Override
	public String toString() {
		return "Todo [title=" + title + ", desc=" + desc + "]";
	}
	
	public boolean matchByTitle(String title){
		
		return this.title.contains(title);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(Todo other) {
		// TODO Auto-generated method stub
		return this.title.compareTo(other.title);
	}
	
	
	
}




















