CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tb_tasks_kanban (
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    in_charge VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_limit TIMESTAMP NOT NULL,
    started BOOLEAN NOT NULL,
    finished BOOLEAN NOT NULL
);