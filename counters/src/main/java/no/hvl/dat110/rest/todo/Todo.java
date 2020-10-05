package no.hvl.dat110.rest.todo;

import com.google.gson.Gson;

public class Todo {
	
	private Long id;
	private String description;
	private String summary;

	public Todo () {
		this.description = "This is default description";
		this.summary = "This is default summary";
	}

	public Todo (String description, String summary) {
		this.description = description;
		this.summary = summary;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	String toJson () {
    	
    	Gson gson = new Gson();
    	    
    	String jsonInString = gson.toJson(this);
    	
    	return jsonInString;
    }
}
