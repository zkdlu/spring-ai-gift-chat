package study1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GiftServiceTest {

    private GiftChatClient spyChatClient;
    private GiftService sut;

    @BeforeEach
    void setUp() {
        spyChatClient = mock(GiftChatClient.class);
        sut = new GiftService(spyChatClient);
    }

    @Test
    void gift_callsChat_inChatClient() throws Exception {
        sut.gift("", "");

        verify(spyChatClient).chat(anyString(), anyString());
    }

    @Test
    void gift_passSystemPrompt_inChatClient() throws Exception {
        sut.gift("", "");

        verify(spyChatClient).chat(eq("당신은 선물 추천 도우미에요."), anyString());
    }

    @Test
    void gift_passMessage_inChatClient() throws Exception {
        sut.gift("친구 생일 선물 추천해 줘", "");

        verify(spyChatClient).chat(anyString(), eq("친구 생일 선물 추천해 줘"));
    }

}