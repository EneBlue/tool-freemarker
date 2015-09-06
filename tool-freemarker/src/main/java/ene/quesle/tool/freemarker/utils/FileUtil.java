package ene.quesle.tool.freemarker.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {

	public static String readFileAsString(String path, String name) {
		
		StringBuilder builder = new StringBuilder();
		try {
			File file = new File(path, name);
			InputStream is = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
	        String line = reader.readLine(); // 读取第一行
	        while (line != null) { // 如果 line 为空说明读完了
	        	builder.append(line); // 将读到的内容添加到 buffer 中
	        	builder.append("\n"); // 添加换行符
	            line = reader.readLine(); // 读取下一行
	        }
	        reader.close();
	        is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
}
