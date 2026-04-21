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
        ChatClient.ChatClientRequestSpec requestSpec = client.prompt()
                .system("당신은 선물 추천 도우미에요.")
                .user(message);

        ChatClient.CallResponseSpec responseSpec = requestSpec.call();
        String response = responseSpec.content();

        return new GiftResponse(
                "requestId", response, String.valueOf(System.nanoTime())
        );
    }
}
