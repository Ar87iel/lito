package com.agarcia.agracia.web;

import com.agarcia.agracia.domain.Message;
import com.agarcia.agracia.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessages()
    {
        return  messageService.getAllMessages();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addMessage(@RequestBody MessageRequestDTO messageRequestDTO)
    {
        messageService.addMessage(messageRequestDTO);
    }

    /**
     * delete user
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMessage(@PathVariable long id){
        messageService.deleteByMessageId(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Message getMessageById(@PathVariable long id){
        return messageService.searchByMessageId(id);
    }


    @RequestMapping(value = "/{messageId}",method = RequestMethod.PUT)
    public ResponseEntity updateMessage(@PathVariable long messageId,@RequestBody MessageRequestDTO messageRequestDTO){
        messageService.updateByMessageIdByMessage(messageId,messageRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }


    public  static  class MessageRequestDTO
    {
        private String content;

        private long statusId;

        private long userId;

        private Date creating_date;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getStatusId() {
            return statusId;
        }

        public void setStatusId(long statusId) {
            this.statusId = statusId;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public Date getCreating_date() {
            return creating_date;
        }

        public void setCreating_date(Date creating_date) {
            this.creating_date = creating_date;
        }
    }
}
