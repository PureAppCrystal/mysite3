package com.bigdata2017.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bigdata2017.mysite.service.FileUploadService;
import com.bigdata2017.mysite.service.GalleryService;
import com.bigdata2017.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("")
	public String index( Model model ) {
		
		List<GalleryVo> list = galleryService.getMessageList();
		System.out.println("list size : "+list.size());
		
		
		model.addAttribute("list", list);
		
		return "gallery/index";
	}
	
	
	
	@RequestMapping("/upload")
	public String upload(
			@RequestParam( "comments" ) String comments,
			@RequestParam( "file" ) MultipartFile file,
			Model model) {
		
		
		String url = fileUploadService.restore(file);
		
		GalleryVo vo = new GalleryVo();
		vo.setComments(comments);
		vo.setImageUrl(url);
		
		galleryService.uploadMessage(vo);
		
		return "redirect:/gallery";
	}
}
