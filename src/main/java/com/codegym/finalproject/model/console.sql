# Tìm kiếm job theo thành phố và công ty
SELECT *
FROM RecuitmentNew r
         LEFT JOIN Company c ON r.company_id = c.id
         LEFT JOIN City ci ON r.city_id = ci.id
WHERE lower(r.title) LIKE lower(CONCAT('%', :title, '%'))
   OR LOWER(c.name) LIKE LOWER(CONCAT('%', :title, '%'))
   OR LOWER(ci.name) LIKE LOWER(CONCAT('%', :title, '%'));

# Tìm kiếm job theo ngành nghề, địa chỉ (thành phố)
SELECT *
FROM Recuitmentnew r
         left join city ci on r.city_id = ci.id
WHERE lower(r.title) LIKE lower(CONCAT('%', :title, '%'))
   or lower(ci.name) like lower(concat('%', :title, '%')); # Theo thành phố

SELECT *
FROM Recuitmentnew r
         left join field f on r.city_id = f.id
WHERE lower(r.title) LIKE lower(CONCAT('%', :title, '%'))
   or lower(f.name) like lower(concat('%', :title, '%')); # Theo ngành nghề

SELECT *
FROM Recuitmentnew r
         left join field f on r.field_id = f.id
         left join city ci on r.city_id = ci.id
WHERE lower(r.title) LIKE lower(CONCAT('%', :title, '%'))
   or lower(ci.name) like lower(concat('%', :title, '%'))
   or lower(f.name) like lower(concat('%', :title, '%')); # Theo cả ngành nghề và thành phố
