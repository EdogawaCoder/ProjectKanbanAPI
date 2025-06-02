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

INSERT INTO tb_tasks_kanban (
    id,
    title,
    description,
    in_charge,
    date_created,
    date_limit,
    started,
    finished
) VALUES (
    'e2c1f6a1-4cfc-4d5b-8b5a-0d28e3c7d6a7',
    'Criar protótipo do layout',
    'Finalizar o mockup visual da interface Kanban',
    'Edison',
    '2025-06-02 14:00:00',
    '2025-06-05 18:00:00',
    true,
    false
);