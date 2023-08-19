package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.ChatRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Chat;

import java.util.Collection;

public interface ChatService {
    public Chat createChat(Chat chat);
    public Collection<Chat> getChatByOpportunityId(Long opportunityId);
}
