package com.eid.crm.service.impl;

import com.eid.crm.model.Contact;
import com.eid.crm.repository.ContactRepository;
import com.eid.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Contact> getContacts(Integer pageIndex, Integer pageSize) {
        Pageable pageable =
                PageRequest.of(pageIndex, pageSize);
        return contactRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id " + contactId));

        contactRepository.delete(contact);
    }
}