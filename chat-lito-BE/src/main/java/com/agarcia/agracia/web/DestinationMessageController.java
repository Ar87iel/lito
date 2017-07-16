package com.agarcia.agracia.web;

import com.agarcia.agracia.domain.DestinationMessage;
import com.agarcia.agracia.domain.Message;
import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.repository.DestinationMessageRepository;
import com.agarcia.agracia.service.DestinationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@RestController
@RequestMapping("/destinationmessages")
public class DestinationMessageController {
    @Autowired
    private DestinationMessageService destinationMessageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DestinationMessage> getAllDestinationMessages()
    {
        return  destinationMessageService.getAllDestinationMessages();
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody DestinationMessageRequestDTO destinationMessageRequestDTO)
    {
        destinationMessageService.addDestinationMessage(destinationMessageRequestDTO);
    }

    /**
     * delete
     * @param id
     * @return
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDestinationMessage(@PathVariable long id){
        destinationMessageService.deleteByDestinationMessageId(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public DestinationMessage getDestinationMessageById(@PathVariable long id){
        return destinationMessageService.searchByDestinationMessageId(id);
    }


    @RequestMapping(value = "/{dmessageId}",method = RequestMethod.PUT)
    public ResponseEntity updateDestinationMessage(@PathVariable long dmessageId,@RequestBody DestinationMessageRequestDTO destinationMessageRequestDTO){
        destinationMessageService.updateByDestinationMessageIdByDMessage(dmessageId,destinationMessageRequestDTO);
        return  new ResponseEntity(HttpStatus.OK);
    }




    public static class DestinationMessageRequestDTO
    {
        private Long id;
        private Long messageId;
        private Long userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getMessageId() {
            return messageId;
        }

        public void setMessageId(Long messageId) {
            this.messageId = messageId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}
