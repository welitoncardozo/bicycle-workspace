CREATE TABLE IF NOT EXISTS bicycle_allocation
(
    id UUID NOT NULL,
    bicycle_id INTEGER NOT NULL,
    bicycle_name TEXT NOT NULL,
    client_id INTEGER NOT NULL,
    client_name TEXT NOT NULL,
    status VARCHAR(32) NOT NULL,
    date TIMESTAMP NOT NULL,

    CONSTRAINT pk_bicycle_allocation PRIMARY KEY (id),
    CONSTRAINT unique_bicycle_client UNIQUE (bicycle_id, client_id)
);

CREATE TABLE IF NOT EXISTS bicycle_allocation_historic
(
    id UUID NOT NULL,
    bicycle_allocation UUID NOT NULL,
    status VARCHAR(32) NOT NULL,
    date TIMESTAMP NOT NULL,

    CONSTRAINT pk_bicycle_allocation_historic PRIMARY KEY (id),
    CONSTRAINT fk_bicycle_allocation_historic_bicycle_allocation FOREIGN KEY (bicycle_allocation) REFERENCES bicycle_allocation (id)
);