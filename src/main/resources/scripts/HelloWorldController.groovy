import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groovy")
public class HelloWorldController {
	
	
	@RequestMapping("/test2")
	public Map<String,String> test(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "zhaiyuyong");
		map.put("age", "12");
		return map;
	}
	
	
}