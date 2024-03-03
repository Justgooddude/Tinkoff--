package edu.java.client;

import edu.java.client.dto.UpdateRequest;
import edu.java.control.commandDto.APIEresponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BotClient {
    private final WebClient botWebClient;

    public Mono<Void> update(UpdateRequest linkUpdateRequest) {
        return botWebClient.post()
            .uri("/updates")
            .bodyValue(linkUpdateRequest)
            .retrieve()
            .onStatus(this::isApiError, this::handleApiError)
            .bodyToMono(Void.class);
    }

    private Mono<APIError> handleApiError(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(APIEresponse.class)
            .map(apiErrorResponse ->
                new APIError(
                    apiErrorResponse.description + ": " + apiErrorResponse.exceptionMessage,
                    Integer.parseInt(apiErrorResponse.code)
                )
            );
    }

    private boolean isApiError(HttpStatusCode code) {
        return code.is4xxClientError() || code.is5xxServerError();
    }
}
