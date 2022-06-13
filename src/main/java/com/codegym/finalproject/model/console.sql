# Tìm kiếm job theo thành phố và công ty
SELECT *
FROM RecuitmentNew r
         LEFT JOIN Company c ON r.company_id = c.id
         LEFT JOIN City ci ON r.city_id = ci.id
WHERE lower(r.title) LIKE lower(CONCAT('%', :title, '%'))
   OR LOWER(c.name) LIKE LOWER(CONCAT('%', :title, '%'))
   OR LOWER(ci.name) LIKE LOWER(CONCAT('%', :title, '%'))

