CREATE TABLE organisations (
    id BIGSERIAL NOT NULL,
    name VARCHAR NOT NULL,
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
    cargo_id BIGINT,
    firstWeighing DOUBLE PRECISION,
    firstWeighingDate DATE,
    secondWeighing DOUBLE PRECISION,
    secondWeighingDate DOUBLE PRECISION,
    PRIMARY KEY (id),
    FOREIGN KEY (organization_id) REFERENCES organisations(id),
    FOREIGN KEY (driver_id) REFERENCES drivers(id),
    FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);
