SELECT name, COUNT(*) oynadigi, SUM(point) toplampuan,
SUM(point) / count(*) mac_basi_puan,
SUM(score) attigigol,
SUM(score) / count(*)  mac_basi_gol,
20 * SUM(point) / count(*) + 10 * SUM(score) / count(*) skor,
rating * 0.01 katsayi,
rating * 0.01 * (20 * SUM(point) / count(*) + 10 * SUM(score) / count(*)) total
FROM team_player
INNER JOIN player ON(id = player_id)
GROUP BY player_id
ORDER BY total DESC;

/* takim zorlugu da hesaba katiliyor. */

SELECT name, count(*) oynadigi, ROUND(AVG(tp.score*10 + tp.point * 20) * coef,2) puan
FROM team_player tp
INNER JOIN team ON(tp.team_id = team.id)
INNER JOIN player ON (tp.player_id = player.id)
GROUP BY player_id
ORDER BY puan DESC;
