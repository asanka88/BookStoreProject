#!/bin/bash
Q0="DROP DATABASE IF EXISTS bookstoreDB;"
Q1="CREATE DATABASE bookstoreDB;"
Q3="USE bookstoreDB;"
Q4="SOURCE main.sql;"
SQL="${Q0}${Q1}${Q3}${Q4}"
 MYSQL=`which mysql`
 $MYSQL -uroot -proot -A -e "$SQL";

echo "database creation done==========================="