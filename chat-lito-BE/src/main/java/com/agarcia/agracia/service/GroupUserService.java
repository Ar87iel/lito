package com.agarcia.agracia.service;

import com.agarcia.agracia.domain.Group;
import com.agarcia.agracia.domain.GroupUser;
import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.repository.GroupRepository;
import com.agarcia.agracia.repository.GroupUserRepository;
import com.agarcia.agracia.repository.UserRepository;
import com.agarcia.agracia.web.GroupUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lito on 15/7/17.
 */
@Service
public class GroupUserService {
    @Autowired
    private GroupUserRepository groupUserRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    public List<GroupUser> getAllGroupUser()
    {
        return  groupUserRepository.findAll();
    }

    public void addNewgroupUser(GroupUserController.GroupUserRequestDTO groupUserRequestDTO) {

        User usr = userRepository.findOne(groupUserRequestDTO.getUser());
        Group  group= groupRepository.findOne(groupUserRequestDTO.getGroup());

        GroupUser newGroup= new GroupUser();
        newGroup.setGroup(group);
        newGroup.setUser(usr);

        groupUserRepository.save(newGroup);
    }

    public List<GroupUser> getAllGroupUsers() {
        return  groupUserRepository.findAll();
    }

    public void deleteByGroupUserId(long groupuserId) {
        groupUserRepository.delete(groupuserId);
    }

    public void updateByGroupUserIdByGroupUser(long proupuserId, GroupUserController.GroupUserRequestDTO groupUserRequestDTO) {
        User usr = userRepository.findOne(groupUserRequestDTO.getUser());
        Group  group= groupRepository.findOne(groupUserRequestDTO.getGroup());

        GroupUser newGroup= groupUserRepository.findOne(proupuserId);
        newGroup.setGroup(group);
        newGroup.setUser(usr);

        groupUserRepository.save(newGroup);
    }

    public GroupUser searchByGroupUserId(long id) {

        return  groupUserRepository.findOne(id);
    }
}
