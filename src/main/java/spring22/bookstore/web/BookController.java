package spring22.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@RequestMapping("index")
	@ResponseBody
	public String something() {
		
		return "moi";
	}
	
}
