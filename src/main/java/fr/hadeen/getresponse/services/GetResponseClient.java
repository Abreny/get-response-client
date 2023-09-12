package fr.hadeen.getresponse.services;

import fr.hadeen.getresponse.config.GetResponseConfigurationInterface;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class GetResponseClient implements GetResponseClientInteface {
    private final GetResponseConfigurationInterface configuration;
    private final RestTemplate restTemplate;

    private final UriComponentsBuilder uriComponentsBuilder;

    public GetResponseClient(GetResponseConfigurationInterface configuration, RestTemplate restTemplate, UriComponentsBuilder uriComponentsBuilder) {
        this.configuration = configuration;
        this.restTemplate = restTemplate;
        this.uriComponentsBuilder = uriComponentsBuilder;
    }

    @Override
    public <T, R> R post(String path, T data, Class<R> responseType) throws URISyntaxException {
        return request(path, HttpMethod.POST, data, responseType);
    }

    @Override
    public <T, R> R put(String path, T data, Class<R> responseType) throws URISyntaxException {
        return request(path, HttpMethod.PUT, data, responseType);
    }

    @Override
    public <R> R get(String path, Class<R> responseType) throws URISyntaxException {
        return requestWithoutData(path, HttpMethod.GET, responseType);
    }
    @Override
    public <R> R search(String path, Map<String, ?> data, Class<R> responseType) throws URISyntaxException {
        return requestWithQuery(path, data, responseType);
    }

    @Override
    public <R> R delete(String path, Class<R> responseType) throws URISyntaxException {
        return requestWithoutData(path, HttpMethod.DELETE, responseType);
    }

    private <T, R> R request(String path, HttpMethod method, T data, Class<R> responseType) throws URISyntaxException {
        HttpEntity<T> requestEntity = getRequestEntity(data);
        ResponseEntity<R> response = restTemplate.exchange(
                new URI(configuration.getBaseUrl() + path),
                method,
                requestEntity,
                responseType
        );
        return response.getBody();
    }

    private <T> HttpEntity<T> getRequestEntity(T data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth-Token", configuration.getApiKey());
        if (data == null) {
            return new HttpEntity<>(headers);
        }
        return new HttpEntity<>(data, headers);
    }

    private <T, R> R requestWithoutData(String path, HttpMethod method, Class<R> responseType) throws URISyntaxException {
        HttpEntity<T> requestEntity = getRequestEntity(null);
        ResponseEntity<R> response = restTemplate.exchange(
                new URI(configuration.getBaseUrl() + path),
                method,
                requestEntity,
                responseType
        );
        return response.getBody();
    }

    private <T, R> R requestWithQuery(String path, Map<String, ?> parameters, Class<R> responseType) throws URISyntaxException {
        uriComponentsBuilder.replacePath(path);
        parameters.forEach(uriComponentsBuilder::replaceQueryParam);
        HttpEntity<T> requestEntity = getRequestEntity(null);
        ResponseEntity<R> response = restTemplate.exchange(
                configuration.getBaseUrl() + uriComponentsBuilder.build().toUriString(),
                HttpMethod.GET,
                requestEntity,
                responseType
        );
        return response.getBody();
    }
}
