package com.nk;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {
    private  static FileSystem fs=null;
    //@BeforeAll注解标注的方法必须是static，在其它测试方法执行之前被调用
    @BeforeAll
    public static void init() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://node1:8020");
        System.setProperty("HADOOP_USER_NAME","root");
        fs=FileSystem.get(conf);
    }

    //将本地的文件上传到hdfs
    @Test
    void contextLoads() throws IOException {
        //源
        Path p1 = new Path("C:/Users/13219/Desktop/test.txt");
        //目的地
        Path p2 = new Path("/nksoftware");
        fs.copyFromLocalFile(p1,p2);
        fs.close();
    }

}
