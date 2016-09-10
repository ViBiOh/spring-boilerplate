package org.vibioh.model;

import org.vibioh.utils.DateHelper;

public class Hello {
    private String name;
    private long moment;

    public Hello(final String name) {
        this.name = name;
        moment = DateHelper.now().getTime();
    }

    public String getName() {
        return name;
    }

    public long getMoment() {
        return moment;
    }
}
