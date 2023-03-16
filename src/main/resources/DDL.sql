CREATE TABLE student (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL
    PRIMARY KEY (id)
);


CREATE TABLE course (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL
    PRIMARY KEY (id)
);

CREATE TABLE student_course (
    student_id INT NOT NULL,
    course_id INT NOT NULL
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student(id)
    FOREIGN KEY (course_id) REFERENCES course(id)
);