package com.llm.agent.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIChatController {

    private final ChatClient chatClient;

    public AIChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    String generation(@RequestParam String prompt) {
        return this.chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
