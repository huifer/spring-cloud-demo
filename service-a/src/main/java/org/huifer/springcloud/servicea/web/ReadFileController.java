package org.huifer.springcloud.servicea.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@RestController
@RequestMapping("/file")

public class ReadFileController {

    public static String txt2String(String pathName) {
        File file = new File(pathName);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @GetMapping("/ca")
    public String s() {
        return txt2String("G:\\sourcehot\\base_web\\src\\main\\resources\\中国.json");
    }

}
