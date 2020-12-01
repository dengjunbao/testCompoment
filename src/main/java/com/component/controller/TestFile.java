package com.component.controller;
import com.component.entity.TestPicture;
import com.component.test.dao.TestPictureDao;
import com.component.test.entity.TestPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestFile{
    @Autowired
    TestPictureDao testPictureDao;

    public TestFile(){
        m();
    }

    public void m (){
        System.out.println("the m() method is run!");
    }

    @RequestMapping(value = "/hello")
    public String Hello(){
        return "Hello,word";
    }
    @PostMapping(value = "/picture")
    public String TestPicture(@RequestParam("file") MultipartFile[] file) throws IOException {
        TestPicture testPicture = new TestPicture();
        for (MultipartFile formfile :file){
            byte[] byteFile = formfile.getBytes();
            testPicture.setBytesPicture(byteFile);
            testPictureDao.save(testPicture);
        }
        return "上传成功";
    }


    @GetMapping(value = "/getPicture/{assetId}")
    public byte[] TestPicture(@PathVariable("assetId") Long assetId,HttpServletRequest request) throws IOException {

        List<TestPicture> listPicture = testPictureDao.findByAssetId(assetId);
        byte[] i = listPicture.get(0).getBytesPicture();
       /* List<TestPicture> listPicture = testPictureDao.findByAssetId(assetId);
        String path = request.getServletContext().getRealPath("\\img");
        String fileName = "TestPicture.jpg";
        List<File> listFiles = null;
        BufferedOutputStream stream = null;
        FileOutputStream fstream = null;
        BufferedInputStream BIstream = null;
        FileInputStream Ifstream = null;
        File file = new File(path);
        for (TestPicture testPicture : listPicture){
            byte[] byteData=testPicture.getBytesPicture();
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            File fileData = new File(path+File.separator+fileName);
            try {
                fstream = new FileOutputStream(fileData);
                stream = new BufferedOutputStream(fstream);
                stream.write(byteData);
                Ifstream = new FileInputStream(new File(fileData.getPath()));
                BIstream = new BufferedInputStream(Ifstream);
                listFiles.add(fileData);
                fileData.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            if (stream != null) {
                stream.close();
            }
            if (null != fstream) {
                fstream.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/

        return i;
    }



}
