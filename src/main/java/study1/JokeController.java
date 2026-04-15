package study1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {
    private final ChatClient client;

    public JokeController(ChatClient.Builder chatClientBuilder) {
        this.client = chatClientBuilder.build();
    }

    @GetMapping("/joke")
    public String joke(String message) {
        return client.prompt()
                .system("당신은 시인입니다.")
                .user(message)
                .call()
                .content();
    }
}
