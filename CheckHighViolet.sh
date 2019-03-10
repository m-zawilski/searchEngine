#!/usr/bin/env bash
FILES=($(ls HighViolet))

java -cp $PWD/out/production/SimpleSearch eu.zawilski.SimpleSearch $1 $(for val in ${FILES[@]}; do
   echo "HighViolet/$val"
done)