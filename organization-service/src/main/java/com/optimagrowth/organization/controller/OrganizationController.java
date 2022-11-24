package com.optimagrowth.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.optimagrowth.organization.model.Organization;
import com.optimagrowth.organization.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping(value="v1/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService service;

    @GetMapping
    public ResponseEntity<List<Organization>> getOrganizations() {
        return ResponseEntity.ok(service.findByAll());
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    public ResponseEntity<Organization> getOrganization( @PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(service.findById(organizationId));
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.PUT)
    public void updateOrganization( @PathVariable("organizationId") String id, @RequestBody Organization organization) {
        service.update(organization);
    }

    @PostMapping
    public ResponseEntity<Organization>  saveOrganization(@RequestBody Organization organization) {
    	return ResponseEntity.ok(service.create(organization));
    }
   
    @RequestMapping(value="/{organizationId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization( @PathVariable("organizationId") String organizationId) {
    	service.delete( organizationId );

    }

}
