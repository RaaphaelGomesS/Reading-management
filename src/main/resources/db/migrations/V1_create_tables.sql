CREATE TABLE IF NOT EXISTS reader (
    reader_id SERIAL,
    name varchar(100),
    username varchar(100) unique NOT NULL,
    password varchar(255) unique NOT NULL,
    PRIMARY KEY(reader_id)
)

CREATE TABLE IF NOT EXISTS book (
    book_id SERIAL,
    reader_id INT NOT NULL,
    title varchar(255) NOT NULL,
    author_name varchar(100),
    total_pages int NOT NULL,
    read_pages int,
    status varchar(50) NOT NULL,
    rate int,
    start_date DATE,
    end_date DATE
    PRIMARY KEY(book_id),
    FOREIGN KEY(reader_id) REFERENCES reader(reader_id)
)

CREATE TABLE IF NOT EXISTS annotation (
    annotation_id SERIAL,
    book_id INT NOT NULL,
    title varchar(150),
    desc varchar(500) NOT NULL,
    PRIMARY KEY(annotation_id),
    FOREIGN KEY(book_id) REFERENCES book (book_id)
)