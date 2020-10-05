package no.hvl.dat110.rest.todo;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.put;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
	
	static Todo todo = null;
	
	public static void main(String[] args) {

		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}

		todo = new Todo();
		
		after((req, res) -> {
  		  res.type("application/json");
  		});
		
		get("/hello", (req, res) -> "Hello World!");
		
        get("/todos", (req, res) -> todo.toJson());
               
        put("/todos", (req,res) -> {
        
        	Gson gson = new Gson();
        	
        	todo = gson.fromJson(req.body(), Todo.class);
        
            return todo.toJson();
        	
        });
    }
    
}
