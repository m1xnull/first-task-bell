package com.bellintegrator.firstTask;

import java.util.HashMap;
import java.util.List;

public class DataWrapper {
    public static HashMap getData(List data) {
        return new HashMap() {{
            put("data", data);
        }};
    }
}