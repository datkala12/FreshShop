package com.freshshop.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

@Service
public class FileUploadService {
	@Autowired
	private Cloudinary cloudinary;

	public String uploadFile(MultipartFile multipartFile) throws IOException {
		return cloudinary.uploader()
				.upload(multipartFile.getBytes(), Map.of("public_id", multipartFile.getOriginalFilename().toString()))
				.get("url").toString();

	}
}
