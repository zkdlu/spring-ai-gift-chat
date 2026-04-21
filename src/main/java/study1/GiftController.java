package study1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiftController {

    private final GiftService giftService;

    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping("/api/chat")
    GiftResponse gift(String message, String sessionId) {
        return giftService.gift(message, sessionId);
    }
}
