package com.schoder.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;


public class FastDFSClient {
	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageClient storageClient = null;
	private StorageServer storageServer = null;
	public FastDFSClient(String conf) throws Exception{
		String path = this.getClass().getResource("/").getPath();
		ClientGlobal.init(path+conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageClient = new StorageClient(trackerServer,storageServer);
	}
	/**
	 *上传文件
	 * @param fileName 文件全路径
	 * @param extName  文件扩展名,不包含(.)
	 * @param metas 文件扩展信息
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public String[] uploadFile(String fileName,String extName,NameValuePair[] metas) throws IOException, MyException {
		String[] strings = storageClient.upload_file(fileName, extName, metas);
		return strings;
	}

	public String[] uploadFile(String fileName,String extName) throws IOException, MyException {
		String[] strings = storageClient.upload_file(fileName, extName, null);
		return strings;
	}

	public String[] uploadFile(String fileName) throws IOException, MyException {
		String[] strings = storageClient.upload_file(fileName, null, null);
		return strings;
	}
	/**
	 *
	 * @param fileContent 文件的内容，字节数组
	 * @param extName
	 * @param metas
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public String[] uploadFile(byte[] fileContent,String extName,NameValuePair[] metas) throws IOException, MyException {
		String[] strings = storageClient.upload_file(fileContent, extName, metas);
		return strings;
	}

	public String[] uploadFile(byte[] fileContent,String extName )throws IOException, MyException {
		String[] strings = storageClient.upload_file(fileContent, extName, null);
		return strings;
	}

	public String[] uploadFile(byte[] fileContent) throws IOException, MyException {
		String[] strings = storageClient.upload_file(fileContent, null, null);
		return strings;
	}


}
