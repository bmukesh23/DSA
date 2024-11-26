# Write your MySQL query statement below
WITH AllCombinations AS (
    SELECT
        s.student_id,
        s.student_name,
        sub.subject_name
    FROM
        Students s
    CROSS JOIN
        Subjects sub
),
ExamCounts AS (
    SELECT
        e.student_id,
        e.subject_name,
        COUNT(*) AS attended_exams
    FROM
        Examinations e
    GROUP BY
        e.student_id, e.subject_name
)
SELECT
    ac.student_id,
    ac.student_name,
    ac.subject_name,
    COALESCE(ec.attended_exams, 0) AS attended_exams
FROM
    AllCombinations ac
LEFT JOIN
    ExamCounts ec
ON
    ac.student_id = ec.student_id AND ac.subject_name = ec.subject_name
ORDER BY
    ac.student_id, ac.subject_name;