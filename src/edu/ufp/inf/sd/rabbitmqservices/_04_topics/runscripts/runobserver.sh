#!/usr/bin/env bash
#@REM ************************************************************************************
#@REM Description: run
#@REM Author: Rui S. Moreira
#@REM Date: 10/04/2018
#@REM ************************************************************************************
#@REM Script usage: runsetup <role> (where role should be: server / client)
source ./setenv.sh chatgui

export WORD_1=$1
export WORD_2=$2
export WORD_3=$3

#export JAVAPACKAGEROLEPATH=_03_pubsub/chatgui

echo ${ABSPATH2CLASSES}
cd ${ABSPATH2CLASSES}
#clear
#pwd
java -cp ${CLASSPATH} \
     ${JAVAPACKAGEROLEPATH}.${OBSERVER_CLASS_PREFIX} ${BROKER_HOST} ${BROKER_PORT} ${BROKER_EXCHANGE} ${WORD_1} ${WORD_2} ${WORD_3}


cd ${ABSPATH2SRC}/${JAVASCRIPTSPATH}
#pwd