package com.agarcia.agracia.service;

import com.agarcia.agracia.domain.Status;
import com.agarcia.agracia.repository.StatusRepository;
import com.agarcia.agracia.web.StatusController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;
    public List<Status> getAllStatus()
    {
        return  statusRepository.findAll();
    }

    public void addStatus(StatusController.StatusRequestDTO statusRequestDTO) {

        Status  newstatus= new Status();
        newstatus.setName(statusRequestDTO.getName());

        statusRepository.save(newstatus);
    }


    public void deleteByStatusId(long statusId) {
        statusRepository.delete(statusId);


    }

    public Status searchByStatusId(long id) {
        return  statusRepository.findOne(id);
    }


    public void updateByStatusIdByStatus(long statusId, StatusController.StatusRequestDTO statusRequestDTO) {

        Status actualizar=statusRepository.findOne(statusId);
        actualizar.setName(statusRequestDTO.getName());
        statusRepository.save(actualizar);
    }
}

