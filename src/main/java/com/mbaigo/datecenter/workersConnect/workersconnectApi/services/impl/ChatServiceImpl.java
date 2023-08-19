package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.ChatRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Chat;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.ChatService;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }
    /**
     * @param chat 
     * @return
     */
    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    /**
     * @param opportunityId 
     * @return
     */
    @Override
    public Collection<Chat> getChatByOpportunityId(Long opportunityId) {
        return chatRepository.findByOpportunit_Id(opportunityId);
    }
}
