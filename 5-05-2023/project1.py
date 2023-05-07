import mysql.connector
mydb=mysql.connector.connect(host='localhost',user='root',password='vyshu@2002sai')
print(mydb.connection_id)
cursor = mydb.cursor()
cursor.execute('create database Inventory_Management')
cursor.execute('use Inventory_Management')
# Create the 'manufacture' table
cursor.execute('CREATE TABLE manufacture (manufacture_id INTEGER PRIMARY KEY, item_name VARCHAR(20),company varchar(20),item_color VARCHAR(20),quantity INTEGER(4),defective_items INTEGER(4))')

# Create the 'goods' table
cursor.execute('CREATE TABLE goods (goods_id INTEGER(4) PRIMARY KEY, manufacture_id INTEGER, manufacture_date DATE,FOREIGN KEY(manufacture_id) REFERENCES manufacture(manufacture_id))')

# Create the 'purchase' table
cursor.execute('CREATE TABLE purchase (purchase_id INTEGER(4) PRIMARY KEY,item_name varchar(20)  ,store_name varchar(20),purchase_amount FLOAT, purchase_date DATE)')

# Create the 'sale' table
cursor.execute('CREATE TABLE sale (sale_id INTEGER(4) PRIMARY KEY,store_name VARCHAR(30),sale_date DATE,goods_id INTEGER(4), profit_margin FLOAT,FOREIGN KEY(goods_id) REFERENCES goods(goods_id))')

p1='insert into manufacture(manufacture_id ,item_name ,company,item_color ,quantity ,defective_items) values (%s,%s,%s,%s,%s,%s)'
entries1 = ('1', 'wooden chair','GARUD ENTERPRISES' ,'brown', '100', '0'), ('3', 'wooden table','SS EXPORT','brown', '50', '1'),('2', 'red toy','F3 TOYS','red', '200', '0'),('4','shirt','ADIDAS','black','300','1')
cursor.executemany(p1,entries1)
mydb.commit()
#Insert multiple entries to the 'goods' table
p2='insert into goods(goods_id , manufacture_id , manufacture_date)values (%s,%s,%s)'
entries2 = ('1', '1', '2023-04-20'),('2', '1', '2023-04-22'),('3', '2', '2023-04-25'),('4', '3', '2023-04-26')
cursor.executemany(p2,entries2)
mydb.commit()
# Insert multiple entries to the 'purchase' table
p3='insert into purchase(purchase_id ,item_name, store_name,purchase_amount,purchase_date)values(%s,%s,%s,%s,%s)'
entries3 = ('1','shirt' ,'ORay', '500', '2023-04-21'), ('2','sun glasses' ,'MyKids', '1000', '2023-04-22'),('3', 'soap','OnlineMart', '750', '2023-04-23')
cursor.executemany(p3,entries3)
mydb.commit()
# Insert multiple entries to the 'sale' table
p4='INSERT INTO sale(sale_id ,store_name ,sale_date,goods_id , profit_margin )values(%s,%s,%s,%s,%s)'
entries4 = ('1', 'MyCare', '2022-04-10', '1', '100'),(2, 'ORay', '2023-12-03', '2', '50'),('3', 'MyKids', '2021-04-05', '3', '75'),('4', 'OnlineMart', '2022-04-06', '4', '80')
cursor.executemany(p4,entries4)
mydb.commit()

#Queries
s='DELETE FROM purchase WHERE item_name = "shirt" AND purchase_date = "2023-04-01" AND store_name = "ORay"'
cursor.execute(s)
mydb.commit()

t='UPDATE manufacture SET quantity = 500 WHERE item_color = "red" AND manufacture_id IN (SELECT manufacture_id FROM goods WHERE goods_id IN (SELECT goods_id FROM sale WHERE store_name = "MyKids"))'
cursor.execute(t)
mydb.commit()


u='SELECT * FROM  goods JOIN manufacture ON goods.manufacture_id = manufacture.manufacture_id WHERE item_name = "wooden chair" AND manufacture_date< "2023-05-01"'
cursor.execute(u)
rows=cursor.fetchall()
for i in rows:
    print(i)