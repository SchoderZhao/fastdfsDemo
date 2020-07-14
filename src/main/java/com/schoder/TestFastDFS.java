package com.schoder;

import org.csource.fastdfs.*;

import java.io.FileInputStream;


public class TestFastDFS {
    public static void main(String[]args){
    //1,声明对象
        TrackerClient trackerClient  = null;
        TrackerServer trackerServer = null;
        StorageClient storageClient = null;
        StorageServer storageServer = null;
        String path =TestFastDFS. class.getResource("/").getPath();
       try{
           System.out.println(path);
           ClientGlobal.init(path+"client.conf");
           trackerClient = new TrackerClient();
           trackerServer = trackerClient.getConnection();
          // System.out.println(trackerClient+"--"+trackerServer);

           storageClient = new StorageClient(trackerServer,storageServer);
           //System.out.println(storageClient);

           FileInputStream fileInputStream = new FileInputStream(path+"006HfagUgy1fwotzpztioj30rs0rsjuk.jpg");

           int len = fileInputStream.available();

           byte [] b = new byte[fileInputStream.available()];
           //int len = -1;
           fileInputStream.read(b,0,fileInputStream.available());
          // System.out.println(fileInputStream.available());
          String s[] = storageClient.upload_file(b,0,len,"jpg",null);

           for (String s1 : s) {
               System.out.println(s1);
           }



       }catch(Exception e){
           e.printStackTrace();
       }




    }
}
