CREATE TABLE departments (
    dep_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dep_name VARCHAR(100) NOT NULL,
    dep_note VARCHAR(100) NOT NULL,
    parant_id INT UNSIGNED REFERENCES departments (dep_id) ON DELETE CASCADE
);

CREATE TABLE professions (
    prof_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prof_name VARCHAR(100) NOT NULL,
    prof_note VARCHAR(100) NOT NULL
);

CREATE TABLE employees (
    emp_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    emp_note VARCHAR(100) NOT NULL,
    emp_profession INT UNSIGNED NOT NULL REFERENCES professions (prof_id) ON DELETE CASCADE,
    emp_dep_id INT UNSIGNED NOT NULL REFERENCES departments (dep_id) ON DELETE CASCADE
);

INSERT INTO departments VALUES (1, 'Административный департамент', 'Административный департамент',NULL);
INSERT INTO departments VALUES (2, 'Кадровая служба', 'Кадровая служба', 1);
INSERT INTO departments VALUES (3, 'Финансовый отдел', 'Финансовый отдел', 1);
INSERT INTO departments VALUES (4, 'Департамент разработки ПО', 'Департамент разработки ПО', NULL);
INSERT INTO departments VALUES (5, 'Департамент разработки тестового ПО', 'Департамент разработки тестового ПО', 4);

INSERT INTO professions VALUES (1, 'Директор департамента', 'Директор департамента');
INSERT INTO professions VALUES (2, 'Бухгалтер', 'Бухгалтер');
INSERT INTO professions VALUES (3, 'Программист', 'Программист');
INSERT INTO professions VALUES (4, 'HR', 'HR');

INSERT INTO employees VALUES (1, 'Иванов Иван Иванович', 'Директор департамента', 1, 1);
INSERT INTO employees VALUES (2, 'Петров Петр Петрович', 'Директор департамента', 1, 4);
INSERT INTO employees VALUES (3, 'Семенов Семен Семенович', 'HR', 4, 2);
INSERT INTO employees VALUES (4, 'Морозова Инна Львовна', 'Бухгалтер', 2, 3);
INSERT INTO employees VALUES (5, 'Миронов Максим Викторович', 'Программист', 3, 5);