#!/bin/bash

filename='./list.txt'

while read line; do
  if [ ! -z "$line" ]; then
    password=$(openssl rand 200 | tr -dc [:alpha:] | head -c4)
    password+=$(openssl rand 200 | tr -dc [:digit:] | head -c4)

    name=$(echo $line | cut -d' ' -f 1)
    name+='.'
    name+=$(echo $line | cut -d' ' -f 2)
    name+='@matchit.com.br'
    name=${name,,}

    echo 'aws cognito-idp admin-create-user --region=us-east-1 --username' $name '--temporary-password' $password
  fi

done <$filename
