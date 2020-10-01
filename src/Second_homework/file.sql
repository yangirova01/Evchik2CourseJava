#1
select model,speed,hd
from pc
where price <500
#2
select distinct  maker
from product
where product.type = 'printer'
order  by maker
#3
select model,ram,screen
from laptop
where price>1000
#4
select code,model,color,type,price
from printer
where color  ='y'
#5
select model,speed,hd
from PC
where (cd ='12x' or cd='24x') and price <600
#6
select distinct product.maker,laptop.speed
from product join laptop on product.model = laptop.model
where laptop.hd>=10
#7
select pc.model,pc.price
from pc join product on product.model = pc.model
where product.maker = 'b'
union
select laptop.model,laptop.price
from laptop join product on product.model = laptop.model
where product.maker = 'b'
union
select printer.model,printer.price
from printer join product on printer.model = product.model
where product.maker = 'b'
#8
select distinct  maker
from product
where type ='pc' and maker not in
(select distinct maker
from product
where type = 'laptop'
group by maker)
#9
select  distinct product.maker
from pc join product  on product.model = pc.model
where speed >= 450
#10
select model,price
from printer
where  price = (select max(price) from printer)
#11
select avg(speed)
from pc
#12
select avg(speed)
from laptop
where price > 1000
#13
select avg(speed)
from pc join product on product.model = pc.model
where product.maker = 'a'
#14
select ships.class,ships.name,classes.country
from classes join ships on classes.class = ships.class
where numGuns >=10
#15
select hd
from pc
group by hd
having count(model)>1
#16
select distinct  q1.model,q2.model, q1.speed,q1.ram
from  pc q1, pc q2
where q1.speed = q2.speed and q1.ram = q2.ram and q1.model >q2.model
#17
select distinct  q.type, q.model , l.speed
from  laptop l  join product  q on l.model = q.model
where l.speed< (
select  min(speed) from pc)
#18
SELECT distinct MAKER,price
from product join  printer on product.model = printer.model
where price = (select min(price) from printer where color = 'y')
and color = 'y'
#19
select product.maker, avg(screen) as Avg_screen
from laptop join product on laptop.model = product.model
group by maker
#20
select maker, count(model) as Count_Model
from product
where type ='pc'
group by maker
having count(model)>=3
#21
select maker ,max(price) as Max_price
from product join pc on product.model = pc.model
group by maker
#22
select speed, avg(price) as Avg_price
from pc
where pc.speed >600
group by speed
#23
select distinct maker
from product q1 join pc d1  on q1.model = d1.model
where speed >= 750 and maker in (
select maker
from product q1 join laptop d1 on q1.model= d1.model
where speed>=750)
#24
with maxPrice as (
select model, price from pc
union all
select model, price from laptop
union all
select model,price from printer)
select distinct maxPrice.model from maxPrice where maxPrice.price  = (select max(price) from maxPrice)
#25
select distinct  maker
from product
where model in(
select model
from pc
where ram = (
select min(ram)
from pc
)and speed =(
select max(speed)
from pc
where ram = (
select min(ram)
from pc
)
)
)
and maker in (
select maker
from product
where type = 'printer'
)
#26
select sum (s.price)/sum(s.man) as middle from
(select price, 1 as man
from pc,product
where pc.model = product.model and
product.maker = 'A'
union all
select price,1 as man
from  laptop , product
where laptop.model = product.model and
product.maker ='A') as s
#27
select product.maker, avg(pc.hd)
from pc, product
where product.model = pc.model
and product.maker in (select distinct maker
from product
where product.type ='printer')
group by maker
#28
select count(maker)
from product
where maker in (
select maker
from product
group by maker
having count(model) = 1
)
#29
select e1.point, e1.date, inc, out
from income_o e1 left join outcome_o e2 on e1.point = e2.point
and e1.date = e2.date
union
select e2.point, e2.date, inc, out
from income_o e1  right join outcome_o e2 on e1.point = e2.point
and e1.date = e2.date
#31
select class, country
from classes
where bore >=16