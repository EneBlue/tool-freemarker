package ene.quesle.tool.freemarker;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.junit.Test;

public class ReadFileFromDirectoryTest {

	@Test
	public void test(){
		File dir=new File(Constants.PATH_FM);
		File[] files = FileUtils.convertFileCollectionToFileArray(FileUtils
		                .listFiles(dir, new IOFileFilter() {
		                    public boolean accept(File file) {
		                        return accept(file, "");
		                    }
		                    public boolean accept(File file, String s) {
		                        return file.isDirectory();
		                    }
		                }, new IOFileFilter() {
		                    public boolean accept(File file, String s) {
		                        return true;
		                    }
		                    public boolean accept(File file) {
		                        return true;
		                    }
		                }));
		System.out.println(files.length);
	}
}
