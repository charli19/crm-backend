package com.eid.crm.controller;

import com.eid.crm.model.Contact;
import com.eid.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Contact> getContacts(
            @RequestParam(value = "pageIndex", required = false, defaultValue = "0") Integer pageIndex,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize
    ) {
        return contactService.getContacts(pageIndex, pageSize);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);
    }

    @DeleteMapping(value = "/{contactId}")
    public void deleteContact(@PathVariable(value = "contactId") Long contactId) {
        contactService.deleteContact(contactId);
    }

}
