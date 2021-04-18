package com.dk.aws.lambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
public class Hello implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent event) {
       log.info("Request handled");
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(HttpStatus.OK.value());
        response.setBody(String.format("Hello you %s", event.getBody()));
        return response;
    }
}
