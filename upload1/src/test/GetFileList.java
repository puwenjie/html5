package test;

import java.io.File;

public class GetFileList {

	/**
	 * 功能：获取文件夹列表的函数
	 * 时间：2016年11月14日
	 * @author pu
	 */
//    public static void main(String[] args) {
//        getFileName("d/jexo");
	     
//    }

    public  void getFileName(String path) {
    	
    	System.out.print(path+"这是路径");
        //"../upload"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                System.out.println(fs.getName());
            }
        }
    }
}
