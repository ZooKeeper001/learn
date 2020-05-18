package com.alibaba.study.files;

import com.alibaba.study.io.input.UserInput;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/13 9:51
 */
public class FilesTest {

    public static void main(String[] args) throws Exception{
        Path path1 = Paths.get("F:\\abc.txt");
        Path path5 = Paths.get("F:\\abc\\abc.txt");
        Path path6 = Paths.get("F:\\ab\\abc.txt");
        Path path2 = Paths.get("F:\\ab.txt");
        Path path3 = Paths.get("F:\\abc");
        Path path4 = Paths.get("F:\\b.txt");
        // 验证文件路径是否存在
        System.out.println(Files.exists(path1));
        // 创建文件
        Files.createFile(path2);
        // 创建文件夹
        //Files.createDirectories(path3);
        // 删除一个文件或者目录
        // Files.delete(path4);
        // 复制文件
        //Files.copy(path1,path5);
        // 移动文件
        //Files.move(path5,path6);
        // 查看文件包含的字节数
        //System.out.println(Files.size(path1));
        //test1();
        //test2();
        //test3 ();
       /* test4();
        Set<UserInput> set = new TreeSet<>();
        UserInput input = new UserInput();
        UserInput input1 = new UserInput();
        UserInput input2 = new UserInput();
        input.setName("3");
        input2.setName("1");
        input1.setName("2");
        set.add(input);
        set.add(input2);
        set.add(input1);
        set.forEach(
                t -> System.out.println(t.toString())
        );*/


    }

    public static void test1 () {

        File file = new File("F:\\a.txt");
        System.out.println(file.toURI());
        Path path = file.toPath();
        Path path2 = Paths.get("F:", "abc", "Topic.txt");
        System.out.println(path);
        File file1 = path2.toFile();
        System.out.println(file1.getName());

    }

    public static void test2 () {
        Path path = Paths.get(".");
        //D:\project\learn\.
        System.out.println(path.toAbsolutePath());

    }

    public static void test3 () throws Exception{
        // 获取文件的属性
        Path path = Paths.get("F:\\abc.txt");
        System.out.println(Files.getLastModifiedTime(path));
        System.out.println(Files.size(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.readAttributes(path, "*"));
    }

    /**
     * 遍历一个文件夹
     */
    public static void test4 () {
        Path dir = Paths.get("F:\\abc");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            for(Path e : stream){
                System.out.println(e.getFileName());
            }
        }catch(IOException e){

        }
    }
}
