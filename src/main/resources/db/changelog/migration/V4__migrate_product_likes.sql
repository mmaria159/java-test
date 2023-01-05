CREATE TABLE IF NOT EXISTS "product_likes"
(
    id            BIGSERIAL PRIMARY KEY,
    likes         BOOLEAN,
    product_id    BIGINT NOT NULL REFERENCES product,
    user_id       BIGINT NOT NULL REFERENCES postgres.public.user
);