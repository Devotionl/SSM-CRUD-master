//package com.linzhw.crud.test;
//
//import org.csource.fastdfs.*;
////上传文件成功
//public class Test {
//    public static void main(String[] args) throws Exception{
//        //1.加载配置文件
//        ClientGlobal.init("C:\\Users\\ll\\Desktop\\SSM-CRUD-master\\src\\main\\resources\\fdfs_client.conf");
//        //2.构建一个管理者客户端
//        TrackerClient client =  new TrackerClient();
//        //3.连接管理者服务端
//        TrackerServer server = client.getConnection();
//        //4.构建一个存储的服务端
//        StorageServer storageServer = null;
//        //5.获取存储服务器客户端对象
//        StorageClient storageClient = new StorageClient(server,storageServer);
//        //6.上传文件
//        String [] strings = storageClient.upload_file("e://123.png","png",null);
//        //7.显示上传结果
//        for (String str:strings){
//            System.out.println(str);
//        }
//    }
//}
