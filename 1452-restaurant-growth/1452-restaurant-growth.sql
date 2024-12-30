# Write your MySQL query statement below
with cte as(
    select visited_on,
    sum(amount) as amount,
    avg(amount) as average_Amount
    from Customer
    group by visited_on
), cte1 as (
    select visited_on,
    SUM(amount) OVER (ORDER BY visited_on ASC ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) 
    AS amount,
    AVG(amount) OVER (ORDER BY visited_on ASC ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) 
    AS average_amount,
    row_number() over(order by visited_on) as num
    from cte
)

SELECT
    visited_on,
    ROUND(amount, 2) AS amount,
    ROUND(average_amount, 2) AS average_amount
FROM cte1
WHERE num > 6