CREATE TABLE organiation (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE truck (
    id BIGINT NOT NULL AUTO_INCREMENT,
    number VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE driver (
    id BIGINT NOT NULL AUTO_INCREMENT,
    number VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Cargo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    type VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE weghning (
    id BIGINT NOT NULL AUTO_INCREMENT,
    organization_id BIGINT,
    driver_id BIGINT,
    cargo_id BIGINT,
    firstWeighing DOUBLE PRECISION,
    firstWeighingDate DATE,
    secondWeighing DOUBLE PRECISION,
    secondWeighingDate DOUBLE PRECISION,
    PRIMARY KEY (id),
    FOREIGN KEY (organization_id) REFERENCES organiation(id),
    FOREIGN KEY (driver_id) REFERENCES driver(id),
    FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);
