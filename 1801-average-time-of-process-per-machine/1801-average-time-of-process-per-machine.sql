WITH ProcessTime AS (
    SELECT 
        machine_id,
        process_id,
        MAX(CASE WHEN activity_type = 'end' THEN timestamp END) -
        MAX(CASE WHEN activity_type = 'start' THEN timestamp END) AS time_diff
    FROM Activity
    GROUP BY machine_id, process_id
)
SELECT 
    machine_id,
    ROUND(AVG(time_diff), 3) AS processing_time
FROM ProcessTime
GROUP BY machine_id;
