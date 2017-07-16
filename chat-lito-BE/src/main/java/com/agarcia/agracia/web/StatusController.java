package com.agarcia.agracia.web;

import com.agarcia.agracia.domain.Status;
import com.agarcia.agracia.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Status> getAllUsers()
    {
        return  statusService.getAllStatus();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody StatusRequestDTO statusRequestDTO)
    {
        statusService.addStatus(statusRequestDTO);
    }
    /**
     * delete user
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStatus(@PathVariable long id){
        statusService.deleteByStatusId(id);
        return  new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Status getStatusById(@PathVariable long id){
        return statusService.searchByStatusId(id);
    }

    @RequestMapping(value = "/{statusId}",method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable long statusId,@RequestBody StatusRequestDTO statusRequestDTO ){
        statusService.updateByStatusIdByStatus(statusId,statusRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }

    public  static class  StatusRequestDTO
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
