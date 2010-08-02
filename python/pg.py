# This script can be used to make database queries in python. Only dependency is psycopg2 module.

# Install this package using one of these commands:
# apt-get install psycopg2
# yum install psycopg2
import psycopg2

f = open('out.txt')
of = open('final.txt', 'w+')
lines = f.readlines()
conn = psycopg2.connect('dbname=regolj user=regolj password=')
cur = conn.cursor()

for line in lines:
	userid = line[:-1]
	cur.execute('select name,discipline,enrollment_no,person_id,department,course,degree from person_extended where reg_status=0 and person_id=%s;',(userid,))
	string = str(cur.fetchone())
	if string != 'None' and string != '':
		of.write(string + '\n')
