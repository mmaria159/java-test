ALTER TABLE product ADD CONSTRAINT product_user__fk
		FOREIGN KEY (user_id) REFERENCES postgres.public.user (id);
