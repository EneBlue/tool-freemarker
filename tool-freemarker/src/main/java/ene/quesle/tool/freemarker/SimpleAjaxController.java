package ene.quesle.tool.freemarker;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ene.quesle.tool.freemarker.utils.FreemarkerUtil;
import freemarker.template.TemplateException;

@RestController
public class SimpleAjaxController {

	@RequestMapping("/simple/name")
	public String simpleMarker(String name){
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("no", Math.random());
		params.put("createTime", new Date());
		try {
			String message = FreemarkerUtil.covert(Constants.PATH_FM, "simple.ftl", params);
			return message;
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "";
	}
}
