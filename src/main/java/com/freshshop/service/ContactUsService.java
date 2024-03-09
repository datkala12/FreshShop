package com.freshshop.service;

import com.freshshop.constant.FreshShopConstants;
import com.freshshop.model.ContactUs;
import com.freshshop.model.Report;
import com.freshshop.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactUsService {
	@Autowired
	private ContactUsRepository contactUsRepository;

	public boolean saveMsgDetail(ContactUs contactUs) {
		boolean isSaved = false;

		contactUs.setStatus(FreshShopConstants.OPEN);
		contactUs.setCreatedBy(FreshShopConstants.ANONYMOUS); // ---- > Handling by AuditorListener
		contactUs.setCreatedAt(LocalDateTime.now());
		ContactUs savedContact = contactUsRepository.save(contactUs);
		if (savedContact != null && savedContact.getContactId() > 0) {
			isSaved = true;
		}
		return isSaved;
	}

	public Page<ContactUs> findsMessagesWithOpenStatus(int pageNum, String sortField, String sortDir) {
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		Page<ContactUs> msgPageOpen = contactUsRepository.getByStatus(FreshShopConstants.OPEN, pageable);

		return msgPageOpen;
	}

	public Page<ContactUs> findsMessagesWithOpenStatusAndName(int pageNum, String sortField, String sortDir,
			String name) {
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		Page<ContactUs> msgPageOpen = contactUsRepository.getByStatusAndName(FreshShopConstants.OPEN, name, pageable);

		return msgPageOpen;
	}

	public Page<ContactUs> findsMessagesWithCloseStatus(int pageNum, String sortField, String sortDir) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		Page<ContactUs> msgPageClose = contactUsRepository.getByStatus(FreshShopConstants.CLOSE, pageable);

		return msgPageClose;
	}

	public boolean updateMsgStatus(int contactUsId, String status) {
		boolean isUpdated = false;
		int result = contactUsRepository.updateByStatus(status, contactUsId);
		if (result > 0) {
			isUpdated = true;
		}
		return isUpdated;
	}

	public Page<Report> getAllContactByCurrentMonth(int pageNumber) {
		int pageSize = 10;
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		Page<Report> page = contactUsRepository.getAllContactByCurrentMonth(pageable);
		return page;
	}
}
