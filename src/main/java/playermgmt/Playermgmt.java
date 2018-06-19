package playermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Playermgmt {

	public static void main(String[] args) {
		// Port number as argument, if not specified uses 8080
		if (args.length == 1) {
			System.getProperties().put("server.port", args);
		}else{
			System.getProperties().put("server.port", 2222);
		}
		SpringApplication.run(Playermgmt.class, args);
    }
}
