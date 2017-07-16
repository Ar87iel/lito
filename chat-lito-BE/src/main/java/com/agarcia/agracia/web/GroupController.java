package com.agarcia.agracia.web;

import com.agarcia.agracia.domain.Group;
import com.agarcia.agracia.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;



    @RequestMapping(method = RequestMethod.GET)
    public List<Group> getAllGroups()
    {
        return  groupService.getAllGroups();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody GroupRequestDTO groupRequestDTO)
    {
        groupService.addGroup(groupRequestDTO);
    }

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteGroup(@PathVariable long id){
        System.out.println(" controller "+id);
        groupService.deleteByGroupId(id);
        // return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Group getGroupById(@PathVariable long id){
        return groupService.searchByGroupId(id);
    }


    @RequestMapping(value = "/{groupId}",method = RequestMethod.PUT)
    public ResponseEntity updateGroup(@PathVariable long groupId,@RequestBody GroupRequestDTO groupRequestDTO){
        groupService.updateByGroupIdByGroup(groupId,groupRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }



    public static class GroupRequestDTO
    {
        private Long ownerId;
        private String logo;
        private String name;
        private Date creation_date;

        public Long getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Long ownerId) {
            this.ownerId = ownerId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(Date creation_date) {
            this.creation_date = creation_date;
        }
    }
}
