ALTER TABLE product
ADD CONSTRAINT fkey_userid
FOREIGN KEY (userid)
REFERENCES users (id)
on UPDATE CASCADE
on DELETE CASCADE;