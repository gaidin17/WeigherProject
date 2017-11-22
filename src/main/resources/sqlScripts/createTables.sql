CREATE TABLE organizations (
    id BIGSERIAL NOT NULL,
    name VARCHAR NOT NULL,
    inn VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE trucks (
    id BIGSERIAL NOT NULL,
    number VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE drivers (
    id BIGSERIAL NOT NULL,
    number VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Cargo (
    id BIGSERIAL NOT NULL,
    type VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE weighning (
    id BIGSERIAL NOT NULL,
    organization_id BIGINT,
    driver_id BIGINT,
    truck_id BIGINT,
    cargo_id BIGINT,
    firstweighting DOUBLE PRECISION,
    firstweightingDate DATE,
    secondweighting DOUBLE PRECISION,
    secondweightingDate DOUBLE PRECISION,
    PRIMARY KEY (id),
    FOREIGN KEY (organization_id) REFERENCES organizations(id),
    FOREIGN KEY (driver_id) REFERENCES drivers(id),
    FOREIGN KEY (truck_id) REFERENCES trucks(id)
    FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);
