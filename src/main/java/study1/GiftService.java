package study1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GiftService {

    private final ChatClient client;

    public GiftService(ChatClient.Builder chatClientBuilder) {
        this.client = chatClientBuilder.build();
    }

    public GiftResponse gift(String message, String sessionId) {
        client.prompt()
                .system("당신은 선물 추천 도우미에요.")
                .user(message);

        return null;
    }
}
