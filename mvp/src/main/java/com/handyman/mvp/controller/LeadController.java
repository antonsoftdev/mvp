package com.handyman.mvp.controller;

import com.handyman.mvp.dto.LeadDtoRequest;
import com.handyman.mvp.dto.LeadDtoResponse;
import com.handyman.mvp.dto.UserDtoResponse;
import com.handyman.mvp.service.LeadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/leads")
public class LeadController {

    @Autowired
    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping("/create")
    public LeadDtoResponse setLead(@RequestBody LeadDtoRequest leadDtoRequest) {
        return leadService.createLead(leadDtoRequest);
    }

    @GetMapping(params = {"get"})
    public ResponseEntity<LeadDtoResponse> getLeadById(@RequestParam(value = "id") long id) {
        return new ResponseEntity<>(leadService.sendLead(id), HttpStatus.OK);
    }
}
