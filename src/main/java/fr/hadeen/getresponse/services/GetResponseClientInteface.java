package fr.hadeen.getresponse.services;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public interface GetResponseClientInteface {
    public <T, R> R post(String path, T data, Class<R> responseType) throws URISyntaxException;
    public <T, R> R put(String path, T data, Class<R> responseType) throws URISyntaxException;
    public <R> R get(String path, Class<R> responseType) throws URISyntaxException;

    public <R> R search(String path, Map<String, ?> data, Class<R> responseType) throws URISyntaxException;
    public <R> R delete(String path, Class<R> responseType) throws URISyntaxException;
}
