package com.handyman.mvp.service;

import com.handyman.mvp.dto.LeadDtoRequest;
import com.handyman.mvp.dto.LeadDtoResponse;
import com.handyman.mvp.model.Lead;
import com.handyman.mvp.model.User;
import com.handyman.mvp.repositiry.LeadRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    private final Logger LOG = LoggerFactory.getLogger(LeadService.class);
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public LeadDtoResponse createLead(LeadDtoRequest leadDtoRequest) {
        Lead lead = convertToEntity(leadDtoRequest);
        LOG.info("Добавлена заявка: {}.", leadDtoRequest.getDateOfLead());
        leadRepository.save(lead);
        return convertToDtoResponse(lead);
    }

    public void createLeadByUser(User user) {
        Lead lead = new Lead();
        lead.setUser(user);
        lead.setDateOfLead("now");
        LOG.info("Добавлена заявка: {}.", lead.getDateOfLead());
        leadRepository.save(lead);
    }

    public LeadDtoResponse sendLead(long id) {
        return convertToDtoResponse(leadRepository.getLeadById(id));
    }

    private LeadDtoResponse convertToDtoResponse(Lead lead) {
        return modelMapper.map(lead, LeadDtoResponse.class);
    }

    private LeadDtoRequest convertToDtoRequest(Lead lead) {
        return modelMapper.map(lead, LeadDtoRequest.class);
    }

    private Lead convertToEntity(LeadDtoRequest leadDtoRequest) {
        return modelMapper.map(leadDtoRequest, Lead.class);
    }

    private Lead convertToEntity(LeadDtoResponse leadDtoResponse) {
        return modelMapper.map(leadDtoResponse, Lead.class);
    }

}
