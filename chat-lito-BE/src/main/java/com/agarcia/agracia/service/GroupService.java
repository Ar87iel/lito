package com.agarcia.agracia.service;

import com.agarcia.agracia.domain.Group;
import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.repository.GroupRepository;
import com.agarcia.agracia.repository.UserRepository;
import com.agarcia.agracia.web.GroupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lito on 15/7/17.
 */
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Group> getAllGroups()
    {
        return   (List<Group>)groupRepository.findAll();
        //return   groupRepository.findAll();
    }

    public  void addGroup(GroupController.GroupRequestDTO groupRequestDTO)
    {
        User owner= userRepository.findOne(groupRequestDTO.getOwnerId());

        Group  group = new Group();
        group.setOwner(owner);
        group.setName(groupRequestDTO.getName());
        group.setLogo(groupRequestDTO.getLogo());

        groupRepository.save(group);
    }

    public void deleteByGroupId(long groupId) {

        System.out.println(" group user id "+groupId);
        groupRepository.delete(groupId);
    }

    public Group searchByGroupId(long id) {

        return  groupRepository.findOne(id);

    }

    public void updateByGroupIdByGroup(long groupId, GroupController.GroupRequestDTO groupRequestDTO) {
        User owner= userRepository.findOne(groupRequestDTO.getOwnerId());

        Group  group = groupRepository.findOne(groupId);
        group.setOwner(owner);
        group.setName(groupRequestDTO.getName());
        group.setLogo(groupRequestDTO.getLogo());

        groupRepository.save(group);

    }
}
