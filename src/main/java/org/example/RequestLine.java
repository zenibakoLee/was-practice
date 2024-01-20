package org.example;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPath;
    private QueryStrings queryString;

    public RequestLine(String url) {
        String[] tokens = url.split(" ");
        this.method = tokens[0];

        String[] urlPathToken = tokens[1].split("\\?");
        this.urlPath = urlPathToken[0];

        if (urlPathToken.length == 2) {
            this.queryString = new QueryStrings(urlPathToken[1]);
        }
    }

    public RequestLine(String method, String urlpath, String queryString) {
        this.method = method;
        this.urlPath = urlpath;
        this.queryString = new QueryStrings(queryString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }

    public boolean isGetRequest() {
        return this.method.equals("GET");
    }

    public boolean matchPath(String path) {
        return this.urlPath.equals(path);
    }

    public QueryStrings getQueryStrings() {
        return this.queryString;
    }
}
