CREATE TABLE organisation (
    id BIGSERIAL NOT NULL,
    name VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE truck (
    id BIGSERIAL NOT NULL,
    number VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE driver (
    id BIGSERIAL NOT NULL,
    number VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Cargo (
    id BIGSERIAL NOT NULL,
    type VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE weghning (
    id BIGSERIAL NOT NULL,
    organization_id BIGINT,
    driver_id BIGINT,
    cargo_id BIGINT,
    firstWeighing DOUBLE PRECISION,
    firstWeighingDate DATE,
    secondWeighing DOUBLE PRECISION,
    secondWeighingDate DOUBLE PRECISION,
    PRIMARY KEY (id),
    FOREIGN KEY (organization_id) REFERENCES organisation(id),
    FOREIGN KEY (driver_id) REFERENCES driver(id),
    FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);
