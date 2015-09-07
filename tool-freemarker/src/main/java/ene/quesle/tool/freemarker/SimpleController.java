package ene.quesle.tool.freemarker;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ene.quesle.tool.freemarker.utils.FileUtil;

/**
 * Simple实例的请求处理Controller
 * @author Quesle
 * @Email  zrwuxian@126.com
 * @date   2015-9-7 15:31:19 
 * @version 1.0 
 */
@Controller
public class SimpleController {
	
	
	/**
	 * 获取simple页面请求处理
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/simple")
	public String showSimpleView(Model model, HttpServletRequest request){
		
		try {
			// 获取基本的模板
			String marker = FileUtil.readFileToString(Constants.PATH_FM_SIMPEL, "simple.ftl");
			// 获取simple类型的模板文件
			List<String> nemes = FileUtil.readFileFromDirectory(Constants.PATH_FM_SIMPEL);
			model.addAttribute("marker", marker);
			model.addAttribute("names", nemes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "simple";
	}
	
	/**
	 * 显示创建Simple模板的页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/create")
	public String showCreateView(Model model, HttpServletRequest request){
		return "create";
	}
	
	/**
	 * 处理创建Simple模板的请求的处理
	 * @param title
	 * @param marker
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/create_marker", method=RequestMethod.POST)
	public String createMarkerForm(String title, String marker, Model model) throws IOException{
		
		//判断模板的标题和类容是否为空
		if(StringUtils.isBlank(title) || StringUtils.isBlank(marker)){
			model.addAttribute("title", title);
			model.addAttribute("marker", marker);
			
			model.addAttribute("error", "内容不全");
			
			return "create";
		}
		
		//编写模板文件，保存到目录中去
		FileUtil.writeStringToFile(Constants.PATH_FM_SIMPEL,  title + ".ftl", marker);
		
		//返回到模板使用页面上
		return "redirect:/simple";
	}
	
}
