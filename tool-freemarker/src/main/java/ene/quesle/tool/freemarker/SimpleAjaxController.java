package ene.quesle.tool.freemarker;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ene.quesle.tool.freemarker.utils.FreemarkerUtil;
import freemarker.template.TemplateException;

/**
 * 处理简单模板的Ajax请求
 * @author Quesle
 * @Email  zrwuxian@126.com
 * @date   2015-9-7 15:31:19 
 * @version 1.0 
 */
@RestController
public class SimpleAjaxController {

	/**
	 * 通过传入的name值和模板的文件名，生成模板的HTML字符串返回到页面
	 * @param name    模板属性值name的值
	 * @param marker  模板文件名
	 * @return
	 */
	@RequestMapping("/simple/name")
	public String simpleMarker(String name, String marker){
		
		// 模板参数的设置
		Map<String, Object> params = new HashMap<String, Object>();
		// 设置名称，为页面传入的值
		params.put("name", name);
		// 随机生成的NO
		params.put("no", Math.random());
		
		// 当前的时间，生成模板的时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		params.put("createTime", format.format(new Date()));

		try {
			//生成模板的HTML字符串
			String message = FreemarkerUtil.covert(Constants.PATH_FM_SIMPEL, marker, params);
			return message;
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
