package com.aiexpanse.algo.jetty;

import com.aiexpanse.algo.tree.traversal.PostOrderTraversal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

    private ObjectMapper objectMapper;

    public JsonMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public String toJson(Object object) {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "{error: " + e.getMessage() + "}";
        }
    }

    public static void main(String[] args) {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
    }

}
