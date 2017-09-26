package com.bigdata2017.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/uploads";
	private static String PREFIX_URL = "/uploads/images/";
	
	public String restore(MultipartFile multipartFile) {
		System.out.println("restore");
		String url = "";
		
		try {
			String originalFileName = multipartFile.getOriginalFilename();
			String extName = (String) originalFileName.subSequence( originalFileName.lastIndexOf('.'), originalFileName.length() );
			Long size = multipartFile.getSize();
			String saveFileName = genSaveFileName( extName );
			
			
			System.out.println("#####"+originalFileName);
			System.out.println("extname : "+extName);
			System.out.println("size : "+size);
			System.out.println("save file name : "+saveFileName);
			
			writeFile( multipartFile, saveFileName );
			
			url = PREFIX_URL + saveFileName;
			System.out.println("url : " + url);
		} catch( IOException ex ) { 
			throw new RuntimeException( ex ) ;
		}
		return url;
	}
	
	
	private String genSaveFileName( String extName ) {
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get( Calendar.YEAR);
		fileName += calendar.get( Calendar.MONTH+1);
		fileName += calendar.get( Calendar.DATE);
		fileName += calendar.get( Calendar.HOUR);
		fileName += calendar.get( Calendar.MINUTE);
		fileName += calendar.get( Calendar.SECOND);
		fileName += calendar.get( Calendar.MILLISECOND);
		fileName += "_Download"+extName;
		
		
		return fileName;
	}
	
	private void writeFile( 
			MultipartFile multipartFile,
			String saveFileName ) throws IOException {
		
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream( SAVE_PATH+"/"+saveFileName);
		fos.write(fileData);
		fos.close();
	}

}
