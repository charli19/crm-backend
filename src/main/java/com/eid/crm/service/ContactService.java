package com.eid.crm.service;

import com.eid.crm.model.Contact;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {
    Page<Contact> getContacts(Integer pageIndex, Integer pageSize);

    void saveContact(Contact contact);

    void deleteContact(Long contactId);

}
