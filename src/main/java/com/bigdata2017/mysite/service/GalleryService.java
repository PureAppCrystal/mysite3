package com.bigdata2017.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata2017.mysite.repository.GalleryDao;
import com.bigdata2017.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	@Autowired
	private GalleryDao galleryDao;
	
	
	public List<GalleryVo> getMessageList() {
		List<GalleryVo> list = galleryDao.getList();
		return list;
	}
	
	
	public boolean uploadMessage( GalleryVo vo) {
		int count = galleryDao.insert(vo);
		return count==1 ;
	}
}
