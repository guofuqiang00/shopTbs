package com.tbs.utils;

import java.util.List;

public class Response<T> {

    List<T> objects;

    public List<T> getObjects() {
        return objects;
    }

    public Response setObjects(List<T> objects) {
        this.objects = objects;
        return null;
    }
}
