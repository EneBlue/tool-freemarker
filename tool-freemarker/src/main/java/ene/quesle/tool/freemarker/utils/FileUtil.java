package ene.quesle.tool.freemarker.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 读取和写入文件的Util类
 * @author Quesle
 * @Email  zrwuxian@126.com
 * @date   2015-9-7 13:28:19 
 * @version 1.0 
 */
public class FileUtil {
	
	public static final String FILE_CHARSET = "utf-8";

	/**
	 * 通过文件路径和名称读取文件，转为字符串
	 * @param path  文件路径
	 * @param name  文件名称
	 * @return
	 * @throws IOException
	 */
	public static String readFileToString(String path, String name) throws IOException{
		File file = new File(path, name);
		return readFileToString(file);
	}
	
	/**
	 * 通过文件路径+名称读取文件，转为字符串
	 * @param filePath  文件全路径 + 名称
	 * @return
	 * @throws IOException
	 */
	public static String readFileToString(String filePath) throws IOException{
		File file = new File(filePath);
		return readFileToString(file);
	}
	
	/**
	 * 通过文件对象读取文件的信息
	 * @param file  文件对象
	 * @return
	 * @throws IOException
	 */
	public static String readFileToString(File file) throws IOException{
		
		return FileUtils.readFileToString(file, FILE_CHARSET);
	}
	
	/**
	 * 将字符串写入到文件中，文件的路径为path，文件名的名称为name
	 * @param path   写入的文件路径
	 * @param name   写入的文件名称
	 * @param content   写入的文件类容
	 * @throws IOException
	 */
	public static void writeStringToFile(String path, String name, String content) throws IOException{
		File file = new File(path, name);
		writeStringToFile(file, content);
	}
	
	/**
	 * 将字符串写入到文件中，文件全路径+名称
	 * @param filePath   写入的文件路径 + 名称
	 * @param content   写入的文件类容
	 * @throws IOException
	 */
	public static void writeStringToFile(String filePath, String content) throws IOException{
		File file = new File(filePath);
		writeStringToFile(file, content);
	}
	
	/**
	 * 将字符串写入到文件中，通过file文件路径写入
	 * @param file   写入的文件路径 + 名称
	 * @param content   写入的文件类容
	 * @throws IOException
	 */
	public static void writeStringToFile(File file, String content) throws IOException{
		FileUtils.writeStringToFile(file, content, FILE_CHARSET);
	}
	
	public static List<String> readFileFromDirectory(String path){
		File dir = new File(path);
		File[] files = FileUtils.convertFileCollectionToFileArray(FileUtils
                .listFiles(dir, new IOFileFilter() {
                	
                	@Override
                    public boolean accept(File file) {
                        return file.isFile();
                    }
                	
                	@Override
                    public boolean accept(File file, String s) {
                        return file.isDirectory();
                    }
                }, new IOFileFilter() {
                	
                	@Override
                    public boolean accept(File file, String s) {
                        return file.isDirectory();
                    }
                	
                	@Override
                    public boolean accept(File file) {
                        return file.isDirectory();
                    }
                }));
		
		return covertfilesToNames(files);
	}
	
	public static List<String> covertfilesToNames(File[] files){
		
		if(files == null){
			return null;
		}
		
		List<String> names = new ArrayList<String>();
		for (File file : files) {
			names.add(file.getName());
		}
		
		return names;
	}
}
