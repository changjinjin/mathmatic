#!/usr/bin/env bash
if [ ! -n "$1" ] ;then
  echo "you must input action info,and -e :encode, -d :decode !"
  exit 0
elif [ "$1" == "-e" ] || [ "$1" == "-d" ] ;then
  echo "the action you input is $1"
else
  echo "action parameter must be -e or -d"
fi

if [ ! -n "$2" ] ;then
  echo "For AES encrypt,you have not input a word!"
  exit 0
else
  echo "To AES encrypt,the word you input is $2"
fi
java  -Djadoid=AESUtils -Xms10M -Xmx256M  -cp classes:../lib/*:../conf/* com.merce.password.AesUtils $1 $2
