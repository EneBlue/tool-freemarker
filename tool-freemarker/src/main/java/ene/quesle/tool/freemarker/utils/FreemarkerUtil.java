package ene.quesle.tool.freemarker.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Freemarker的工具
 * @author Quesle
 * @Email  zrwuxian@126.com
 * @date   2015年8月19日 下午5:57:55 
 * @version 1.0 
 */
public class FreemarkerUtil {

	/**
	 * 通过模板和模板参数，生成模板HTML的字符串
	 * @param path  模板所在的路径
	 * @param name  模板的名称
	 * @param params  模板参数的值
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static String covert(String path, String name, Map<String, Object> params) throws TemplateException, IOException{
		File file = new File(path, name);
		return execute(file, params);
	}
	
	/**
	 * 通过模板和模板参数，生成模板HTML的字符串
	 * @param ftlFile  模板的File对象
	 * @param params  模板参数的值
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static String execute(File ftlFile, Map<String, Object> data)
			throws TemplateException, IOException {
		StringWriter sw = new StringWriter();
		Template template = createTemplate(ftlFile);
		template.process(data, sw);
		return sw.toString();
	}
	
	/**
	 * 生成模板独享，用来处理模板文件和参数
	 * @param ftlFile
	 * @return
	 * @throws IOException
	 */
	private static Template createTemplate(File ftlFile) throws IOException {
		Configuration cfg = new Configuration();
		//File parentFile = ftlFile.getParentFile();
		// 加载freemarker模板文件
		cfg.setDirectoryForTemplateLoading(ftlFile.getParentFile());
		cfg.setClassicCompatible(true);
		cfg.setDateFormat("yyyy-MM-dd");
		cfg.setNumberFormat("");
		cfg.setDefaultEncoding("utf-8");
		// 设置对象包装器
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		// 设计异常处理器
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

		// 获取指定模板文件
		Template template = cfg.getTemplate(ftlFile.getName());

		return template;
	}
}
