package org.vibioh.model;

public class Hello {
    private final String name;
    private final long moment;

    public Hello(final String name, final long moment) {
        this.name = name;
        this.moment = moment;
    }

    public String getName() {
        return name;
    }

    public long getMoment() {
        return moment;
    }
}
