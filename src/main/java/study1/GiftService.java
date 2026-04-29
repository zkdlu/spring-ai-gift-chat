package study1;

import org.springframework.stereotype.Service;

@Service
public class GiftService {

    private static final String SYSTEM_PROMPT = "당신은 선물 추천 도우미에요.";

    private final GiftChatClient chatClient;

    public GiftService(GiftChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public GiftResponse gift(String message, String sessionId) {
        String response = chatClient.chat(SYSTEM_PROMPT, message);

        return new GiftResponse(
                "requestId", response, String.valueOf(System.nanoTime())
        );
    }
}
