-- ID	    NAME	                                        HOST_ID
-- 4431977	BOUTIQUE STAYS - Somerset Terrace, Pet Friendly	760849
-- 5194998	BOUTIQUE STAYS - Elwood Beaches 3, Pet Friendly	760849
-- 16045624	Urban Jungle in the Heart of Melbourne	        30900122
-- 17810814	Stylish Bayside Retreat with a Luscious Garden	760849
-- 22740286	FREE PARKING - The Velvet Lux in Melbourne CBD	30900122
-- 22868779	★ Fresh Fitzroy Pad with City Views! ★	        21058208

SELECT ID, NAME, PLACES.HOST_ID
FROM PLACES, ( SELECT HOST_ID
               FROM PLACES
               GROUP BY HOST_ID HAVING COUNT(HOST_ID) > 1
) as dupl_HOST_ID
WHERE PLACES.HOST_ID = dupl_HOST_ID.HOST_ID;

-- REFERENCE TO GROUP BY: https://link2me.tistory.com/728