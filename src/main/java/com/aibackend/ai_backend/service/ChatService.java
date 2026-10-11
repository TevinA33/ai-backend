package com.aibackend.ai_backend.service;

import com.aibackend.ai_backend.dto.ChatRequest;
import com.aibackend.ai_backend.dto.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;

     public ChatResponse chat(ChatRequest request) {
         String aiResponse = chatClient.prompt()
                 .user(request.getMessage())
                 .call().content();

         return new ChatResponse(aiResponse);
     }
}
