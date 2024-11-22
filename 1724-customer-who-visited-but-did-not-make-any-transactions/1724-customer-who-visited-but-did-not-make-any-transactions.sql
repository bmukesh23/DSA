# Write your MySQL query statement below
WITH NoTransactionVisits AS (
    SELECT 
        v.customer_id,
        v.visit_id
    FROM 
        Visits v
    LEFT JOIN 
        Transactions t
    ON 
        v.visit_id = t.visit_id
    WHERE 
        t.visit_id IS NULL
)
SELECT 
    customer_id,
    COUNT(*) AS count_no_trans
FROM 
    NoTransactionVisits
GROUP BY 
    customer_id;