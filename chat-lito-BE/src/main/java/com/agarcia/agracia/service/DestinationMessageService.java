package com.agarcia.agracia.service;

import com.agarcia.agracia.domain.DestinationMessage;
import com.agarcia.agracia.domain.Message;
import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.repository.DestinationMessageRepository;
import com.agarcia.agracia.repository.MessageRepository;
import com.agarcia.agracia.repository.UserRepository;
import com.agarcia.agracia.web.DestinationMessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lito on 15/7/17.
 */

@Service
public class DestinationMessageService {

    @Autowired
    private DestinationMessageRepository destinationMessageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    public List<DestinationMessage> getAllDestinationMessages() {

        return   destinationMessageRepository.findAll();
    }

    public void addDestinationMessage(DestinationMessageController.DestinationMessageRequestDTO destinationMessageRequestDTO) {
        DestinationMessage newdmessage= new DestinationMessage();

        Message message= messageRepository.findOne(destinationMessageRequestDTO.getMessageId());
        User user= userRepository.findOne(destinationMessageRequestDTO.getUserId());

        newdmessage.setMessage(message);
        newdmessage.setUser(user);

        destinationMessageRepository.save(newdmessage);

    }

    public void deleteByDestinationMessageId(long dmessageId) {
        destinationMessageRepository.delete(dmessageId);
    }

    public DestinationMessage searchByDestinationMessageId(long id) {
        return  destinationMessageRepository.findOne(id);

    }

    public void updateByDestinationMessageIdByDMessage(long dmessageId, DestinationMessageController.DestinationMessageRequestDTO destinationMessageRequestDTO) {
        DestinationMessage newdmessage= destinationMessageRepository.findOne(dmessageId);

        Message message= messageRepository.findOne(destinationMessageRequestDTO.getMessageId());
        User user= userRepository.findOne(destinationMessageRequestDTO.getUserId());

        newdmessage.setMessage(message);
        newdmessage.setUser(user);

        destinationMessageRepository.save(newdmessage);

    }
}
