package ene.quesle.tool.freemarker;

import java.io.File;

/**
 * @author Quesle
 * @Email  zrwuxian@126.com
 * @date   2015年8月19日 下午5:52:20 
 * @version 1.0 
 */
public class Constants {

	/**
	 * 获取文件的路径， 去掉classes
	 */
	private static String PATH_WEB_INF_NO = Thread.currentThread().getContextClassLoader().getResource("").getPath()
			.replace("classes", "");
	
	/**
	 * 获取WEB-INF路径
	 */
	public static final String PATH_WEB_INF = PATH_WEB_INF_NO.substring(0, PATH_WEB_INF_NO.length() - 1);
	
	/**
	 * 获取模板的路径
	 */
	public static final String PATH_FM = PATH_WEB_INF + "fm";
	
	
	/**
	 * 获取简单实例的模板路径
	 */
	public static final String PATH_FM_SIMPEL = PATH_FM + File.separator + "simple";
}
