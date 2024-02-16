CREATE TABLE IF NOT EXISTS public.users
(
    id SERIAL,
    balance bigint,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;


CREATE TABLE IF NOT EXISTS public.user_transaction
(
    id SERIAL,
    amount bigint,
    user_id bigint,
    transaction_date date,
    CONSTRAINT transaction_pkey PRIMARY KEY (id),
    CONSTRAINT fkascyfwxhg0vgqp79xk7pddbke FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;



ALTER TABLE user_transaction 
RENAME COLUMN date TO transaction_date;
