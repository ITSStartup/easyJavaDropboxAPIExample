package com.its.dropbox;

import java.util.List;

import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.its.easyjavadropbox.api.impl.EasyJavaDropBoxService;

public class DropboxMain {

	public static void main(String[] args) throws DbxException {
		String token = "Put your token here";
		String path = "/";
		EasyJavaDropBoxService easyJavaDropBoxService = new EasyJavaDropBoxService(path, token);
		
		List<DbxEntry> listFiles = easyJavaDropBoxService.listFiles();
		for (DbxEntry file : listFiles) {
			System.out.println(file.name);
		}
	}

}
