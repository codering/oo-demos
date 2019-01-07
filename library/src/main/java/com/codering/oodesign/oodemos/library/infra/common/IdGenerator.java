package com.codering.oodesign.oodemos.library.infra.common;

import java.util.UUID;

public class IdGenerator {

    private IdGenerator() {
    }

    public static String createId() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
