# Write your MySQL query statement below
SELECT a.id, COALESCE(b.student, a.student) AS student
FROM Seat a LEFT JOIN Seat b
ON (a.id % 2 = 1 AND a.id + 1 = b.id) OR (a.id % 2 = 0 AND a.id - 1 = b.id);