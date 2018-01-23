setup 1:
download the mysql 


Setup 2:
start mysql
problem case:suspended animation
ps -ef | grep mysql  find the processID
kill -9 processID
ps -ef | grep mysqld

Setup3:
1)mysql stat/stop：sudo /usr/local/mysql/support-files/mysql.server start (stop)


2)sudo /Library/StartupItems/MySQLCOM/MYSQLCOM [start | stop | restart]
if it is running ,stop it first

Setup4:
Set environment variables
vim ~/.bash_profile
add blow setting line
alias mysqladmin /usr/local/mysql/bin/mysqladmin

Setup5:
4.enter the mysql
mysql -u root -p
password:kpt6vq+t!l-K


Setup6:
change the password
set password for root@localhost = password('root');

Finish



