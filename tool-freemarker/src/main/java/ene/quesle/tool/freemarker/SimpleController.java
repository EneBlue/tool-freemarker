package ene.quesle.tool.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ene.quesle.tool.freemarker.utils.FileUtil;

@Controller
public class SimpleController {

	@RequestMapping("/simple")
	public String showSimpleView(Model model){
		
		String marker = FileUtil.readFileAsString(Constants.PATH_FM, "simple.ftl");
		System.out.println(marker);
		model.addAttribute("marker", marker);
		
		return "simple";
	}
	
}
