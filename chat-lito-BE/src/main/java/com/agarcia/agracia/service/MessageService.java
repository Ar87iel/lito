package com.agarcia.agracia.service;

import com.agarcia.agracia.domain.Message;
import com.agarcia.agracia.domain.Status;
import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.repository.MessageRepository;
import com.agarcia.agracia.repository.StatusRepository;
import com.agarcia.agracia.repository.UserRepository;
import com.agarcia.agracia.web.MessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lito on 15/7/17.
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private UserRepository userRepository;



    public void addMessage(MessageController.MessageRequestDTO messageRequestDTO) {

        Message  message = new Message();
        Status  status= statusRepository.findOne(messageRequestDTO.getStatusId());
        User user= userRepository.findOne(messageRequestDTO.getUserId());

        message.setStatus(status);
        message.setUser(user);
        message.setCreating_date(messageRequestDTO.getCreating_date());

        messageRepository.save(message);
    }

    public void deleteByMessageId(long messageId) {
        messageRepository.delete(messageId);
    }

    public Message searchByMessageId(long id) {
        return   messageRepository.findOne(id);
    }

    public void updateByMessageIdByMessage(long messageId, MessageController.MessageRequestDTO messageRequestDTO) {
        Message actualizar = messageRepository.findOne(messageId);
        Status  status= statusRepository.findOne(messageRequestDTO.getStatusId());
        User user= userRepository.findOne(messageRequestDTO.getUserId());

        actualizar.setStatus(status);
        actualizar.setUser(user);

        messageRepository.save(actualizar);


    }

    public List<Message> getAllMessages() {
        return  messageRepository.findAll();
    }
}
