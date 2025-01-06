# Write your MySQL query statement below
DELETE a1 FROM Person a1,Person a2 WHERE a1.email=a2.email AND a1.id>a2.id;