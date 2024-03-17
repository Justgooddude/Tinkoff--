package edu.java.client;

import edu.java.client.dto.StOvRes;
import edu.java.client.APIError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StOvClient {
    private final WebClient stackOverflowWebClient;
    public Mono<StOvRes> getQuestionInfo(long id) {
        return stackOverflowWebClient.get()
            .uri("/questions/{id}?site=stackoverflow", id)
            .retrieve()
            .onStatus(
                status -> status.is4xxClientError() || status.is5xxServerError(),
                clientResponse -> Mono.error(new APIError(
                    "Stackoverflow API error",
                    clientResponse.statusCode().value()
                ))
            )
            .bodyToMono(StOvRes.class);
    }
}
