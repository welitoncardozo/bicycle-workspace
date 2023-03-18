package com.welitoncardozo.bicycleallocation.clients;

public interface BicycleRegisterHandler {
    void rent(final Long id);
    void giveItBack(final Long id);
}
