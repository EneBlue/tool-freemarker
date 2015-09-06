package ene.quesle.tool.freemarker;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ene.quesle.tool.freemarker.utils.FileUtil;

@Controller
public class SimpleController {

	@RequestMapping("/simple")
	public String showSimpleView(Model model, HttpServletRequest request){
		
		String marker = FileUtil.readFileAsString(Constants.PATH_FM, "simple.ftl");
		model.addAttribute("marker", marker);
		
		return "simple";
	}
	
}
