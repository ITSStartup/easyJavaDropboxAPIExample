package com.its.dropbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.its.easyjavadropbox.api.impl.EasyJavaDropBoxServiceImpl;
import com.its.easyjavadropbox.api.interfaces.EasyJavaDropBoxService;

public class DropboxMain {

	public static void main(String[] args) throws DbxException, IOException {
		String token = "DpFkOmSumk0AAAAAAAAAAZHqHcBow3Zb9pSAQhv22FACorQHqBKsMIK4qBd_zBdA";
		String path = "/";
		EasyJavaDropBoxService easyJavaDropBoxService = new EasyJavaDropBoxServiceImpl(path, token);
		
		List<DbxEntry> listFiles = easyJavaDropBoxService.listFiles();
		for (DbxEntry file : listFiles) {
			System.out.println(file.name);
		}
		//upload service
		 EasyJavaDropBoxServiceImpl upload = new EasyJavaDropBoxServiceImpl(token);
		 //saveToDropbox(upload);
		 
		 renameFileFromRoot(easyJavaDropBoxService);
		
		 renameFile(easyJavaDropBoxService);
		
	}

	private static void saveToDropbox(EasyJavaDropBoxService uploadEasyJavaDropBoxService) throws DbxException, IOException {
		//creating new file
		File file = new File("camilotestedropbox2.txt");
		file.createNewFile();
		//writing content in file
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("Test upload to dropbox  api");
		fileWriter.close();
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			 String fileName = file.toString();
			 //calling method from easyJavaDropboxAPI
			uploadEasyJavaDropBoxService.saveToDropbox(fileName, fileInputStream);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void renameFile(EasyJavaDropBoxService easyJavaDropBoxService)
			throws DbxException {
		easyJavaDropBoxService.renameFile("/teste/","myfile.png", "renameok.png");
	}

	private static void renameFileFromRoot(EasyJavaDropBoxService easyJavaDropBoxService)
			throws DbxException {
		String newNameFile = "testelocal.png ";
		String currentNameFile = "alertfytestelocal.png";
		easyJavaDropBoxService.renameFileRoot(currentNameFile ,newNameFile);
	}

}
