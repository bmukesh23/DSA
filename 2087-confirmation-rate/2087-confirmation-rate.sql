WITH ConfirmCounts AS (
    SELECT 
        user_id,
        SUM(CASE WHEN action = 'confirmed' THEN 1 ELSE 0 END) AS confirmed_count,
        COUNT(*) AS total_count
    FROM Confirmations
    GROUP BY user_id
)
SELECT 
    s.user_id,
    ROUND(COALESCE(c.confirmed_count, 0) * 1.0 / COALESCE(c.total_count, 1), 2) AS confirmation_rate
FROM Signups s
LEFT JOIN ConfirmCounts c
ON s.user_id = c.user_id
ORDER BY s.user_id;
