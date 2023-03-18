package com.welitoncardozo.bicycleallocation.enums;

public enum AllocationStatus {
    AVAILABLE,
    RENTED;

    public boolean isRented() {
        return RENTED.equals(this);
    }
}
