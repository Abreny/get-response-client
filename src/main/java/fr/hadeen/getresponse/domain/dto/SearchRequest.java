package fr.hadeen.getresponse.domain.dto;

import java.util.HashMap;
import java.util.Map;

public class SearchRequest {
    private Map<String, String> query = new HashMap<>();
    private Map<String, SortDirection> sort = new HashMap<>();
    private Integer perPage = 100;
    private Integer page = 1;
    private String fields;

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public Map<String, SortDirection> getSort() {
        return sort;
    }

    public void setSort(Map<String, SortDirection> sort) {
        this.sort = sort;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public SearchRequest addQuery(String key, String value) {
        this.query.put(key, value);
        return this;
    }

    public SearchRequest addSort(String key, SortDirection direction) {
        this.sort.put(key, direction);
        return this;
    }

    public Map<String, ?> formatQueryParameters() {
        final Map<String, Object> params = new HashMap<>();
        if (!query.isEmpty()) {
            query.forEach((key, value) -> {
                params.put(String.format("query[%s]", key), value);
            });
        }
        if (!sort.isEmpty()) {
            sort.forEach((key, value) -> {
                params.put(String.format("sort[%s]", key), value);
            });
        }
        if (fields != null) {
            params.put("fields", fields);
        }
        params.put("perPage", perPage);
        params.put("page", page);
        return params;
    }

    public static enum SortDirection {
        ASC,
        DESC
    }
}
