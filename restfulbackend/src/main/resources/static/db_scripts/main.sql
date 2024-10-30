USE APSpgDB;

-- APPUSERS TABLE STRUCTURE:
CREATE TABLE app_user(
    user_id uuid DEFAULT gen_random_uuid(),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    created_at TIMESTAMP,
    updated_at DATETIME,
    PRIMARY KEY (user_id)
);

ALTER TABLE app_user OWNER TO apsrole;
