package com.agarcia.agracia.web;

import com.agarcia.agracia.domain.Group;
import com.agarcia.agracia.domain.GroupUser;
import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@RestController
@RequestMapping("/groupusers")
public class GroupUserController {
    @Autowired
    private GroupUserService groupUserService;


    @RequestMapping(method = RequestMethod.GET)
    public List<GroupUser> getAllGroupUsers()
    {
        return  groupUserService.getAllGroupUsers();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void addNewUserGroup(@RequestBody GroupUserRequestDTO groupUserRequestDTO)
    {
        groupUserService.addNewgroupUser(groupUserRequestDTO);
    }

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteGroupUser(@PathVariable long id){
        groupUserService.deleteByGroupUserId(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public GroupUser getGroupUserById(@PathVariable long id){
        return groupUserService.searchByGroupUserId(id);
    }


    @RequestMapping(value = "/{proupuserId}",method = RequestMethod.PUT)
    public ResponseEntity updateGroupUser(@PathVariable long proupuserId,@RequestBody GroupUserRequestDTO groupUserRequestDTO){
        groupUserService.updateByGroupUserIdByGroupUser(proupuserId,groupUserRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }

    public  static  class GroupUserRequestDTO
    {

        private long user;

        private long group;

        public long getUser() {
            return user;
        }

        public void setUser(long user) {
            this.user = user;
        }

        public long getGroup() {
            return group;
        }

        public void setGroup(long group) {
            this.group = group;
        }

    }
}
